package com.example.online_learning_app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassesDto {

    private Integer id;
    private Integer teacherId;
    private String name;
    private String description;
    private String featuredImage;
    private String schedule;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
