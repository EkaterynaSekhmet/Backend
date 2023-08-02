package de.ait.eventsdb.controllers;

import de.ait.eventsdb.api.EventsApi;
import de.ait.eventsdb.dto.EventDto;
import de.ait.eventsdb.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EventsController implements EventsApi { // Реализует апишку

  private final EventsService eventsService;

  @Override
  public List<EventDto> getAllEvents() {
    return eventsService.getAllEvents(); // вызов метода Сервиса
  }
}
