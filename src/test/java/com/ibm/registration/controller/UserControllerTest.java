package com.ibm.registration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.registration.beans.GeoApiResponse;
import com.ibm.registration.beans.RegistrationRequest;
import com.ibm.registration.beans.RegistrationResponse;
import com.ibm.registration.controller.UserController;
import com.ibm.registration.exception.RegistrationException;
import com.ibm.registration.service.GeoApiServiceImpl;
import com.ibm.registration.service.IGeoApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    IGeoApiService geoApiService;

    @Test
    public void registerUserTestSuccess() throws Exception {

        RegistrationRequest registrationRequest = new RegistrationRequest("Vali Shaik", "Pass#123","100.42.240.0");
        GeoApiResponse geoApiResponse=new GeoApiResponse("CA","Halifax");
        Mockito.when(geoApiService.getGeoLocation(ArgumentMatchers.any())).thenReturn(geoApiResponse);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(new ObjectMapper().writeValueAsString(registrationRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    public void registerUserTestFailure() throws Exception {

        RegistrationRequest registrationRequest = new RegistrationRequest("Vali Shaik", "Pass123","100.123.0.0");
        GeoApiResponse geoApiResponse=new GeoApiResponse("CA","Halifax");
        Mockito.when(geoApiService.getGeoLocation(ArgumentMatchers.any())).thenReturn(geoApiResponse);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(new ObjectMapper().writeValueAsString(registrationRequest));

        mockMvc.perform(mockRequest).andExpect(status().isBadRequest());
    }
}