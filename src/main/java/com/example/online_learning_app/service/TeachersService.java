package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.dto.TeachersDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface TeachersService {
    ApiResponse<String> create(TeachersDto dto);

    ApiResponse<TeachersDto> get(Integer id);
    ApiResponse<TeachersDto> getWithEntities(Integer id);

    ApiResponse<String> update(TeachersDto dto, Integer id);

    ApiResponse<String> delete(Integer id);

    ApiResponse<List<TeachersDto>> getAll();
}
