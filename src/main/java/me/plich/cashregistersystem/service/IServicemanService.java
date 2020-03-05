package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Serviceman;
import java.util.List;

public interface IServicemanService {
    Serviceman addServiceman(Long userId, Serviceman serviceman);
    void deleteServiceman(Long userId, Long servicemanId);
    Serviceman getServiceman(Long userId, Long servicemanId);
    List<Serviceman> getAllUsersServicemen(Long userId);
    Serviceman updateServiceman(Long userId, Serviceman serviceman, Long servicemanId);
}
