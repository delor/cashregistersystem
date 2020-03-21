package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.EntrepreneurOutputDto;
import me.plich.cashregistersystem.model.EntrepreneurOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepreneurOutputMapper {

    EntrepreneurOutputDto convertEntrepreneurOutputToEntrepreneurOutputDto(EntrepreneurOutput entrepreneurOutput);

}
