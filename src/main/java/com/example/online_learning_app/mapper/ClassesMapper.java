package com.example.online_learning_app.mapper;


import com.example.online_learning_app.dto.ClassesDto;
import com.example.online_learning_app.entity.Classes;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class ClassesMapper {


    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract Classes toEntity(ClassesDto dto);

    public abstract ClassesDto toDto(Classes classes);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Classes classes, ClassesDto dto);
}
