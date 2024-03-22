package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.AssignmentsDto;
import com.example.online_learning_app.entity.Assignments;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class AssignmentsMapper {

    @Autowired
    protected AssigmentSubmissionsMapper assigmentSubmissionsMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(target = "assigmentSubmissions", ignore = true)
    public abstract Assignments toEntity(AssignmentsDto dto);

    @Mapping(target = "assigmentSubmissions", ignore = true)
    public abstract AssignmentsDto toDto(Assignments assignments);


    @Mapping(target = "assigmentSubmissions", expression = "java(assignments.getAssigmentSubmissions().stream().map(this.assigmentSubmissionsMapper::toDto).toList())")
    public abstract AssignmentsDto toDtoWithAssigmentSubmissions(Assignments assignments);

    @Mapping(target = "assigmentSubmissions", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Assignments assignments, AssignmentsDto dto);

    public void view(Assignments assignments, AssignmentsDto dto) {
        dto.setAssigmentSubmissions(assignments.getAssigmentSubmissions().stream().map(this.assigmentSubmissionsMapper::toDto).toList());
    }
}
