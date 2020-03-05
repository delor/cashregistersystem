package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Location;
import java.util.List;


public interface ILocationService {
    Location addLocation(Long userId, Location location, Long customerId);
    void deleteLocation(Long userId, Long locationId);
    Location getLocation(Long userId, Long locationId);
    List<Location> findAllCustomersLocations(Long userId, Long customerId);
    List<Location> getAllLocations(Long userId);
    Location getDevicesLocation(Long userId, Long deviceId);
    Location updateLocation(Long userId, Long locationId, Location location);
}
