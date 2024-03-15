package com.example.online_learning_app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassStudentsDto {

    private Integer id;
    private Integer classId;
    private Integer studentId;
    private LocalDateTime classTime;
    private Integer visitCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
