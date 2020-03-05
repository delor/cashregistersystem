package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.dto.ServicemanDto;
import me.plich.cashregistersystem.mapper.ServicemanMapper;
import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.IServicemanService;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/serviceman")
@ApiOperation("Set of endpoints for Creating, Retrieving, Updating and Deleting of service technicians.")
public class ServicemanController {


    private IServicemanService servicemanService;
    private IUserService userService;
    private ServicemanMapper servicemanMapper;

    @Autowired
    public ServicemanController(@Qualifier("servicemanService") IServicemanService servicemanService,
                                @Qualifier("userService") IUserService userService,
                                ServicemanMapper servicemanMapper) {
        this.servicemanService = servicemanService;
        this.userService = userService;
        this.servicemanMapper = servicemanMapper;
    }

    @PostMapping
    @JsonView(View.Public.class)
    @ApiOperation("Create new serviceman")
    public ResponseEntity<ServicemanDto> addServiceman(@RequestBody ServicemanDto servicemanDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Serviceman servicemanFromDto = servicemanMapper.convertServicemanDtoToServiceman(servicemanDto);
        Serviceman createdServiceman = servicemanService.addServiceman(userId, servicemanFromDto);
        ServicemanDto createdServicemanDto = servicemanMapper.convertServicemanToServicemanDto(createdServiceman);
        return new ResponseEntity(createdServicemanDto, HttpStatus.CREATED);
    }

    @GetMapping
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of servicemens")
    public ResponseEntity<List<ServicemanDto>> getAllServicemens() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Serviceman> servicemensList = servicemanService.getAllUsersServicemen(userId);
        List<ServicemanDto> servicemanDto = servicemensList.stream()
                .map(serviceman -> servicemanMapper.convertServicemanToServicemanDto(serviceman)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        return new ResponseEntity(servicemanDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete serviceman with a specific id")
    public ResponseEntity deleteServiceman(@PathVariable Long servicemanId) {
        Long userId = userService.getCurrentLoggedUserId();
        servicemanService.deleteServiceman(userId, servicemanId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @GetMapping("/{id}")
    @ApiOperation("Returns serviceman with specific id")
    public ResponseEntity<ServicemanDto> getServiceman(@PathVariable Long servicemanId) {
        Long userId = userService.getCurrentLoggedUserId();
        Serviceman serviceman = servicemanService.getServiceman(userId, servicemanId);
        ServicemanDto servicemanDto = servicemanMapper.convertServicemanToServicemanDto(serviceman);
        return new ResponseEntity<>(servicemanDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Updates the serviceman with a specific id")
    public ResponseEntity<ServicemanDto> updateServiceman(@PathVariable Long servicemanId, @RequestBody ServicemanDto servicemanDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Serviceman servicemanFromDto = servicemanMapper.convertServicemanDtoToServiceman(servicemanDto);
        Serviceman updatedServiceman = servicemanService.updateServiceman(userId, servicemanFromDto, servicemanId);
        ServicemanDto updatedServicemanDto = servicemanMapper.convertServicemanToServicemanDto(updatedServiceman);
        return new ResponseEntity(updatedServicemanDto, HttpStatus.OK);
    }
}
