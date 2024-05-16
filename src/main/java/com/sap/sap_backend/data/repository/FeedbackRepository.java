package com.sap.sap_backend.data.repository;

import com.sap.sap_backend.data.dto.FeedbackDto;
import com.sap.sap_backend.data.dto.UserDetailsDto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends CassandraRepository<FeedbackDto, String> {

    FeedbackDto save(FeedbackDto feedbackDto);

    @Query("select * from feedback_details")
    List<Integer> getFeedBackIds();

    @Query("select * from feedback_details")
    List<FeedbackDto> getFullFeedbackDetails();

    @Query("select * from feedback_details WHERE username = :username ALLOW FILTERING")
    List<FeedbackDto> getFullFeedbackDetailsByName(@Param("username") String username);
}
