package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.StudentsDto;
import com.example.online_learning_app.dto.TeachersDto;
import com.example.online_learning_app.entity.Students;
import com.example.online_learning_app.entity.Teachers;
import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class TeachersMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Teachers toEntity(TeachersDto dto);

    public abstract TeachersDto toDto(Teachers teachers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Teachers teachers, TeachersDto dto);
}
