package ru.perminov.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.perminov.dto.UserDto;
import ru.perminov.dto.UserDtoOut;
import ru.perminov.service.user.UserService;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/apps/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userservice;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDtoOut> getAll() {
        log.info("Пришел GET запрос на получение пользователей");
        return userservice.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDtoOut getById(@PathVariable @Positive Long id) {
        log.info("Пришел Get запрос на получение User с id: {}", id);
        return userservice.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoOut create(@RequestBody UserDto userDto,
                             @RequestParam List<MultipartFile> files) {
        log.info("Пришел Post запрос на сохранение информации");
        return userservice.create(userDto, files);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  UserDtoOut update(@RequestBody UserDto userDto, @PathVariable @Positive Long id) {
        return userservice.update(userDto, id);
    }
}
