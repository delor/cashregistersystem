package me.plich.cashregistersystem.controller;

import me.plich.cashregistersystem.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {


    IDeviceService deviceService;

    @Autowired
    public ReviewsController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

//
//    @GetMapping("/planned")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Device> devicesToReviewInNext7days() {
//        return deviceService.devicesToReviewInNext7days();
//    }


}
