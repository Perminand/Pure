package ru.perminov.mappers;

import ru.perminov.dto.UserDto;
import ru.perminov.dto.UserDtoOut;
import ru.perminov.model.User;

public class UserMapper {
    public static UserDtoOut toDto (User user) {
        return UserDtoOut.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .city(user.getCity())
                .birthday(user.getBirthday())
                .height(user.getHeight())
                .images(user.getImages())
                .build();
    }

    public static User toEntity (UserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .city(dto.getCity())
                .birthday(dto.getBirthday())
                .height(dto.getHeight())
                .build();
    }
}
