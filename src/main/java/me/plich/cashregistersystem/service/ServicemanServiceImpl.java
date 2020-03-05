package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.exception.ServicemanNotFoundException;
import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.repository.ServicemanRepository;
import me.plich.cashregistersystem.repository.UserRepository;
import me.plich.cashregistersystem.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import static me.plich.cashregistersystem.utils.Utils.getNullPropertyNames;

@Service("servicemanService")
public class ServicemanServiceImpl implements IServicemanService {


    UserRepository userRepository;
    ServicemanRepository servicemanRepository;
    IUserService userService;

    @Autowired
    public ServicemanServiceImpl(UserRepository userRepository, ServicemanRepository servicemanRepository, @Qualifier("userService") IUserService userService) {
        this.userRepository = userRepository;
        this.servicemanRepository = servicemanRepository;
        this.userService = userService;
    }

    public Serviceman addServiceman(Long userId, Serviceman serviceman) {
        serviceman.setUser(userRepository.getOne(userId));
        return servicemanRepository.save(serviceman);
    }

    public void deleteServiceman(Long userId, Long servicemanId) {
        Serviceman serviceman = servicemanRepository.findById(servicemanId)
                .orElseThrow(() -> new ServicemanNotFoundException(servicemanId));
        if(Utils.checkUser(userId, serviceman)) {
            servicemanRepository.deleteById(servicemanId);
        } else {
            throw new ServicemanNotFoundException(servicemanId);
        }
    }

    public Serviceman getServiceman(Long userId, Long servicemanId) {
        Serviceman serviceman = servicemanRepository.findById(servicemanId)
                .orElseThrow(() -> new ServicemanNotFoundException(servicemanId));
        if(Utils.checkUser(userId, serviceman)) {
            return serviceman;
        }
        else {
            throw new ServicemanNotFoundException(servicemanId);
        }
    }


    public List<Serviceman> getAllUsersServicemen(Long userId) {
        return userRepository.getOne(userId).getServicemens();
    }


    public Serviceman updateServiceman(Long userId, Serviceman serviceman, Long servicemanId) {
        Serviceman servicemanToUpdate = servicemanRepository.findById(servicemanId)
                .orElseThrow(() -> new ServicemanNotFoundException(servicemanId));
        if(Utils.checkUser(userId, servicemanToUpdate)) {
            BeanUtils.copyProperties(serviceman, servicemanToUpdate, getNullPropertyNames(serviceman));
            return servicemanRepository.save(servicemanToUpdate);
        }
        else {
            throw new ServicemanNotFoundException(servicemanId);
        }
    }
}
