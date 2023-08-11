package de.ait.listtasks.controllers;


import de.ait.listtasks.controllers.api.TasksApi;
import de.ait.listtasks.dto.NewTaskDto;
import de.ait.listtasks.dto.TaskDto;
import de.ait.listtasks.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TasksController implements TasksApi {

  private final TasksService tasksService;

  @Override
  public ResponseEntity<TaskDto> addTask(NewTaskDto newTask) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(tasksService.addTask(newTask));
  }
}