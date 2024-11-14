package ru.perminov.service.user;

import org.springframework.web.multipart.MultipartFile;
import ru.perminov.dto.UserDto;
import ru.perminov.dto.UserDtoOut;

import java.util.List;

public interface UserService {
    List<UserDtoOut> getAll();

    UserDtoOut getById(Long id);

    UserDtoOut create(UserDto userDto, List<MultipartFile> files);

    UserDtoOut update(UserDto userDto, Long id);
}
