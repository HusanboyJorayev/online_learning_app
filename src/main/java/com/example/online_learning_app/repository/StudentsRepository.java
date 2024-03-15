package com.example.online_learning_app.repository;

import com.example.online_learning_app.entity.Students;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students,Integer> {

    Optional<Students>findByIdAndDeletedAtIsNull(Integer id);
}
