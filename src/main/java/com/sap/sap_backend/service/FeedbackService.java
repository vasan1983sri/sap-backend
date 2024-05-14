package com.sap.sap_backend.service;

import com.sap.sap_backend.data.dto.FeedbackDto;
import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.data.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public FeedbackDto saveFeedbackDetails(FeedbackDto feedbackDto){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        feedbackDto.setUpdt_ts(ts);
       feedbackDto.setFlName(feedbackDto.getFlName().toLowerCase());
       feedbackDto.setEmail(feedbackDto.getEmail().toLowerCase());
        return feedbackRepository.save(feedbackDto);
    }

    public List<FeedbackDto> getFeedbackDetails(){
        List<FeedbackDto> feedbackDetails = feedbackRepository.getFullFeedbackDetails();
        System.out.println(feedbackDetails.size());
        return feedbackDetails;
    }


//    @Cacheable(value="feedbackDetails", key = "{#username}")
    public List<FeedbackDto> getFeedbackDetailsByName(String username){
        List<FeedbackDto> feedbackDetails = feedbackRepository.getFullFeedbackDetailsByName(username.toLowerCase());
        System.out.println(feedbackDetails.size());
        return feedbackDetails;
    }
}
