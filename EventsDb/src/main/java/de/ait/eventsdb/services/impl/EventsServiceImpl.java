package de.ait.eventsdb.services.impl;

import de.ait.eventsdb.dto.EventDto;
import de.ait.eventsdb.repositories.EventsRepository;
import de.ait.eventsdb.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.eventsdb.dto.EventDto.from;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

  private final EventsRepository eventsRepository; // Сервис возвращает результат из Репозитория

  @Override
  public List<EventDto> getAllEvents() {
    return from(eventsRepository.findAll());
  }

}
