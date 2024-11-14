package ru.perminov.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import ru.perminov.marker.Create;

import java.time.LocalDate;

@Getter
public class UserDto {
    private Long id;

    @NotBlank(groups = Create.class)
    private String username;

    @NotBlank(groups = Create.class)
    private String password;

    @NotBlank(groups = Create.class)
    private String email;
    private String city;
    private LocalDate birthday;
    private Integer height;
}
