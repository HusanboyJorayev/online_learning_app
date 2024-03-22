package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassResourcesDto;
import com.example.online_learning_app.dto.ClassStudentsDto;
import com.example.online_learning_app.mapper.ClassStudentsMapper;
import com.example.online_learning_app.repository.ClassStudentsRepository;
import com.example.online_learning_app.service.ClassStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassStudentsServiceImpl implements ClassStudentsService {
    private final ClassStudentsRepository classStudentsRepository;
    private final ClassStudentsMapper classStudentsMapper;

    @Override
    public ApiResponse<String> create(ClassStudentsDto dto) {
        var classesStudents = this.classStudentsMapper.toEntity(dto);
        classesStudents.setCreatedAt(LocalDateTime.now());
        this.classStudentsRepository.save(classesStudents);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<ClassStudentsDto> get(Integer id) {
        var classesStudents = this.classStudentsRepository.findByIdAndDeletedAtIsNull(id);
        if (classesStudents.isEmpty()) {
            return ApiResponse.<ClassStudentsDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var classesStudentsS = classesStudents.get();
        return ApiResponse.<ClassStudentsDto>builder()
                .success(true)
                .message("Ok")
                .data(this.classStudentsMapper.toDto(classesStudentsS))
                .build();
    }

    @Override
    public ApiResponse<String> update(ClassStudentsDto dto, Integer id) {
        var classesStudents = this.classStudentsRepository.findByIdAndDeletedAtIsNull(id);
        if (classesStudents.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = classesStudents.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.classStudentsMapper.update(as, dto);
        this.classStudentsRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var classesStudents = this.classStudentsRepository.findByIdAndDeletedAtIsNull(id);
        if (classesStudents.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = classesStudents.get();
        as.setDeletedAt(LocalDateTime.now());
        this.classStudentsRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<ClassStudentsDto>> getAll() {
        var classesStudentsSubmissions = this.classStudentsRepository.findAll();
        if (classesStudentsSubmissions.isEmpty()) {
            return ApiResponse.<List<ClassStudentsDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<ClassStudentsDto>>builder()
                .success(true)
                .message("Ok")
                .data(classesStudentsSubmissions.stream().map(this.classStudentsMapper::toDto).toList())
                .build();
    }
}
