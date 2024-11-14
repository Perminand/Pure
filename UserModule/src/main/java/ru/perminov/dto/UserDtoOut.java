package ru.perminov.dto;

import lombok.Builder;
import lombok.Setter;
import ru.perminov.model.Image;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
public class UserDtoOut {
    private Long id;
    private String username;
    private String email;
    private String city;
    private LocalDate birthday;
    private Integer height;
    private List<Image> images;

}
