package de.ait.listtasks.controllers.api;

import de.ait.listtasks.dto.NewTaskDto;
import de.ait.listtasks.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Tags(value = {
    @Tag(name = "Tasks")
})
@RequestMapping("/api/tasks")
public interface TasksApi {

  @Operation(summary = "Создание задачи для пользователя", description = "Доступно только всем пользователям")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "422", description = "Пользователь с указанным ID отсутствует в системе",
          content = {
              @Content()
          }),
      @ApiResponse(responseCode = "201", description = "Добавленная задача",
          content = {
              @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
          })
  })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<TaskDto> addTask(@RequestBody NewTaskDto newTask);

}
