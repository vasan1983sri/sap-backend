package com.sap.sap_backend.data.repository;

import com.sap.sap_backend.data.dto.UserDetailsDto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends CassandraRepository<UserDetailsDto, Integer> {

    //List<UserDetailsDto> findById()
}
