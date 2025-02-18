package com.example.crm.crm_backend.controller;

import com.example.crm.crm_backend.dto.CalendarEventDTO;
import com.example.crm.crm_backend.entity.CalendarEvent;
import com.example.crm.crm_backend.entity.User;
import com.example.crm.crm_backend.repository.CalendarEventRepository;
import com.example.crm.crm_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendar")
@CrossOrigin("*")
public class CalendarEventController {

    @Autowired
    private CalendarEventRepository calendarEventRepository;

    @Autowired
    private UserRepository userRepository;

    public CalendarEventController(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @GetMapping // Pobiera wszystkie wydarzenia
    public ResponseEntity<List<CalendarEvent>> getAllEvents() {
        return ResponseEntity.ok(calendarEventRepository.findAll());
    }

    @GetMapping("/user") // Pobiera wydarzenia dla konkretnego użytkownika
    public ResponseEntity<List<CalendarEvent>> getEventsForUser(@RequestParam Long userId) {
        List<CalendarEvent> userEvents = calendarEventRepository.findByUserId(userId);
        return ResponseEntity.ok(userEvents);
    }

    // Dodawanie wydarzenia
    @PostMapping
    public ResponseEntity<?> addEvent(@RequestBody CalendarEvent event) {
        try {
            System.out.println("➡ Otrzymano żądanie: " + event);

            Optional<User> userOptional = userRepository.findById(1L); // Tymczasowy użytkownik ID=1
            if (userOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("Błąd: Nie znaleziono użytkownika");
            }

            event.setUser(userOptional.get()); // Ustawienie użytkownika
            CalendarEvent savedEvent = calendarEventRepository.save(event);

            System.out.println("✅ Zapisano wydarzenie: " + savedEvent);
            return ResponseEntity.ok(savedEvent);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Błąd zapisu: " + e.getMessage());
        }
    }


    // Edycja wydarzenia
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable Long id, @RequestBody CalendarEventDTO eventDto) {
        CalendarEvent event = calendarEventRepository.findById(id).orElseThrow();

        event.setDate(eventDto.getDate());
        event.setTime(eventDto.getTime()); // USTAWIAMY GODZINĘ
        event.setContent(eventDto.getContent());
        event.setColor(eventDto.getColor());

        calendarEventRepository.save(event);
        return ResponseEntity.ok("Event updated successfully!");
    }


    // Usunięcie wydarzenia
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        calendarEventRepository.deleteById(id);
        return ResponseEntity.ok("Event deleted successfully!");
    }
}