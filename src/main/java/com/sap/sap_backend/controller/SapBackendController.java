package com.sap.sap_backend.controller;

import com.sap.sap_backend.data.dto.FeedbackDto;
import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.service.FeedbackService;
import com.sap.sap_backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("spa")
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
    @GetMapping(value = "/userDetails/byId")
    public UserDetailsDto getUserDetailsById(@RequestParam int id){
        return userDetailsService.getUserDetailsById(id);
    }

    /*Endpoint to get User Details Based on Username*/
    @GetMapping("/userDetails/byName")
    public UserDetailsDto getUserDetailsByName(@RequestParam String firstName, String lastName){
        return userDetailsService.getUserDetailsByName(firstName, lastName);
    }

    /*Endpoint to get entire UserDetails Table Records*/
    @GetMapping("/userDetails/fullUserDetails")
    public List<UserDetailsDto> getEntireUserDetails(){
        return userDetailsService.getCompleteUserDetails();
    }

    /*Endpoint to Save User into UserDetails Table */
    @PostMapping("/userDetails/save")
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

    /*Endpoint to save Feedback*/
    @PostMapping("/feedback/save")
    public FeedbackDto saveFeedBackDetails(@RequestBody FeedbackDto feedbackDto){
        return feedbackService.saveFeedbackDetails(feedbackDto);
    }

    @PostMapping("/feedback/saveFeedbackList")
    public String saveFeedBackDetails(@RequestBody List<FeedbackDto> feedbackDto){
        return feedbackService.processFeedbackDTOList(feedbackDto);
    }
    /*Endpoint to get entire Feedback*/
    @GetMapping("/feedback/getFeedbacks")
    public List<FeedbackDto> getCompleteFeedback()
    {
        return feedbackService.getFeedbackDetails();
    }

    /*Endpoint to get Feedback by Name*/
    @GetMapping("/feedback/getFeedbackByName")
    public List<FeedbackDto> getFeedbackDetailsByName(@RequestParam String username)
    {
        return feedbackService.getFeedbackDetailsByName(username);
    }

    /*Error Condition Implementation
    * Embedded Cassandra*/

}
