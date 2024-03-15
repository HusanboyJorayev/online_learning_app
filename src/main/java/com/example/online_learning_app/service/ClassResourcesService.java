package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.dto.ClassResourcesDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface ClassResourcesService {
    ApiResponse<String> create(ClassResourcesDto dto);

    ApiResponse<ClassResourcesDto> get(Integer id);

    ApiResponse<String> update(ClassResourcesDto dto, Integer id);

    ApiResponse<String> delete(Integer id);

    ApiResponse<List<ClassResourcesDto>> getAll();
}
