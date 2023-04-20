package com.ibm.registration.controller;

import com.ibm.registration.beans.GeoApiResponse;
import com.ibm.registration.beans.RegistrationRequest;
import com.ibm.registration.beans.RegistrationResponse;
import com.ibm.registration.exception.RegistrationException;
import com.ibm.registration.service.IGeoApiService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    IGeoApiService geoApiService;
    @Value("${ip.url}")
    String ipApiUrl;

    Logger logger =LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = {RequestMethod.POST}, value = "/register")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) throws RegistrationException {
        String ipAddress = registrationRequest.getIpAddress();
        GeoApiResponse geoApiResponse =geoApiService.getGeoLocation(ipApiUrl + ipAddress);
        if (!"CA".equals(geoApiResponse.getCountryCode()))
        {
            logger.error("Country found"+geoApiResponse.getCountryCode()+" Expected Country: CA");
            throw new RegistrationException("User is not eligible to register based on Geo location");
        }
        UUID userId = UUID.randomUUID();
        logger.info("User Id generated: "+userId);
        logger.info("City: "+geoApiResponse.getCity());
        String message = "Welcome, "+registrationRequest.getUsername()+" from "+geoApiResponse.getCity()+"!";
        RegistrationResponse response = new RegistrationResponse(userId, message);
        return ResponseEntity.ok(response);
    }
}
