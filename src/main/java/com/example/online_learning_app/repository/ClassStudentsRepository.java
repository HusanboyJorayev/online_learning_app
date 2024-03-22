package com.example.online_learning_app.repository;

import com.example.online_learning_app.entity.ClassStudents;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ClassStudentsRepository extends JpaRepository<ClassStudents, Integer> {
    Optional<ClassStudents> findByIdAndDeletedAtIsNull(Integer id);

}
