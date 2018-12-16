package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.plich.cashregistersystem.model.Serviceman;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.ServicemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceman")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of service technicians.")
public class ServicemanController {

    @Autowired
    ServicemanService servicemanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creates new serviceman")
    public void addServiceman(@RequestBody Serviceman serviceman) {
        servicemanService.addServiceman(serviceman);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns list of service technicans")
    public List<Serviceman> getAllUserServicemens() {
        return servicemanService.getAllUserserviceTechnicans();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Deletes serviceman with a specific id from system")
    public void deleteServiceman(@PathVariable Long id) {
        servicemanService.deleteServiceman(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.Public.class)
    @ApiOperation("Returns a serviceman with a specific id")
    public Serviceman getServiceman(@PathVariable Long id) {
        return servicemanService.getServiceman(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Updates the serviceman with a specific id")
    public void updateServiceman(@PathVariable Long id, @RequestBody Serviceman serviceman) {
        servicemanService.updateServiceman(id, serviceman);
    }
}
