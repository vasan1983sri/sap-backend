package com.sap.sap_backend.service;

import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.data.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public UserDetailsDto getUserDetailsById(Integer id){
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setId(id);
        userDetailsDto.setFirstName("Robert");
        return userDetailsDto;
    }
}
