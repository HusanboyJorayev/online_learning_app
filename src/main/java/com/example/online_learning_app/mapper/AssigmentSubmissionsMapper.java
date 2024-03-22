package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.AssigmentSubmissionsDto;
import com.example.online_learning_app.entity.AssigmentSubmissions;
import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class AssigmentSubmissionsMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract AssigmentSubmissions toEntity(AssigmentSubmissionsDto dto);

    public abstract AssigmentSubmissionsDto toDto(AssigmentSubmissions assigmentSubmissions);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget AssigmentSubmissions assigmentSubmissions, AssigmentSubmissionsDto dto);
}
