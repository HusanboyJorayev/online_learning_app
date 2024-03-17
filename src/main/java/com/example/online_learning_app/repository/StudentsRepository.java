package com.example.online_learning_app.repository;

import com.example.online_learning_app.entity.Students;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {

    Optional<Students> findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select t from Students as t where t.id=:id or\s
            t.email=:email or t.name=:name or t.password=:password or\s
            t.status=:status or t.verificationCode=:verificationCode
            """)
    List<Students> universalSearch(Integer id, String name, String email, String status, String password, String verificationCode);
}
