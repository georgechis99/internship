package com.arobs.library.controller;

import com.arobs.library.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/rentRequests")
@RestController
@Validated
public class RentRequestController {

    private RentRequestService rentRequestService;

    @Autowired
    public RentRequestController(RentRequestService rentRequestService) {
        this.rentRequestService = rentRequestService;
    }


}
