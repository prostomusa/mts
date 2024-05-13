package com.example.mts.service;

import com.example.mts.dto.*;
import com.example.mts.entity.*;
import com.example.mts.exception.NotFoundException;
import com.example.mts.repository.EventRepository;
import com.example.mts.repository.PlaceRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    private final EventRepository eventRepository;

    public List<PlaceListResponse> getPlaceList(PlaceListRequest request) {
        Specification<PlaceEntity> specification = (root, query, cb) -> {
            Predicate predicate = cb.and(
                    request.getName() == null ? cb.and() : cb.like(root.get(PlaceEntity.Fields.name), request.getName()),
                    request.getCity() == null ? cb.and() : cb.like(root.get(PlaceEntity.Fields.city), request.getCity())
            );

            return predicate;
        };
        List<PlaceListResponse> response = new ArrayList<>();
        var placeList = placeRepository.findAll(specification);
        if (!placeList.isEmpty()) {
            placeList.forEach(place -> {
                response.add(new PlaceListResponse(
                        place.getName(),
                        place.getCity(),
                        place.getDescription()
                ));
            });
        }
        return response;
    }

    public PlaceResponse getPlaceById(Long id) {
        Optional<PlaceEntity> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isEmpty()) {
            throw new NotFoundException(String.format("Места с id = %d не найден", id));
        }
        var place = optionalPlace.get();
        List<EventListResponse> eventListResponses = getEventList(place);
        return new PlaceResponse(
                place.getName(),
                place.getCity(),
                place.getDescription(),
                eventListResponses
        );
    }

    public List<EventListResponse> getEventList(PlaceEntity place) {
        List<EventListResponse> eventListResponses = new ArrayList<>();
        List<EventEntity> eventEntityList = eventRepository.findAllByScenePlaceId(place.getId());
        eventEntityList.forEach(eventEntity -> {
            boolean hasSeatForDisabled = eventEntity.getScene().getSeats().stream().anyMatch(seatEntity -> SeatTypeEntity.SeatTypeEnum.DISABLED.equals(seatEntity.getSeatType().getTitle()));
            eventListResponses.add(new EventListResponse(
                    eventEntity.getName(),
                    eventEntity.getScene().getPlace().getName(),
                    eventEntity.getMinAge(),
                    hasSeatForDisabled)
            );
        });
        return eventListResponses;
    }
}
