package com.sap.sap_backend.data.repository;

import com.sap.sap_backend.data.dto.UserDetailsDto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends CassandraRepository<UserDetailsDto, Integer> {

    @Query("select * from user_details where id = :id")
    UserDetailsDto findUserById(@Param("id") int id);

    @Query("select * from user_details where firstName = :firstName and lastName = :lastName allow filtering")
    UserDetailsDto findUserByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select * from user_details")
    List<UserDetailsDto> getFullUserDetails();

    UserDetailsDto save(UserDetailsDto userDetailsDto);

    @Query("select * from user_details")
    List<Integer> getUserIds();
}
