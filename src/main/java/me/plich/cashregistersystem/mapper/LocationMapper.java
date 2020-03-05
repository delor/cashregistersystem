package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.LocationDto;
import me.plich.cashregistersystem.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location convertLocationDtoToLocation(LocationDto locationDto);
    LocationDto convertLocationToLocationDto(Location location);
}
