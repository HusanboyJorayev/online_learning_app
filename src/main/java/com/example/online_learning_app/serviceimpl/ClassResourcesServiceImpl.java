package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassResourcesDto;
import com.example.online_learning_app.mapper.ClassResourcesMapper;
import com.example.online_learning_app.repository.ClassResourcesRepository;
import com.example.online_learning_app.service.ClassResourcesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassResourcesServiceImpl implements ClassResourcesService {
    private final ClassResourcesRepository classResourcesRepository;
    private final ClassResourcesMapper classResourcesMapper;

    @Override
    public ApiResponse<String> create(ClassResourcesDto dto) {
        var classesResources = this.classResourcesMapper.toEntity(dto);
        classesResources.setCreatedAt(LocalDateTime.now());
        this.classResourcesRepository.save(classesResources);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<ClassResourcesDto> get(Integer id) {
        var classesResources = this.classResourcesRepository.findByIdAndDeletedAtIsNull(id);
        if (classesResources.isEmpty()) {
            return ApiResponse.<ClassResourcesDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var classesResourcesS = classesResources.get();
        return ApiResponse.<ClassResourcesDto>builder()
                .success(true)
                .message("Ok")
                .data(this.classResourcesMapper.toDto(classesResourcesS))
                .build();
    }

    @Override
    public ApiResponse<String> update(ClassResourcesDto dto, Integer id) {
        var classesResources = this.classResourcesRepository.findByIdAndDeletedAtIsNull(id);
        if (classesResources.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = classesResources.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.classResourcesMapper.update(as, dto);
        this.classResourcesRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var classesResources = this.classResourcesRepository.findByIdAndDeletedAtIsNull(id);
        if (classesResources.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = classesResources.get();
        as.setDeletedAt(LocalDateTime.now());
        this.classResourcesRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<ClassResourcesDto>> getAll() {
        var classesResourcesSubmissions = this.classResourcesRepository.findAll();
        if (classesResourcesSubmissions.isEmpty()) {
            return ApiResponse.<List<ClassResourcesDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<ClassResourcesDto>>builder()
                .success(true)
                .message("Ok")
                .data(classesResourcesSubmissions.stream().map(this.classResourcesMapper::toDto).toList())
                .build();
    }
}
