package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassStudentsDto;
import com.example.online_learning_app.service.ClassStudentsService;
import com.example.online_learning_app.serviceimpl.ClassStudentsServiceImpl;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5")
@RequiredArgsConstructor
public class ClassStudentsController implements ClassStudentsService {
    private final ClassStudentsServiceImpl studentsServiceImpl;

    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody ClassStudentsDto dto) {
        return this.studentsServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<ClassStudentsDto> get(@PathVariable(name = "id") Integer id) {
        return this.studentsServiceImpl.get(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody ClassStudentsDto dto, @PathVariable(name = "id") Integer id) {
        return this.studentsServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.studentsServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<ClassStudentsDto>> getAll() {
        return this.studentsServiceImpl.getAll();
    }
}
