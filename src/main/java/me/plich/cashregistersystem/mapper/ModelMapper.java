package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.DTO.ModelDto;
import me.plich.cashregistersystem.model.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    Model convertModelDtoToModel(ModelDto modelDto);
    ModelDto convertModelToModelDto(Model model);
}
