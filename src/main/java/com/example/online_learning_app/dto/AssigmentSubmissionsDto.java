package com.example.online_learning_app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssigmentSubmissionsDto {

    private Integer id;
    private Integer assigmentId;
    private Integer studentId;
    private String selectedOption;
    private String textInput;
    private String attachment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
