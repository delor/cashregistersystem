package me.plich.cashregistersystem.service;

import me.plich.cashregistersystem.generated.datastore.GetMigrationData201901Response;
import me.plich.cashregistersystem.generated.datastore.POJOfromXSD.DanePodstawoweTyp;
import me.plich.cashregistersystem.generated.datastore.POJOfromXSD.WynikWyszukiwania;
import me.plich.cashregistersystem.model.User;
import me.plich.cashregistersystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import java.io.StringReader;

import static me.plich.cashregistersystem.utils.Utils.getNullPropertyNames;


@Service("userService")
public class UserServiceImpl implements IUserService {

@Autowired
DataStoreProviderService dataStoreProviderService;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUser(Long userId) {
        return userRepository.getOne(userId);
    }

    public User updateUser(Long userId, User userFromDto) {
        User userToUpdate = userRepository.getOne(userId);
        Long userAddressId = userToUpdate.getAddress().getId();
        BeanUtils.copyProperties(userFromDto, userToUpdate, getNullPropertyNames(userFromDto));
        userToUpdate.getAddress().setId(userAddressId);
        return userRepository.save(userToUpdate);
    }

    public Long getCurrentLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = userRepository.findByUsername(auth.getName()).get().getId();
        return userId;
    }


}
