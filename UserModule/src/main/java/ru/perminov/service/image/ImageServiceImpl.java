package ru.perminov.service.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.perminov.model.Image;
import ru.perminov.repository.ImageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private final ImageRepository imageRepository;

    public List<Image> getImagesById(long id) {
        List<Image> images = imageRepository.findByUserId(id);
        return images;
    }
}
