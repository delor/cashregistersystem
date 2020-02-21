package me.plich.cashregistersystem.controller;

import com.fasterxml.jackson.annotation.JsonView;
import me.plich.cashregistersystem.model.Device;
import me.plich.cashregistersystem.model.View;
import me.plich.cashregistersystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {


    DeviceService deviceService;

    @Autowired
    public ReviewsController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

//    @JsonView(View.Public.class)
//    @GetMapping("/planned")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Device> devicesToReviewInNext7days() {
//        return deviceService.devicesToReviewInNext7days();
//    }


}
