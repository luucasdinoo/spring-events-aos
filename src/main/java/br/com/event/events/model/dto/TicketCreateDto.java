package br.com.event.events.model.dto;

public class TicketCreateDto {

    private String typeTicket;
    private Double price;
    private Long eventId;

    public TicketCreateDto(String typeTicket, Double price, Long eventId) {
        this.typeTicket = typeTicket;
        this.price = price;
        this.eventId = eventId;
    }

    protected TicketCreateDto() {}

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
