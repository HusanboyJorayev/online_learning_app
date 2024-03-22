package com.example.online_learning_app.repository;

import com.example.online_learning_app.entity.Assignments;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AssignmentsRepository extends JpaRepository<Assignments,Integer> {
    Optional<Assignments>findByIdAndDeletedAtIsNull(Integer id);

}
