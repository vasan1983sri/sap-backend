package com.sap.sap_backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SapBackendController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("spa/ping")
    public String getPing() {
        System.out.println("Request Received");
        return "Request Received";
    }

    @GetMapping("spa/userDetails")
    public UserDetailsDto getUserDetails(@RequestParam int id){
        return userDetailsService.getUserDetailsById(id);
    }
}
