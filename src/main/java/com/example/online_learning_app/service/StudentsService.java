package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassStudentsDto;
import com.example.online_learning_app.dto.StudentsDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface StudentsService {
    ApiResponse<String> create(StudentsDto dto);

    ApiResponse<StudentsDto> get(Integer id);

    ApiResponse<String> update(StudentsDto dto, Integer id);

    ApiResponse<String> delete(Integer id);

    ApiResponse<List<StudentsDto>> getAll();
}
