package com.sap.sap_backend.controller;

import com.sap.sap_backend.data.dto.FeedbackDto;
import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.service.FeedbackService;
import com.sap.sap_backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

import static java.time.LocalTime.now;

@CrossOrigin
@RestController
@RequestMapping("spa/userDetails")
public class SapBackendController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/ping")
    public String getPing() {
        System.out.println("Request Received");
        return "Request Received";
    }

    /*Endpoint to get User Details Based on User Id*/
    @GetMapping(value = "/byId")
    public UserDetailsDto getUserDetailsById(@RequestParam int id){
        return userDetailsService.getUserDetailsById(id);
    }

    /*Endpoint to get User Details Based on Username*/
    @GetMapping("/byName")
    public UserDetailsDto getUserDetailsByName(@RequestParam String firstName, String lastName){
        return userDetailsService.getUserDetailsByName(firstName, lastName);
    }

    /*Endpoint to get entire UserDetails Table Records*/
    @GetMapping("/fullUserDetails")
    public List<UserDetailsDto> getEntireUserDetails(){
        return userDetailsService.getCompleteUserDetails();
    }

    @PostMapping("/save")
    public UserDetailsDto saveUserDetailsDto(@RequestBody UserDetailsDto userDetailsDto){
        populateUserDetails(userDetailsDto);
        return userDetailsService.saveUserDetails(userDetailsDto);
    }

    private void populateUserDetails(UserDetailsDto userDetailsDto) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        userDetailsDto.setUpdt_ts(ts);
        Integer a = userDetailsService.getUserIds();
        userDetailsDto.setId(a);
    }

    @PostMapping("/saveFeedback")
    public FeedbackDto saveFeedBackDetails(@RequestBody FeedbackDto feedbackDto){
        return feedbackService.saveFeedbackDetails(feedbackDto);
    }
    @GetMapping("/getFeedbacks")
    public List<FeedbackDto> getCompleteFeedback()
    {
        return feedbackService.getFeedbackDetails();
    }

    /*Error Condition Implementation
    * Embedded Cassandra*/

}
