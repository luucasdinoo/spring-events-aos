package br.com.event.events.model.repositories;

import br.com.event.events.model.entities.Event;
import br.com.event.events.model.entities.Local;
import br.com.event.events.model.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByOrganizer(Organizer organizer);
    List<Event> findAllByLocal(Local local);
}
