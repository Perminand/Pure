package ru.perminov.service.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.perminov.dto.UserDto;
import ru.perminov.dto.UserDtoOut;
import ru.perminov.mappers.UserMapper;
import ru.perminov.model.Image;
import ru.perminov.model.User;
import ru.perminov.repository.UserRepository;
import ru.perminov.service.file.FileService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FileService fileService;

    @Override
    public List<UserDtoOut> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDtoOut getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Пользователь не найден."));
        return UserMapper.toDto(user);
    }

    @Override
    public UserDtoOut create(UserDto userDto, List<MultipartFile> files) {
        User user = UserMapper.toEntity(userDto);
        userRepository.save(user);

        if (user.getImages() == null) {
            user.setImages(new ArrayList<>());
        }

        List<Image> images = user.getImages();
        for (MultipartFile file : files) {
            images.add(Image.builder()
                    .userId(user.getId())
                    .originalFileName(file.getOriginalFilename())
                    .filePath(fileService.save(file, user.getId()))
                    .build());
        }

        user.setImages(images);
        return UserMapper.toDto(user);
    }

    @Override
    public UserDtoOut update(UserDto userDto, Long id) {
        return null;
    }
}
