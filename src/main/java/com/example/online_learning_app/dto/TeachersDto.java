package com.example.online_learning_app.dto;

import com.example.online_learning_app.entity.Classes;
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
public class TeachersDto {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String status;
    private String verificationCode;
    private String profileImage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private List<ClassesDto> classes;
}
