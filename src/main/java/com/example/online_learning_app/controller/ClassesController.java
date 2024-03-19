package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassesDto;
import com.example.online_learning_app.service.ClassesService;
import com.example.online_learning_app.serviceimpl.ClassesServiceImpl;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3")
@RequiredArgsConstructor
public class ClassesController implements ClassesService {
    private final ClassesServiceImpl classesServiceImpl;

    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody ClassesDto dto) {
        return this.classesServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<ClassesDto> get(@PathVariable(name = "id") Integer id) {
        return this.classesServiceImpl.get(id);
    }

    @Override
    @GetMapping("/getWithEntities/{id}")
    public ApiResponse<ClassesDto> getWithAllEntities(@PathVariable(name = "id") Integer id) {
        return this.classesServiceImpl.getWithAllEntities(id);
    }
    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody ClassesDto dto, @PathVariable(name = "id") Integer id) {
        return this.classesServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.classesServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<ClassesDto>> getAll() {
        return this.classesServiceImpl.getAll();
    }
}
