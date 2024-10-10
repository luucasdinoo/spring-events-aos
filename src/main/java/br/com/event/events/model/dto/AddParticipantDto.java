package br.com.event.events.model.dto;

public class AddParticipantDto {

    private Long participantId;
    private Long eventId;

    protected AddParticipantDto() {}

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
