package com.sap.sap_backend.data.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class UserDetailsDtoTest {


    @Test
    public void userDetailsDtoTest(){
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setId(1);
        userDetailsDto.setFirstName("Jacob");
        assertEquals("Jacob", userDetailsDto.getFirstName());
    }

}