package de.ait.eventsdb.api;

import de.ait.eventsdb.dto.EventDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/events") // Здесь просто документация и объявление методов
public interface EventsApi {

  @GetMapping
  List<EventDto> getAllEvents(); // Описание метода
}
