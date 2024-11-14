package ru.perminov.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.nio.file.Path;

@Entity
@Builder
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Long userId;

    @NotBlank
    private String originalFileName;

    @NotBlank
    private Path filePath;
}
