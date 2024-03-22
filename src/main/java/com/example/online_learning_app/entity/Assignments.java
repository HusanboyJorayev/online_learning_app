package com.example.online_learning_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignments")
public class Assignments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "assigmentId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<AssigmentSubmissions>assigmentSubmissions;
}
