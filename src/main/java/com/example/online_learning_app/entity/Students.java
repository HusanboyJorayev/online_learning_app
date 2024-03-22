package com.example.online_learning_app.entity;

import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String status;
    private String password;
    private String verificationCode;
    private String profileImage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "studentId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssigmentSubmissions> assigmentSubmissions;

    @OneToMany(mappedBy = "studentId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ClassStudents> classStudents;
}
