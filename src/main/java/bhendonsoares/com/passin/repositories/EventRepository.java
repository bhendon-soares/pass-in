package bhendonsoares.com.passin.repositories;

import bhendonsoares.com.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
