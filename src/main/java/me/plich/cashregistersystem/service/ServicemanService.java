package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.repository.ServicemanRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ServicemanService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ServicemanRepository servicemanRepository;

    public void addServiceman(Serviceman serviceman, Long userID) {
        serviceman.setUser(userRepository.findById(userID).get());
        servicemanRepository.save(serviceman);
    }

    public void deleteServiceman(@PathVariable Long id) {
        servicemanRepository.deleteById(id);
    }

    public Serviceman getServiceman(@PathVariable Long id) {
        Serviceman serviceman = servicemanRepository.findById(id).get();
        return serviceman;
    }

    public List<Serviceman> getAllServicemens() {
        List<Serviceman> servicemens = servicemanRepository.findAll();
        return servicemens;
    }
}
