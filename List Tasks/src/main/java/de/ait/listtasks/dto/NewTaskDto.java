package de.ait.listtasks.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Добавляемая задача")
public class NewTaskDto {

    @Schema(description = "Текст задачи", example = "Текст о пользователе...")
    private String text;

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long aboutUserId;

    @Schema(description = "Дата публикации в формате YYYY-MM-DD", example = "2022-02-02")
    private String publishDate;
}