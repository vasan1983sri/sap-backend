package com.sap.sap_backend.service;

import com.sap.sap_backend.data.dto.UserDetailsDto;
import com.sap.sap_backend.data.repository.UserDetailsRepository;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public UserDetailsDto getUserDetailsById(Integer id){
        UserDetailsDto userDetailsDto = userDetailsRepository.findUserById(id);
        return userDetailsDto;
    }

    public UserDetailsDto getUserDetailsByName(String firstName, String lastName){
        UserDetailsDto userDetailsDto = userDetailsRepository.findUserByName(firstName, lastName);
        return userDetailsDto;
    }

    public List<UserDetailsDto> getCompleteUserDetails(){
        List<UserDetailsDto> userDetailsDto = userDetailsRepository.getFullUserDetails();
        return userDetailsDto;
    }

    public UserDetailsDto saveUserDetails(UserDetailsDto userDetailsDto){
        return userDetailsRepository.save(userDetailsDto);
    }

    public Integer getUserIds(){
        List<Integer> idList = userDetailsRepository.getUserIds();
        Collections.sort(idList);
        int maxId = idList.get(idList.size()-1);
        return maxId+1;

    }
}
