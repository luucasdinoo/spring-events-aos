package br.com.event.events.model.dto;

import br.com.event.events.model.entities.Local;
import br.com.event.events.model.entities.Organizer;
import br.com.event.events.model.entities.Participant;

import java.time.LocalDateTime;
import java.util.List;

public class EventResponseDto {

    private String name;
    private String description;
    private LocalDateTime localDateTime;
    private Organizer organizer;
    private Local local;
    private final List<Participant> participants;

    public EventResponseDto(String name,
                            String description,
                            LocalDateTime localDateTime,
                            Organizer organizer,
                            Local local,
                            List<Participant> participants) {
        this.name = name;
        this.description = description;
        this.localDateTime = localDateTime;
        this.organizer = organizer;
        this.local = local;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
