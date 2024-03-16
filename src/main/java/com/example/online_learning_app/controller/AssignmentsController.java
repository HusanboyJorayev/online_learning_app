package com.example.online_learning_app.controller;

import com.example.online_learning_app.dto.ApiResponse;
import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.dto.AssignmentsDto;
import com.example.online_learning_app.service.AssignmentsService;
import com.example.online_learning_app.serviceimpl.AssigmentSubmissionsServiceImpl;
import com.example.online_learning_app.serviceimpl.AssignmentsServiceImpl;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2")
@RequiredArgsConstructor
public class AssignmentsController implements AssignmentsService {
    private final AssignmentsServiceImpl assignmentsServiceImpl;


    @Override
    @PostMapping("/create")
    public ApiResponse<String> create(@RequestBody AssignmentsDto dto) {
        return this.assignmentsServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get/{id}")
    public ApiResponse<AssignmentsDto> get(@PathVariable(name = "id") Integer id) {
        return this.assignmentsServiceImpl.get(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public ApiResponse<String> update(@RequestBody AssignmentsDto dto, @PathVariable(name = "id") Integer id) {
        return this.assignmentsServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> delete(@PathVariable(name = "id") Integer id) {
        return this.assignmentsServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public ApiResponse<List<AssignmentsDto>> getAll() {
        return this.assignmentsServiceImpl.getAll();
    }
}
