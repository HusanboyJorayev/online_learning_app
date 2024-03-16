package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.dto.AssignmentsDto;
import com.example.online_learning_app.mapper.AssignmentsMapper;
import com.example.online_learning_app.repository.AssignmentsRepository;
import com.example.online_learning_app.service.AssignmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentsServiceImpl implements AssignmentsService {
    private final AssignmentsRepository assignmentsRepository;
    private final AssignmentsMapper assignmentsMapper;

    @Override
    public ApiResponse<String> create(AssignmentsDto dto) {
        var assigment = this.assignmentsMapper.toEntity(dto);
        assigment.setCreatedAt(LocalDateTime.now());
        this.assignmentsRepository.save(assigment);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<AssignmentsDto> get(Integer id) {
        var assigment = this.assignmentsRepository.findByIdAndDeletedAtIsNull(id);
        if (assigment.isEmpty()) {
            return ApiResponse.<AssignmentsDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var assigmentS = assigment.get();
        return ApiResponse.<AssignmentsDto>builder()
                .success(true)
                .message("Ok")
                .data(this.assignmentsMapper.toDto(assigmentS))
                .build();
    }

    @Override
    public ApiResponse<String> update(AssignmentsDto dto, Integer id) {
        var assigment = this.assignmentsRepository.findByIdAndDeletedAtIsNull(id);
        if (assigment.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = assigment.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.assignmentsMapper.update(as, dto);
        this.assignmentsRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var assigment = this.assignmentsRepository.findByIdAndDeletedAtIsNull(id);
        if (assigment.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = assigment.get();
        as.setDeletedAt(LocalDateTime.now());
        this.assignmentsRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<AssignmentsDto>> getAll() {
        var assigmentSubmissions = this.assignmentsRepository.findAll();
        if (assigmentSubmissions.isEmpty()) {
            return ApiResponse.<List<AssignmentsDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<AssignmentsDto>>builder()
                .success(true)
                .message("Ok")
                .data(assigmentSubmissions.stream().map(this.assignmentsMapper::toDto).toList())
                .build();
    }
}
