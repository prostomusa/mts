package com.example.mts.service;

import com.example.mts.dto.*;
import com.example.mts.entity.*;
import com.example.mts.exception.NotFoundException;
import com.example.mts.repository.ConcreteEventRepository;
import com.example.mts.repository.PlaceRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {

    private final ConcreteEventRepository concreteEventRepository;

    private final PlaceRepository placeRepository;

    private final PlaceService placeService;

    public List<EventListResponse> getEventList(EventListRequest request) {
        Specification<ConcreteEventEntity> specification = (root, query, cb) -> {
            Predicate predicate = cb.and(
                request.getMinAge() == null ? cb.and() : cb.greaterThanOrEqualTo(root.get(ConcreteEventEntity.Fields.event).get(EventEntity.Fields.minAge), request.getMinAge()),
                request.getEventType() == null ? cb.and() : cb.equal(root.get(ConcreteEventEntity.Fields.event).get(EventEntity.Fields.eventType).get(EventTypeEntity.Fields.name), request.getEventType()),
                request.getHasSeatForDisabled() == null || !request.getHasSeatForDisabled() ? cb.and() : cb.equal(root.get(ConcreteEventEntity.Fields.event).get(EventEntity.Fields.scene).get(SceneEntity.Fields.seats).get(SeatEntity.Fields.seatType).get(SeatTypeEntity.Fields.title), SeatTypeEntity.SeatTypeEnum.DISABLED)
        );

            return predicate;
        };
        List<EventListResponse> response = new ArrayList<>();
        var eventList = concreteEventRepository.findAll(specification);
        if (!eventList.isEmpty()) {
            eventList.forEach(concreteEvent -> {
                boolean hasSeatForDisabled = concreteEvent.getEvent().getScene().getSeats().stream().anyMatch(seatEntity -> SeatTypeEntity.SeatTypeEnum.DISABLED.equals(seatEntity.getSeatType().getTitle()));
                response.add(new EventListResponse(
                        concreteEvent.getEvent().getName(),
                        concreteEvent.getEvent().getScene().getPlace().getName(),
                        concreteEvent.getEvent().getMinAge(),
                        hasSeatForDisabled)
                );
            });
        }
        return response;
    }

    public EventResponse getEventById(Long id) {
        Optional<ConcreteEventEntity> optionalEvent = concreteEventRepository.findById(id);
        if (optionalEvent.isEmpty()) {
            throw new NotFoundException(String.format("Событие с id = %d не найден", id));
        }
        var concreteEvent = optionalEvent.get();
        boolean hasSeatForDisabled = concreteEvent.getEvent().getScene().getSeats().stream().anyMatch(seatEntity -> SeatTypeEntity.SeatTypeEnum.DISABLED.equals(seatEntity.getSeatType().getTitle()));
        return new EventResponse(
                concreteEvent.getEvent().getName(),
                concreteEvent.getEvent().getDescription(),
                concreteEvent.getEvent().getEventType().getName(),
                concreteEvent.getEventStart(),
                concreteEvent.getEventEnd(),
                concreteEvent.getEvent().getScene().getPlace().getName(),
                concreteEvent.getEvent().getScene().getName(),
                concreteEvent.getEvent().getMinAge(),
                hasSeatForDisabled,
                concreteEvent.getEvent().getCanHelpDisabled(),
                getSeatListForConcreteEvent(concreteEvent)
        );
    }

    public List<EventListResponse> getEventsByPlaceId(Long placeId) {
        Optional<PlaceEntity> optionalPlace = placeRepository.findById(placeId);
        if (optionalPlace.isEmpty()) {
            throw new NotFoundException(String.format("Места с id = %d не найден", placeId));
        }
        var place = optionalPlace.get();
        return placeService.getEventList(place);
    }

    private List<Seat> getSeatListForConcreteEvent(ConcreteEventEntity concreteEvent) {
        Set<Long> reservedSeats = concreteEvent.getConcreteEventUsers()
                .stream()
                .flatMap(concreteEventUsersEntity -> concreteEventUsersEntity.getConcreteEventUsersSeat().stream())
                .map(ConcreteEventUsersSeatEntity::getSeat)
                .map(AbstractEntity::getId)
                .collect(Collectors.toSet());
        return concreteEvent.getEvent().getScene().getSeats().stream()
                .map(seat -> new Seat(
                       seat.getId(),
                       seat.getTitle(),
                       seat.getSeatType().getTitle(),
                       reservedSeats.contains(seat.getId())
               ))
                .toList();
    }
}