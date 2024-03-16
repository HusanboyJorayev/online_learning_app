package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassStudentsDto;
import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.mapper.StudentsMapper;
import com.example.online_learning_app.repository.StudentsRepository;
import com.example.online_learning_app.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private final StudentsMapper studentsMapper;
    private final StudentsRepository studentsRepository;

    @Override
    public ApiResponse<String> create(StudentsDto dto) {
        var students = this.studentsMapper.toEntity(dto);
        students.setCreatedAt(LocalDateTime.now());
        this.studentsRepository.save(students);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<StudentsDto> get(Integer id) {
        var students = this.studentsRepository.findByIdAndDeletedAtIsNull(id);
        if (students.isEmpty()) {
            return ApiResponse.<StudentsDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var studentsS = students.get();
        return ApiResponse.<StudentsDto>builder()
                .success(true)
                .message("Ok")
                .data(this.studentsMapper.toDto(studentsS))
                .build();
    }

    @Override
    public ApiResponse<String> update(StudentsDto dto, Integer id) {
        var students = this.studentsRepository.findByIdAndDeletedAtIsNull(id);
        if (students.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = students.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.studentsMapper.update(as, dto);
        this.studentsRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var students = this.studentsRepository.findByIdAndDeletedAtIsNull(id);
        if (students.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = students.get();
        as.setDeletedAt(LocalDateTime.now());
        this.studentsRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<StudentsDto>> getAll() {
        var studentsSubmissions = this.studentsRepository.findAll();
        if (studentsSubmissions.isEmpty()) {
            return ApiResponse.<List<StudentsDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<StudentsDto>>builder()
                .success(true)
                .message("Ok")
                .data(studentsSubmissions.stream().map(this.studentsMapper::toDto).toList())
                .build();
    }
}
