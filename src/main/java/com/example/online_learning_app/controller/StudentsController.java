package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.service.StudentsService;
import com.example.online_learning_app.serviceimpl.StudentsServiceImpl;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v6")
@RequiredArgsConstructor
public class StudentsController implements StudentsService {
    private final StudentsServiceImpl studentsServiceImpl;

    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody StudentsDto dto) {
        return this.studentsServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<StudentsDto> get(@PathVariable(name = "id") Integer id) {
        return this.studentsServiceImpl.get(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody StudentsDto dto, @PathVariable(name = "id") Integer id) {
        return this.studentsServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.studentsServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<StudentsDto>> getAll() {
        return this.studentsServiceImpl.getAll();
    }

}
