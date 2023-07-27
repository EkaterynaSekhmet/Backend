package de.ait.timepad.services.impl;

import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.EventsRepository;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;




@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    @Override
    public Event addEvent(Event event) {
        event.setState(Event.State.PLANNED);
        eventsRepository.save(event);
        return event;
    }
}
