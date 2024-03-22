package com.example.online_learning_app.serviceimpl;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.entity.AssigmentSubmissions;
import com.example.online_learning_app.mapper.AssigmentSubmissionsMapper;
import com.example.online_learning_app.repository.AssigmentSubmissionsRepository;
import com.example.online_learning_app.service.AssigmentSubmissionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssigmentSubmissionsServiceImpl implements AssigmentSubmissionsService {
    private final AssigmentSubmissionsRepository assigmentSubmissionsRepository;
    private final AssigmentSubmissionsMapper assigmentSubmissionsMapper;

    @Override
    public ApiResponse<String> create(AssigmentSubmissionsDto dto) {
        var assigmentSubmissions = this.assigmentSubmissionsMapper.toEntity(dto);
        assigmentSubmissions.setCreatedAt(LocalDateTime.now());
        this.assigmentSubmissionsRepository.save(assigmentSubmissions);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Created successfully")
                .build();
    }

    @Override
    public ApiResponse<AssigmentSubmissionsDto> get(Integer id) {
        var assigmentSubmissions = this.assigmentSubmissionsRepository.findByIdAndDeletedAtIsNull(id);
        if (assigmentSubmissions.isEmpty()) {
            return ApiResponse.<AssigmentSubmissionsDto>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var assigmentS = assigmentSubmissions.get();
        return ApiResponse.<AssigmentSubmissionsDto>builder()
                .success(true)
                .message("Ok")
                .data(this.assigmentSubmissionsMapper.toDto(assigmentS))
                .build();
    }

    @Override
    public ApiResponse<String> update(AssigmentSubmissionsDto dto, Integer id) {
        var assigmentSubmissions = this.assigmentSubmissionsRepository.findByIdAndDeletedAtIsNull(id);
        if (assigmentSubmissions.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = assigmentSubmissions.get();
        as.setUpdatedAt(LocalDateTime.now());
        this.assigmentSubmissionsMapper.update(as, dto);
        this.assigmentSubmissionsRepository.save(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("Updated successfully")
                .build();
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        var assigmentSubmissions = this.assigmentSubmissionsRepository.findByIdAndDeletedAtIsNull(id);
        if (assigmentSubmissions.isEmpty()) {
            return ApiResponse.<String>builder()
                    .code(-1)
                    .message("It is not found")
                    .build();
        }
        var as = assigmentSubmissions.get();
        as.setDeletedAt(LocalDateTime.now());
        this.assigmentSubmissionsRepository.delete(as);
        return ApiResponse.<String>builder()
                .success(true)
                .message("Ok")
                .data("deleted successfully")
                .build();
    }

    @Override
    public ApiResponse<List<AssigmentSubmissionsDto>> universalSearch(Integer id, Integer assigmentId,
                                                                      Integer studentId, String selectedOption,
                                                                      String textInput, String attachment) {

        var submissionsList=this.assigmentSubmissionsRepository.universalSearch(id, assigmentId, studentId,
                                                                                 selectedOption, textInput, attachment);
        if (submissionsList.isEmpty()) {
            return ApiResponse.<List<AssigmentSubmissionsDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<AssigmentSubmissionsDto>>builder()
                .success(true)
                .message("Ok")
                .data(submissionsList.stream().map(this.assigmentSubmissionsMapper::toDto).toList())
                .build();
    }

    @Override
    public ApiResponse<List<AssigmentSubmissionsDto>> getAll() {
        var assigmentSubmissions = this.assigmentSubmissionsRepository.findAll();
        if (assigmentSubmissions.isEmpty()) {
            return ApiResponse.<List<AssigmentSubmissionsDto>>builder()
                    .code(-1)
                    .message("They are not found")
                    .build();
        }
        return ApiResponse.<List<AssigmentSubmissionsDto>>builder()
                .success(true)
                .message("Ok")
                .data(assigmentSubmissions.stream().map(this.assigmentSubmissionsMapper::toDto).toList())
                .build();
    }
}
