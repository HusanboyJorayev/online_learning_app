package com.example.online_learning_app.service;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface AssigmentSubmissionsService {
    ApiResponse<String> create(AssigmentSubmissionsDto dto);

    ApiResponse<AssigmentSubmissionsDto> get(Integer id);

    ApiResponse<String> update(AssigmentSubmissionsDto dto, Integer id);

    ApiResponse<String> delete(Integer id);
    ApiResponse<List<AssigmentSubmissionsDto>> universalSearch(Integer id, Integer assigmentId,
                                                               Integer studentId, String selectedOption,
                                                               String textInput, String attachment);

    ApiResponse<List<AssigmentSubmissionsDto>> getAll();
}
