package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.dto.TeachersDto;
import com.example.online_learning_app.mapper.TeachersMapper;
import com.example.online_learning_app.repository.TeachersRepository;
import com.example.online_learning_app.service.TeachersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeachersServiceImpl implements TeachersService {
    private final TeachersRepository teachersRepository;
    private final TeachersMapper teachersMapper;

    @Override
    public ApiResponse<String> create(TeachersDto dto) {
        var teachers = this.teachersMapper.toEntity(dto);
        teachers.setCreatedAt(LocalDateTime.now());
        this.teachersRepository.save(teachers);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<TeachersDto> get(Integer id) {
        var teachers = this.teachersRepository.findByIdAndDeletedAtIsNull(id);
        if (teachers.isEmpty()) {
            return ApiResponse.<TeachersDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var teachersS = teachers.get();
        return ApiResponse.<TeachersDto>builder()
                .success(true)
                .message("Ok")
                .data(this.teachersMapper.toDto(teachersS))
                .build();
    }

    @Override
    public ApiResponse<TeachersDto> getWithEntities(Integer id) {
        var teachers = this.teachersRepository.findByIdAndDeletedAtIsNull(id);
        if (teachers.isEmpty()) {
            return ApiResponse.<TeachersDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var teachersS = teachers.get();
        return ApiResponse.<TeachersDto>builder()
                .success(true)
                .message("Ok")
                .data(this.teachersMapper.toDtoWithEntities(teachersS))
                .build();
    }

    @Override
    public ApiResponse<String> update(TeachersDto dto, Integer id) {
        var teachers = this.teachersRepository.findByIdAndDeletedAtIsNull(id);
        if (teachers.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = teachers.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.teachersMapper.update(as, dto);
        this.teachersRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var teachers = this.teachersRepository.findByIdAndDeletedAtIsNull(id);
        if (teachers.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = teachers.get();
        as.setDeletedAt(LocalDateTime.now());
        this.teachersRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<TeachersDto>> getAll() {
        var teachersSubmissions = this.teachersRepository.findAll();
        if (teachersSubmissions.isEmpty()) {
            return ApiResponse.<List<TeachersDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<TeachersDto>>builder()
                .success(true)
                .message("Ok")
                .data(teachersSubmissions.stream().map(this.teachersMapper::toDto).toList())
                .build();
    }
}
