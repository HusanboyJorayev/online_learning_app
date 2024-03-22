package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.dto.AssignmentsDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface AssignmentsService {
    ApiResponse<String> create(AssignmentsDto dto);

    ApiResponse<AssignmentsDto> get(Integer id);
    ApiResponse<AssignmentsDto> getWithAssigmentSubmissions(Integer id);

    ApiResponse<String> update(AssignmentsDto dto, Integer id);

    ApiResponse<String> delete(Integer id);

    ApiResponse<List<AssignmentsDto>> getAll();
}
