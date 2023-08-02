package de.ait.eventsdb.services;

import de.ait.eventsdb.dto.EventDto;

import java.util.List;

public interface EventsService {
  List<EventDto> getAllEvents();
}
