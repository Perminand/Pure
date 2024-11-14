package ru.perminov.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileService {
    Path save(MultipartFile file, long userId);
}
