package de.ait.listtasks.dto;


import de.ait.listtasks.validation.constraints.NotWeakPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Данные для добавления пользователя")
public class NewUserDto {

    @Schema(description = "Email пользователя", example = "simple@mail.com")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Schema(description = "Пароль пользователя", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 1000)
    @NotWeakPassword
    private String password;
}
