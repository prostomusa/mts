package com.example.mts.controller;

import com.example.mts.dto.EventListRequest;
import com.example.mts.dto.EventListResponse;
import com.example.mts.dto.EventResponse;
import com.example.mts.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
@Tag(name = "API для мероприятий")
public class EventController {

    private final EventService eventService;

    @PostMapping("/list")
    public List<EventListResponse> getListEvent(@RequestBody EventListRequest eventListRequest) {
        return eventService.getEventList(eventListRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/place/{id}")
    public List<EventListResponse> getEventsByPlace(@PathVariable Long placeId) {
        return eventService.getEventsByPlaceId(placeId);
    }
}
