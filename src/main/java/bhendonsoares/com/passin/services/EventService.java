package bhendonsoares.com.passin.services;

import bhendonsoares.com.passin.domain.attendee.Attendee;
import bhendonsoares.com.passin.domain.event.Event;
import bhendonsoares.com.passin.domain.event.exceptions.EventNotFoundException;
import bhendonsoares.com.passin.dto.event.EventIdDTO;
import bhendonsoares.com.passin.dto.event.EventRequestDTO;
import bhendonsoares.com.passin.dto.event.EventResponseDTO;
import bhendonsoares.com.passin.repositories.AttendeeRepository;
import bhendonsoares.com.passin.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventResponseDTO getEventDetail(String eventId) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }

    public EventIdDTO createEvent(EventRequestDTO eventDTO) {
       Event newEvent = new Event();
       newEvent.setTitle(eventDTO.title());
       newEvent.setDetails(eventDTO.details());
       newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
       newEvent.setSlug(this.createSlug(eventDTO.title()));

       this.eventRepository.save(newEvent);

       return new EventIdDTO(newEvent.getId());
    }

    private String createSlug(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("\\s+", "-")
                .toLowerCase();
    }
}
