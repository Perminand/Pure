package ru.perminov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perminov.model.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByUserId(long id);
}
