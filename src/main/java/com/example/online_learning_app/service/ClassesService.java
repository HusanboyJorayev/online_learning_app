package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.dto.ClassesDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface ClassesService {

    ApiResponse<String> create(ClassesDto dto);

    ApiResponse<ClassesDto> get(Integer id);
    ApiResponse<ClassesDto> getWithAllEntities(Integer id);

    ApiResponse<String> update(ClassesDto dto, Integer id);

    ApiResponse<String> delete(Integer id);

    ApiResponse<List<ClassesDto>> getAll();
}
