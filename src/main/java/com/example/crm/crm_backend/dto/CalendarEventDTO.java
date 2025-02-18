package com.example.crm.crm_backend.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarEventDTO {
    private Long userId;
    private LocalDate date;

    private LocalTime time;
    private String content;

    private String description;
    private String color;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CalendarEventDTO(Long userId, LocalTime time, LocalDate date, String content, String description, String color) {
        this.userId = userId;
        this.date = date;
        this.content = content;
        this.color = color;
        this.time = time;
        this.description = description;
    }

    public CalendarEventDTO(){

    }
}

