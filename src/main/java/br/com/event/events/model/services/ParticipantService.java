package br.com.event.events.model.services;

import br.com.event.events.model.dto.ParticipantResponseDto;
import br.com.event.events.model.entities.Event;
import br.com.event.events.model.entities.Participant;
import br.com.event.events.model.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final EventService eventService;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository,
                              EventService eventService) {
        this.participantRepository = participantRepository;
        this.eventService = eventService;
    }

    public Participant save(Participant participant){
        return participantRepository.save(participant);
    }

    public Participant getParticipantById(Long id){
        return participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("participant not found"));
    }

    public List<Participant> getParticipantsByEventId(Long eventId){
        return participantRepository.findAllByEventId(eventId);
    }

    public void addParticipant(Long eventId, Long participantId){
        Participant participantToAdd = getParticipantById(participantId);
        Event event = eventService.getEventById(eventId);

        event.getParticipants().add(participantToAdd);
        eventService.save(event);
        participantToAdd.setEvent(event);
        participantRepository.save(participantToAdd);
    }

    public void delete(Long id){
        Participant participantToDelete = getParticipantById(id);
        participantRepository.delete(participantToDelete);
    }

    public ParticipantResponseDto toResponse(Participant data){
        return new ParticipantResponseDto(data.getName(),
                data.getEmail(),
                data.getEvent().getName(),
                data.getEvent().getDescription(),
                data.getEvent().getDate());
    }
}
