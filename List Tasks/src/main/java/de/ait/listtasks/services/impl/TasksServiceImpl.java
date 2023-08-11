package de.ait.listtasks.services.impl;

import de.ait.listtasks.dto.NewTaskDto;
import de.ait.listtasks.dto.TaskDto;
import de.ait.listtasks.exceptions.IncorrectUserIdException;
import de.ait.listtasks.models.Task;
import de.ait.listtasks.models.User;
import de.ait.listtasks.repositories.TasksRepository;
import de.ait.listtasks.repositories.UsersRepository;
import de.ait.listtasks.services.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import static de.ait.listtasks.dto.UserDto.from;

@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

  private final UsersRepository usersRepository;

  private final TasksRepository tasksRepository;

  @Override
  public TaskDto addTask(NewTaskDto newTask) {
    User user = usersRepository.findById(newTask.getExecutorUserId())
        .orElseThrow(() ->
            new IncorrectUserIdException("Id <" + newTask.getExecutorUserId() + "> is not correct"));

    Task task = Task.builder()
        .title(newTask.getTitle())
        .description(newTask.getDescription)
        .executor(user)
        .startDate(LocalDate.parse(newTask.getStartDate()))
        .finishDate(LocalDate.parse(newTask.getFinishDate()))
        .build();

    tasksRepository.save(task);

    return from(task);
  }
}
