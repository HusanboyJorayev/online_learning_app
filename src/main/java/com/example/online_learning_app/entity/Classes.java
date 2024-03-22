package com.example.online_learning_app.entity;

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
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer teacherId;
    private String name;
    private String description;
    private String featuredImage;
    private String schedule;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "classId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Assignments>assignments;

    @OneToMany(mappedBy = "classId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ClassResources>classResources;

    @OneToMany(mappedBy = "classId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ClassStudents>classStudents;

}
