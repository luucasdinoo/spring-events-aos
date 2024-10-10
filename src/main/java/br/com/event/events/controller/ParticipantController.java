package br.com.event.events.controller;

import br.com.event.events.model.dto.AddParticipantDto;
import br.com.event.events.model.dto.ParticipantResponseDto;
import br.com.event.events.model.entities.Participant;
import br.com.event.events.model.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant request) {
        Participant response = participantService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addParticipant(@RequestBody AddParticipantDto request) {
        participantService.addParticipant(request.getEventId(), request.getParticipantId());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantResponseDto> getParticipantById(@PathVariable Long id) {
        Participant participant = participantService.getParticipantById(id);
        ParticipantResponseDto response = participantService.toResponse(participant);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getParticipantsByEventId/{eventId}")
    public ResponseEntity<List<Participant>> getParticipantsByEventId(@PathVariable Long eventId) {
        List<Participant> participants = participantService.getParticipantsByEventId(eventId);
        return ResponseEntity.status(HttpStatus.OK).body(participants);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        participantService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
