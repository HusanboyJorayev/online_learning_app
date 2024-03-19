package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.entity.Students;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class StudentsMapper {
    @Autowired
    protected AssigmentSubmissionsMapper assigmentSubmissionsMapper;
    @Autowired
    protected ClassStudentsMapper classStudentsMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(target = "assigmentSubmissions", ignore = true)
    @Mapping(target = "classStudents", ignore = true)
    public abstract Students toEntity(StudentsDto dto);


    @Mapping(target = "assigmentSubmissions", ignore = true)
    @Mapping(target = "classStudents", ignore = true)
    public abstract StudentsDto toDto(Students students);

    @Mapping(target = "assigmentSubmissions", expression = "java(students.getAssigmentSubmissions().stream().map(this.assigmentSubmissionsMapper::toDto).toList())")
    @Mapping(target = "classStudents", expression = "java(students.getClassStudents().stream().map(this.classStudentsMapper::toDto).toList())")
    public abstract StudentsDto toDtoWithEntities(Students students);

    @Mapping(target = "assigmentSubmissions", ignore = true)
    @Mapping(target = "classStudents", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Students students, StudentsDto dto);


    public void view(Students students, StudentsDto dto) {
        dto.setAssigmentSubmissions(students.getAssigmentSubmissions().stream().map(this.assigmentSubmissionsMapper::toDto).toList());
        dto.setClassStudents(students.getClassStudents().stream().map(this.classStudentsMapper::toDto).toList());
    }
}
