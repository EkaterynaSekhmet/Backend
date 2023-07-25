package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;


public interface EventsRepository {
    void save(Event event);
}
