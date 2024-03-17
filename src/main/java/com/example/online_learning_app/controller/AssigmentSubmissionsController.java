package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.service.AssigmentSubmissionsService;
import com.example.online_learning_app.serviceimpl.AssigmentSubmissionsServiceImpl;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AssigmentSubmissionsController implements AssigmentSubmissionsService {
    private final AssigmentSubmissionsServiceImpl assigmentSubmissionsServiceImpl;

    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody AssigmentSubmissionsDto dto) {
        return this.assigmentSubmissionsServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<AssigmentSubmissionsDto> get(@PathVariable(name = "id") Integer id) {
        return this.assigmentSubmissionsServiceImpl.get(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody AssigmentSubmissionsDto dto, @PathVariable(name = "id") Integer id) {
        return this.assigmentSubmissionsServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.assigmentSubmissionsServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/universalSearch")
    public ApiResponse<List<AssigmentSubmissionsDto>> universalSearch(@RequestParam(required = false) Integer id,
                                                                      @RequestParam(required = false) Integer assigmentId,
                                                                      @RequestParam(required = false) Integer studentId,
                                                                      @RequestParam(required = false) String selectedOption,
                                                                      @RequestParam(required = false) String textInput,
                                                                      @RequestParam(required = false) String attachment) {
        return this.assigmentSubmissionsServiceImpl.universalSearch(id, assigmentId, studentId, selectedOption, textInput, attachment);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<AssigmentSubmissionsDto>> getAll() {
        return this.assigmentSubmissionsServiceImpl.getAll();
    }
}
