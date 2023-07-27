package de.ait.timepad.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    public enum State {
        PLANNED,
        REALIZED,
        DELETED
    }
    private Long id; // используем только ссылочные типы в моделях, п что может быть использован null
    private String date; // дата
    private String name; // название

    private State state; // статус

    private List<Event> events;
}
