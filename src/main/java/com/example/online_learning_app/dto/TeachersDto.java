package com.example.online_learning_app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
