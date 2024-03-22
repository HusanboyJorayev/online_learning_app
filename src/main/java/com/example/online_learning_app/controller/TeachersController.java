package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.TeachersDto;
import com.example.online_learning_app.service.TeachersService;
import com.example.online_learning_app.serviceimpl.TeachersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v7")
@RequiredArgsConstructor
public class TeachersController implements TeachersService {
    private final TeachersServiceImpl teachersServiceImpl;

    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody TeachersDto dto) {
        return this.teachersServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<TeachersDto> get(@PathVariable(name = "id") Integer id) {
        return this.teachersServiceImpl.get(id);
    }

    @Override
    @GetMapping("/getWithEntities/{id}")
    public ApiResponse<TeachersDto> getWithEntities(@PathVariable(name = "id") Integer id) {
        return this.teachersServiceImpl.getWithEntities(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody TeachersDto dto, @PathVariable(name = "id") Integer id) {
        return this.teachersServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.teachersServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<TeachersDto>> getAll() {
        return this.teachersServiceImpl.getAll();
    }
}
