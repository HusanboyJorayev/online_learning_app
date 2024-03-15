package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.entity.Students;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class StudentsMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Students toEntity(StudentsDto dto);

    public abstract StudentsDto toDto(Students students);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Students students, StudentsDto dto);
}
