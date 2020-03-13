package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.dto.DeviceDto;
import me.plich.cashregistersystem.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    @Mapping(target = "producer", ignore = true)
    @Mapping(target = "model", ignore = true)
    Device convertDeviceDtoToDevice(DeviceDto deviceDto);

    DeviceDto convertDevicetoDeviceDto(Device device);
}
