package com.sap.sap_backend.service;

import com.sap.sap_backend.data.dto.FeedbackDto;
import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.data.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public FeedbackDto saveFeedbackDetails(FeedbackDto feedbackDto){
        return feedbackRepository.save(feedbackDto);
    }
    public List<FeedbackDto> getFeedbackDetails(){
        List<FeedbackDto> feedbackDetails = feedbackRepository.getFullFeedbackDetails();
        System.out.println(feedbackDetails.size());
        return feedbackDetails;
    }
}
