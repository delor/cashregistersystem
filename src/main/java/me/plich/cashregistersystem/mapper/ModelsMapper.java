package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.ModelDto;
import me.plich.cashregistersystem.model.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelsMapper {
//zmieniona nazwa interfejsu z uwagi na konflikt nazw beanów ze swagger
    Model convertModelDtoToModel(ModelDto modelDto);
    ModelDto convertModelToModelDto(Model model);
}
