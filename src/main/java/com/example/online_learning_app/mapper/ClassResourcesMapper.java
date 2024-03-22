package com.example.online_learning_app.mapper;

import com.example.online_learning_app.dto.ClassResourcesDto;
import com.example.online_learning_app.entity.ClassResources;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class ClassResourcesMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(ignore = true, target = "createdAt")
    @Mapping(ignore = true, target = "updatedAt")
    @Mapping(ignore = true, target = "deletedAt")
    public abstract ClassResources toEntity(ClassResourcesDto dto);

    public abstract ClassResourcesDto toDto(ClassResources classResources);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget ClassResources classResources, ClassResourcesDto dto);
}
