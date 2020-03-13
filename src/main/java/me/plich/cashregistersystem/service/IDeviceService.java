package me.plich.cashregistersystem.service;


import me.plich.cashregistersystem.model.Device;
import java.util.List;

public interface IDeviceService {

    Device addDevice(Long userId, Device device, Long customerId, Long producerId, Long modelId, Long locationId);
    void deleteDevice(Long userId, Long deviceId);
    Device getDevice(Long userId, Long deviceId);
    Device getOrdersDevice(Long userId, Long orderId);
    List<Device> findAllUserDevices(Long userId);
    List<Device> findAllCustomerDevices(Long userId, Long customerId);
    List<Device> findAllLocationsDevices(Long userId, Long locationId);
    Device updateDevice(Long userId, Long deviceId, Device device);
}
