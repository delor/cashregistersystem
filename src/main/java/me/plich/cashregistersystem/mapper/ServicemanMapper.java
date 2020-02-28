package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.DTO.ServicemanDto;
import me.plich.cashregistersystem.model.Serviceman;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicemanMapper {

    Serviceman convertServicemanDtoToServiceman(ServicemanDto servicemanDto);
    ServicemanDto convertServicemanToServicemanDto(Serviceman serviceman);
}
