package br.com.event.events.controller;

import br.com.event.events.model.dto.TicketCreateDto;
import br.com.event.events.model.entities.Ticket;
import br.com.event.events.model.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketCreateDto request) {
        Ticket response = ticketService.createTicket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket response = ticketService.getTicketById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
