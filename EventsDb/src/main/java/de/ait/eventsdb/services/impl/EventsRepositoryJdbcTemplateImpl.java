package de.ait.eventsdb.services.impl;

import de.ait.eventsdb.models.Event;
import de.ait.eventsdb.repositories.EventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventsRepositoryJdbcTemplateImpl implements EventsRepository {

  //language=SQL
  private static final String SQL_SELECT_ALL = "select * from events;"; // sql запрос

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Event> findAll() { // выполнение sql запроса
    return jdbcTemplate.query(SQL_SELECT_ALL, (row, rowNumber) -> Event.builder() // вернулась строка и номер строки, а надо из этого получить объект
        .id(row.getLong("id")) // из строки row забираем Long, который называется id
        .description(row.getString("description")) // забираем строку, которая называется description
        .title(row.getString("title")) // забираем строку, которая называется title
        .build());
  }      // Собираем евент по его характеристикам
  // Вытаскиваем евент (объект) из базы
}        // row - строка, rowNumber - номер строки
// мы здесь описываем правила как отобразить строку из Базы Данных в объект

