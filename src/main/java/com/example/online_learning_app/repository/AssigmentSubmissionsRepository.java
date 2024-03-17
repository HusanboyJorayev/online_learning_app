package com.example.online_learning_app.repository;

import com.example.online_learning_app.entity.AssigmentSubmissions;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssigmentSubmissionsRepository extends JpaRepository<AssigmentSubmissions, Integer> {
    Optional<AssigmentSubmissions> findByIdAndDeletedAtIsNull(Integer id);

    @Query("""
            select  s from AssigmentSubmissions as s where s.id=:id or s.assigmentId=:assigmentId or
             s.studentId=:studentId or s.selectedOption=:selectedOption or\s
             s.textInput=:textInput or s.attachment=:attachment
            """)
    List<AssigmentSubmissions> universalSearch(Integer id, Integer assigmentId,
                                               Integer studentId, String selectedOption,
                                               String textInput, String attachment
    );
}
