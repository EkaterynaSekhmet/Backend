package de.ait.eventsdb.dto;

import de.ait.eventsdb.models.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {

  private Long id;

  private String description; // описание евента

  private String title; // название евента

  public static EventDto from(Event user) { // Функция from из моедели-евента делает дтошку
    return EventDto.builder()
        .id(user.getId())
        .description(user.getDescription())
        .title(user.getTitle())
        .build();
  }

  public static List<EventDto> from(List<Event> users) { // Тут нужно еще документацию написать на
    return users.stream()                              // все поля (Свагер)
        .map(EventDto::from)
        .collect(Collectors.toList()); // Эта ф-я список моделей-евентов превращает в дтошки
  }
}