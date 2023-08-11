package de.ait.listtasks.dto;

import de.ait.listtasks.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Задача какого-либо пользователя")
public class TaskDto {

    @Schema(description = "Идентификатор задачи", example = "1")
    private Long id;

    @Schema(description = "Название задачи", example = "Текст о каком-либо пользователе...")
    private String title;

    @Schema(description = "Описание задачи", example = "Текст о каком-либо пользователе...")
    private String description;

    @Schema(description = "Исполнитель задачи")
    private UserInTaskDto executor;

    @Schema(description = "Дата начала выполненя задачи в формате YYYY-MM-DD", example = "2022-02-02")
    private LocalDate startDate;

    @Schema(description = "Дата окончания выполненя задачи в формате YYYY-MM-DD", example = "2022-02-02")
    private LocalDate finishDate;

    public static TaskDto from(Task task) {
        TaskDto result = TaskDto.builder()
            .id(task.getId())
            .title(task.getTitle())
            .description(task.getDescription())
            .startDate(task.getStartDate())
            .finishDate(task.getFinishDate())
            .build();

       if (task.getExecutor() != null) {
            result.setExecutor(UserInTaskDto.from(task.getExecutor()));
        }

        if (task.getStartDate() != null) {
            result.setStartDate(LocalDate.parse(task.getStartDate().toString()));
        }

        if (task.getFinishDate() != null) {
            result.setFinishDate(LocalDate.parse(task.getFinishDate().toString()));
        }

        return result;
    }

    public static List<TaskDto> from(List<Task> tasks) {
        return tasks.stream()
            .map(TaskDto::from)
            .collect(Collectors.toList());
    }
}