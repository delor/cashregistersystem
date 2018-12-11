package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.ServicemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceman")
public class ServicemanController {

    @Autowired
    ServicemanService servicemanService;

    @PostMapping
    public void addServiceman(@RequestBody Serviceman serviceman) {
        servicemanService.addServiceman(serviceman);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    public List<Serviceman> getAllUserServicemens() {
        return servicemanService.getAllUserServicemens();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServiceman(@PathVariable Long id) {
        servicemanService.deleteServiceman(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    public Serviceman getServiceman(@PathVariable Long id) {
        return servicemanService.getServiceman(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateServiceman(@PathVariable Long id, @RequestBody Serviceman serviceman) {
        servicemanService.updateServiceman(id, serviceman);
    }
}
