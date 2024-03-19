package com.example.online_learning_app.mapper;


import com.example.online_learning_app.dto.ClassesDto;
import com.example.online_learning_app.entity.Classes;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class ClassesMapper {
    @Autowired
    protected AssignmentsMapper assignmentsMapper;
    @Autowired
    protected ClassResourcesMapper classResourcesMapper;
    @Autowired
    protected ClassStudentsMapper classStudentsMapper;


    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(target = "assignments",ignore = true)
    @Mapping(target = "classResources",ignore = true)
    @Mapping(target = "classStudents",ignore = true)
    public abstract Classes toEntity(ClassesDto dto);



    @Mapping(target = "assignments",ignore = true)
    @Mapping(target = "classResources",ignore = true)
    @Mapping(target = "classStudents",ignore = true)
    public abstract ClassesDto toDto(Classes classes);

    @Mapping(target = "assignments",expression = "java(classes.getAssignments().stream().map(this.assignmentsMapper::toDto).toList())")
    @Mapping(target = "classResources",expression = "java(classes.getClassResources().stream().map(this.classResourcesMapper::toDto).toList())")
    @Mapping(target = "classStudents",expression = "java(classes.getClassStudents().stream().map(this.classStudentsMapper::toDto).toList())")
    public abstract ClassesDto toDtoWithAllEntities(Classes classes);

    @Mapping(target = "assignments",ignore = true)
    @Mapping(target = "classResources",ignore = true)
    @Mapping(target = "classStudents",ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Classes classes, ClassesDto dto);

    public void view(Classes classes,ClassesDto dto){
        dto.setAssignments(classes.getAssignments().stream().map(this.assignmentsMapper::toDto).toList());
        dto.setClassResources(classes.getClassResources().stream().map(this.classResourcesMapper::toDto).toList());
        dto.setClassStudents(classes.getClassStudents().stream().map(this.classStudentsMapper::toDto).toList());
    }
}
