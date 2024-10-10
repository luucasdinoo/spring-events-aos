package br.com.event.events.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class EventCreateDto {

    @Size(min = 3, max = 200)
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @FutureOrPresent
    private LocalDateTime localDateTime;

    @NotNull
    @Positive
    private Long organizerId;

    @NotNull
    @Positive
    private Long localId;

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

    public LocalDateTime getDate() {
        return localDateTime;
    }

    public void setDate(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }
}
