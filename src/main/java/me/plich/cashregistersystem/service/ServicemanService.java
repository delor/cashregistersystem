package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.repository.ServicemanRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServicemanService {


    UserRepository userRepository;
    ServicemanRepository servicemanRepository;
    UserService userService;

    @Autowired
    public ServicemanService(UserRepository userRepository, ServicemanRepository servicemanRepository, UserService userService) {
        this.userRepository = userRepository;
        this.servicemanRepository = servicemanRepository;
        this.userService = userService;
    }

    public void addServiceman(Serviceman serviceman) {
        serviceman.setUser(userRepository.findById(userService.currentLoggedUserId()).get());
        servicemanRepository.save(serviceman);
    }

    public void deleteServiceman(@PathVariable Long id) {
        Serviceman serviceman = servicemanRepository.getOne(id);
        if (serviceman.getUser().getId() == userService.currentLoggedUserId()) {
            servicemanRepository.deleteById(id);
        }
    }

    public Serviceman getServiceman(@PathVariable Long id) {
        Serviceman serviceman = servicemanRepository.getOne(id);
        if(serviceman.getUser().getId()==userService.currentLoggedUserId()) {
            return serviceman;
        }
        return null;
    }

    public List<Serviceman> getAllUserserviceTechnicans() {
        List<Serviceman> serviceTechnicans = servicemanRepository.findByUser_id(userService.currentLoggedUserId());
        return serviceTechnicans;
    }

    public void updateServiceman(@PathVariable Long id, @RequestBody Serviceman serviceman) {
        Serviceman servicemanToUpdate = servicemanRepository.getOne(id);
        if(servicemanToUpdate.getUser().getId()==userService.currentLoggedUserId()) {
            if(serviceman.getFirstName() != null) {
                servicemanToUpdate.setFirstName(serviceman.getFirstName());
            }
            if(serviceman.getLastName() != null) {
                servicemanToUpdate.setLastName(serviceman.getLastName());
            }
            servicemanRepository.save(servicemanToUpdate);

        }
    }

}
