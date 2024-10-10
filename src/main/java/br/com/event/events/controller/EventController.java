package br.com.event.events.controller;

import br.com.event.events.model.dto.EventCreateDto;
import br.com.event.events.model.dto.EventResponseDto;
import br.com.event.events.model.entities.Event;
import br.com.event.events.model.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@RequestBody EventCreateDto request) {
        Event event = eventService.createEvent(request);
        EventResponseDto response = eventService.toResponse(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        EventResponseDto response = eventService.toResponse(event);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/findByOrganizer/{organizerId}")
    public ResponseEntity<List<Event>> getEventsByOrganizer(@PathVariable Long organizerId) {
        List<Event> response = eventService.getEventsByOrganizerId(organizerId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/findByLocal/{localId}")
    public ResponseEntity<List<Event>> getEventsByLocalId(@PathVariable Long localId) {
        List<Event> response = eventService.getEventsByLocalId(localId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable Long id, @RequestBody EventCreateDto request) {
        eventService.updateEvent(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
