package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.ServicemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceman")
public class ServicemanController {

    @Autowired
    ServicemanService servicemanService;

    @PostMapping
    public void addServiceman(@RequestBody Serviceman serviceman, @RequestHeader Long userID) {
        servicemanService.addServiceman(serviceman, userID);
    }

    @GetMapping
    @JsonView(View.Public.class)
    public List<Serviceman> getAllServicemens() {
        return servicemanService.getAllServicemens();
    }

    @DeleteMapping("/serviceman/{id}")
    public void deleteServiceman(@PathVariable Long id) {
        servicemanService.deleteServiceman(id);
    }

    @GetMapping("/serviceman/{id}")
    public Serviceman getServiceman(@PathVariable Long id) {
        return servicemanService.getServiceman(id);
    }
}
