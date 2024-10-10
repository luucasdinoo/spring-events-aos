package br.com.event.events.model.dto;

import br.com.event.events.model.entities.Event;

import java.time.LocalDateTime;

public class ParticipantResponseDto {

    private String name;
    private String email;
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventDate;

    public ParticipantResponseDto(String name,
                                  String email,
                                  String eventName,
                                  String eventDescription,
                                  LocalDateTime eventDate) {
        this.name = name;
        this.email = email;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    protected ParticipantResponseDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
