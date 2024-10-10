package br.com.event.events.controller;

import br.com.event.events.model.entities.Organizer;
import br.com.event.events.model.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizer")
public class OrganizerController {

    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @PostMapping
    public ResponseEntity<Organizer> addOrganizer(@RequestBody Organizer request) {
        Organizer response = organizerService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        Organizer response = organizerService.getOrganizerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
