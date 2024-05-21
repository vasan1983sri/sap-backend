package com.sap.sap_backend.service;

import com.sap.sap_backend.data.dto.FeedbackDto;
import com.sap.sap_backend.data.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Element;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Integer getFBIds(){
        int maxId=0;
        List<Integer> idList = feedbackRepository.getFeedBackIds();
        if(idList.size() > 0) {
            Collections.sort(idList);
            maxId = idList.get(idList.size() - 1);
        }
        return maxId+1;
    }

    public String processFeedbackDTOList(List<FeedbackDto> feedbackDtoList)
    {
        feedbackDtoList.stream().forEach( x -> {
            saveFeedbackDetails(x);
        });
        return "Successfully Saved";
    }

    public FeedbackDto saveFeedbackDetails(FeedbackDto feedbackDto){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        feedbackDto.setUpdt_ts(ts);
       feedbackDto.setFlName(feedbackDto.getFlName().toLowerCase());
       feedbackDto.setEmail(feedbackDto.getEmail().toLowerCase());
       feedbackDto.setId(getFBIds());
        return feedbackRepository.save(feedbackDto);
    }

    public List<FeedbackDto> getFeedbackDetails(){
        List<FeedbackDto> feedbackDetails = feedbackRepository.getFullFeedbackDetails();
        List<FeedbackDto> listSorted = sortFeedBackRecordsById(feedbackDetails);
        return listSorted;
    }

    private static List<FeedbackDto> sortFeedBackRecordsById(List<FeedbackDto> feedbackDetails) {
        Comparator<FeedbackDto>  FeedBackComparator = Comparator.comparing(FeedbackDto::getId);
        List<FeedbackDto> listSorted = feedbackDetails.stream().sorted(FeedBackComparator).collect(Collectors.toList());
        return listSorted;
    }


    //    @Cacheable(value="feedbackDetails", key = "{#username}")
    public List<FeedbackDto> getFeedbackDetailsByName(String username){
        List<FeedbackDto> feedbackDetails = feedbackRepository.getFullFeedbackDetailsByName(username.toLowerCase());
        System.out.println(feedbackDetails.size());
        return feedbackDetails;
    }
}
