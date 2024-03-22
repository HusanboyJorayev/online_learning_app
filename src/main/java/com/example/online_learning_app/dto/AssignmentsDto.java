package com.example.online_learning_app.dto;

import com.example.online_learning_app.entity.AssigmentSubmissions;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignmentsDto {

    private Integer id;
    private Integer classId;
    private String question;
    private String option;
    private String correctOption;
    private LocalDateTime deadLine;
    private String attachment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private List<AssigmentSubmissionsDto> assigmentSubmissions;
}
