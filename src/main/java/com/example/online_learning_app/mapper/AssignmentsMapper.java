package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.AssignmentsDto;
import com.example.online_learning_app.entity.Assignments;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class AssignmentsMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Assignments toEntity(AssignmentsDto dto);

    public abstract AssignmentsDto toDto(Assignments assignments);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Assignments assignments, AssignmentsDto dto);

}
