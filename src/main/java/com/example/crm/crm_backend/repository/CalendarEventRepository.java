package com.example.crm.crm_backend.repository;

import com.example.crm.crm_backend.entity.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
    // Pobiera wydarzenia dla konkretnego użytkownika
    List<CalendarEvent> findByUserId(Long userId);
    List<CalendarEvent> findByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
