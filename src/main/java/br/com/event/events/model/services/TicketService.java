package br.com.event.events.model.services;

import br.com.event.events.model.dto.TicketCreateDto;
import br.com.event.events.model.entities.Event;
import br.com.event.events.model.entities.Ticket;
import br.com.event.events.model.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventService eventService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, EventService eventService) {
        this.ticketRepository = ticketRepository;
        this.eventService = eventService;
    }

    public Ticket createTicket(TicketCreateDto data){
        Event event = eventService.getEventById(data.getEventId());
        return ticketRepository.save(new Ticket(data.getTypeTicket(), data.getPrice(), event));
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}
