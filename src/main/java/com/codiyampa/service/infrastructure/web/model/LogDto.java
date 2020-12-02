package com.codiyampa.service.infrastructure.web.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: Codiyampa
 * @date: 02.12.2020
 */

public class LogDto implements Serializable {
    private Long id;
    private LocalDateTime creationDate;
    private String message;

    public LogDto() { }

    public LogDto(Long id, LocalDateTime creationDate, String message) {
        this.id = id;
        this.creationDate = creationDate;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}