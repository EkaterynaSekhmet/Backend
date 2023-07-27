package de.ait.timepad.controllers;
import de.ait.timepad.models.Event;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class EventsController {

    private final EventsService eventsService;
    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Event addEvent(@RequestBody Event event){ // добавление события
        return eventsService.addEvent(event);

    }

}
