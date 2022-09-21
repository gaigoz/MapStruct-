package com.example.springmapstruct.mapper;

import com.example.springmapstruct.dto.AtleteDto;
import com.example.springmapstruct.model.Atlete;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface AtleteMapper {
    AtleteMapper INSTANCE = Mappers.getMapper(AtleteMapper.class);

    @Mapping(source = "atleteDto.description", target = "desc", defaultValue = "desciption")
    @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
    Atlete dtoToModel(AtleteDto atleteDto);

    List<AtleteDto> modelstoDtos(List<Atlete> atletes);

    void updateAtleteFromDto(AtleteDto dto,@MappingTarget Atlete entity);

    @InheritConfiguration
    AtleteDto modelToDto(Atlete atlete);



}
