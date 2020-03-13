package me.plich.cashregistersystem.controller;


import me.plich.cashregistersystem.dto.ServicemanDto;
import me.plich.cashregistersystem.mapper.ServicemanMapper;
import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.service.IServicemanService;
import me.plich.cashregistersystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/serviceman")
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
    public ResponseEntity<EntityModel<ServicemanDto>> addServiceman(@RequestBody ServicemanDto servicemanDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Serviceman servicemanFromDto = servicemanMapper.convertServicemanDtoToServiceman(servicemanDto);
        Serviceman createdServiceman = servicemanService.addServiceman(userId, servicemanFromDto);
        ServicemanDto createdServicemanDto = servicemanMapper.convertServicemanToServicemanDto(createdServiceman);
        Link selfLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).slash(createdServicemanDto.getId()).withSelfRel();
        Link servicemensLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).withRel("servicemens");
        EntityModel<ServicemanDto> resource = new EntityModel<>(createdServicemanDto, selfLink, servicemensLink);
        return new ResponseEntity(resource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ServicemanDto>> getAllServicemens() {
        Long userId = userService.getCurrentLoggedUserId();
        List<Serviceman> servicemensList = servicemanService.getAllUsersServicemen(userId);
        List<ServicemanDto> servicemensDto = servicemensList.stream()
                .map(serviceman -> servicemanMapper.convertServicemanToServicemanDto(serviceman)) //przeanalizować możliwość wykorzystania referencji do metody
                .collect(Collectors.toList());
        Link link = WebMvcLinkBuilder.linkTo(ServicemanController.class).withSelfRel();
        servicemensDto.forEach(servicemanDto -> servicemanDto.add(WebMvcLinkBuilder.linkTo(ServicemanController.class).slash(servicemanDto.getId()).withSelfRel()));
        CollectionModel<ServicemanDto> resource = new CollectionModel<>(servicemensDto, link);
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{servicemanId}")
    public ResponseEntity deleteServiceman(@PathVariable Long servicemanId) {
        Long userId = userService.getCurrentLoggedUserId();
        servicemanService.deleteServiceman(userId, servicemanId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{servicemanId}")
    public ResponseEntity<EntityModel<ServicemanDto>> getServiceman(@PathVariable Long servicemanId) {
        Long userId = userService.getCurrentLoggedUserId();
        Serviceman serviceman = servicemanService.getServiceman(userId, servicemanId);
        ServicemanDto servicemanDto = servicemanMapper.convertServicemanToServicemanDto(serviceman);
        Link selfLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).slash(servicemanId).withSelfRel();
        Link servicemensLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).withRel("servicemens");
        EntityModel<ServicemanDto> resource = new EntityModel<>(servicemanDto, selfLink, servicemensLink);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PatchMapping("/{servicemanId}")
    public ResponseEntity<EntityModel<ServicemanDto>> updateServiceman(@PathVariable Long servicemanId, @RequestBody ServicemanDto servicemanDto) {
        Long userId = userService.getCurrentLoggedUserId();
        Serviceman servicemanFromDto = servicemanMapper.convertServicemanDtoToServiceman(servicemanDto);
        Serviceman updatedServiceman = servicemanService.updateServiceman(userId, servicemanFromDto, servicemanId);
        ServicemanDto updatedServicemanDto = servicemanMapper.convertServicemanToServicemanDto(updatedServiceman);
        Link selfLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).slash(updatedServicemanDto.getId()).withSelfRel();
        Link servicemensLink = WebMvcLinkBuilder.linkTo(ServicemanController.class).withRel("servicemens");
        EntityModel<ServicemanDto> resource = new EntityModel<>(updatedServicemanDto, selfLink, servicemensLink);
        return new ResponseEntity(resource, HttpStatus.OK);
    }
}
