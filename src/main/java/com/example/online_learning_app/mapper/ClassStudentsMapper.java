package com.example.online_learning_app.mapper;


import com.example.online_learning_app.dto.ClassStudentsDto;
import com.example.online_learning_app.entity.ClassStudents;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class ClassStudentsMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract ClassStudents toEntity(ClassStudentsDto dto);

    public abstract ClassStudentsDto toDto(ClassStudents classStudents);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget ClassStudents classStudents, ClassStudentsDto dto);
}
