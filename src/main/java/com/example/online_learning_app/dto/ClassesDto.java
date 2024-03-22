package com.example.online_learning_app.dto;

import com.example.online_learning_app.entity.Assignments;
import com.example.online_learning_app.entity.ClassResources;
import com.example.online_learning_app.entity.ClassStudents;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    private List<AssignmentsDto> assignments;
    private List<ClassResourcesDto>classResources;
    private List<ClassStudentsDto>classStudents;

}
