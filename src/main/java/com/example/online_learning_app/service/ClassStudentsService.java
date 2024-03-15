package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.dto.ClassStudentsDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface ClassStudentsService {
    ApiResponse<String> create(ClassStudentsDto dto);

    ApiResponse<ClassStudentsDto> get(Integer id);

    ApiResponse<String> update(ClassStudentsDto dto, Integer id);

    ApiResponse<String> delete(Integer id);

    ApiResponse<List<ClassStudentsDto>> getAll();
}
