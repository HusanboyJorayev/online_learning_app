package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.dto.TeachersDto;
import com.example.online_learning_app.entity.Students;
import com.example.online_learning_app.entity.Teachers;
import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class TeachersMapper {
    @Autowired
    protected ClassesMapper classesMapper;

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    @Mapping(target = "classes",ignore = true)
    public abstract Teachers toEntity(TeachersDto dto);

    @Mapping(target = "classes",ignore = true)
    public abstract TeachersDto toDto(Teachers teachers);

    @Mapping(target = "classes",expression = "java(teachers.getClasses().stream().map(this.classesMapper::toDto).toList())")
    public abstract TeachersDto toDtoWithEntities(Teachers teachers);

    @Mapping(target = "classes",ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Teachers teachers, TeachersDto dto);

    public void view(Teachers teachers, TeachersDto dto){
        dto.setClasses(teachers.getClasses().stream().map(this.classesMapper::toDto).toList());
    }
}
