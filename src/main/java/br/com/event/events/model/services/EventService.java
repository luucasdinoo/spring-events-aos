package br.com.event.events.model.services;

import br.com.event.events.model.dto.EventCreateDto;
import br.com.event.events.model.dto.EventResponseDto;
import br.com.event.events.model.entities.Event;
import br.com.event.events.model.entities.Local;
import br.com.event.events.model.entities.Organizer;
import br.com.event.events.model.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final OrganizerService organizerService;
    private final LocalService localService;

    @Autowired
    public EventService(EventRepository eventRepository,
                        OrganizerService organizerService,
                        LocalService localService) {
        this.eventRepository = eventRepository;
        this.organizerService = organizerService;
        this.localService = localService;
    }

    public Event createEvent(EventCreateDto data) {
        Local local = localService.getLocalById(data.getLocalId());
        Organizer organizer = organizerService.getOrganizerById(data.getOrganizerId());
        Event event = eventRepository.save(
                new Event(data.getName(), data.getDescription(), data.getDate(), organizer, local));
        local.getEvents().add(event);
        localService.save(local);
        organizer.getEvents().add(event);
        organizerService.save(organizer);
        return event;
    }

    public Event save(Event data) {
        return eventRepository.save(data);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> getEventsByOrganizerId(Long organizerId) {
        Organizer organizer = organizerService.getOrganizerById(organizerId);
        return eventRepository.findAllByOrganizer(organizer);
    }

    public List<Event> getEventsByLocalId(Long localId) {
        Local local = localService.getLocalById(localId);
        return eventRepository.findAllByLocal(local);
    }

    public void updateEvent(Long id, EventCreateDto data) {
        Event event = getEventById(id);
        Event updated = update(event, data);
        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event eventToDelete = getEventById(id);
        eventRepository.delete(eventToDelete);
    }

    public EventResponseDto toResponse(Event data) {
        return new EventResponseDto(
                        data.getName(),
                        data.getDescription(),
                        data.getDate(),
                        data.getOrganizer(),
                        data.getLocal(),
                        data.getParticipants());
    }

    public Event update(Event current, EventCreateDto data) {
        current.setName(data.getName());
        current.setDescription(data.getDescription());
        current.setDate(data.getDate());

        Local local = localService.getLocalById(data.getLocalId());
        Organizer organizer = organizerService.getOrganizerById(data.getOrganizerId());

        current.setOrganizer(organizer);
        current.setLocal(local);
        return current;
    }
}
