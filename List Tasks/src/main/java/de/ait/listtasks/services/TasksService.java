package de.ait.listtasks.services;

import de.ait.listtasks.dto.NewTaskDto;
import de.ait.listtasks.dto.TaskDto;

public interface TasksService {
  TaskDto addTask(NewTaskDto newTask);
}
