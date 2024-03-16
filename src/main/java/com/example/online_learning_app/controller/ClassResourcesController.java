package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.ClassResourcesDto;
import com.example.online_learning_app.service.ClassResourcesService;
import com.example.online_learning_app.serviceimpl.ClassResourcesServiceImpl;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v4")
@RequiredArgsConstructor
public class ClassResourcesController implements ClassResourcesService {
    private final ClassResourcesServiceImpl classResourcesServiceImpl;

    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody ClassResourcesDto dto) {
        return this.classResourcesServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<ClassResourcesDto> get(@PathVariable(name = "id") Integer id) {
        return this.classResourcesServiceImpl.get(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody ClassResourcesDto dto, @PathVariable(name = "id") Integer id) {
        return this.classResourcesServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.classResourcesServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<ClassResourcesDto>> getAll() {
        return this.classResourcesServiceImpl.getAll();
    }
}
