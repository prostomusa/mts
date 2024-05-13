package com.example.mts.controller;

import com.example.mts.dto.*;
import com.example.mts.service.PlaceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/place")
@RequiredArgsConstructor
@Tag(name = "API для мест, где проходят мероприятия")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/{id}")
    public ResponseEntity<PlaceResponse> getPlaceBy(@PathVariable Long id) {
        return ResponseEntity.ok(placeService.getPlaceById(id));
    }

    @PostMapping("/list")
    public List<PlaceListResponse> getPlaceList(@RequestBody PlaceListRequest placeListRequest) {
        return placeService.getPlaceList(placeListRequest);
    }
}
