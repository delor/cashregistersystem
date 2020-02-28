package me.plich.cashregistersystem.mapper;

import me.plich.cashregistersystem.DTO.DeviceDto;
import me.plich.cashregistersystem.model.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    Device convertDeviceDtoToDevice(DeviceDto deviceDto);
    DeviceDto convertDevicetoDeviceDto(Device device);
}
