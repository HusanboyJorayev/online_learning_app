package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassesDto;
import com.example.online_learning_app.mapper.ClassesMapper;
import com.example.online_learning_app.repository.ClassesRepository;
import com.example.online_learning_app.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassesServiceImpl implements ClassesService {
    private final ClassesRepository classesRepository;
    private final ClassesMapper classesMapper;

    @Override
    public ApiResponse<String> create(ClassesDto dto) {
        var classes = this.classesMapper.toEntity(dto);
        classes.setCreatedAt(LocalDateTime.now());
        this.classesRepository.save(classes);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<ClassesDto> get(Integer id) {
        var classes = this.classesRepository.findByIdAndDeletedAtIsNull(id);
        if (classes.isEmpty()) {
            return ApiResponse.<ClassesDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var classesS = classes.get();
        return ApiResponse.<ClassesDto>builder()
                .success(true)
                .message("Ok")
                .data(this.classesMapper.toDto(classesS))
                .build();
    }

    @Override
    public ApiResponse<ClassesDto> getWithAllEntities(Integer id) {
        var classes = this.classesRepository.findByIdAndDeletedAtIsNull(id);
        if (classes.isEmpty()) {
            return ApiResponse.<ClassesDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var classesS = classes.get();
        return ApiResponse.<ClassesDto>builder()
                .success(true)
                .message("Ok")
                .data(this.classesMapper.toDtoWithAllEntities(classesS))
                .build();
    }

    @Override
    public ApiResponse<String> update(ClassesDto dto, Integer id) {
        var classes = this.classesRepository.findByIdAndDeletedAtIsNull(id);
        if (classes.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = classes.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.classesMapper.update(as, dto);
        this.classesRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var classes = this.classesRepository.findByIdAndDeletedAtIsNull(id);
        if (classes.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = classes.get();
        as.setDeletedAt(LocalDateTime.now());
        this.classesRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<ClassesDto>> getAll() {
        var classesSubmissions = this.classesRepository.findAll();
        if (classesSubmissions.isEmpty()) {
            return ApiResponse.<List<ClassesDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<ClassesDto>>builder()
                .success(true)
                .message("Ok")
                .data(classesSubmissions.stream().map(this.classesMapper::toDto).toList())
                .build();
    }
}
