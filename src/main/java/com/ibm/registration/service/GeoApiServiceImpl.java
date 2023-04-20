package com.ibm.registration.service;

import com.ibm.registration.beans.GeoApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoApiServiceImpl implements IGeoApiService{
    @Override
    public GeoApiResponse getGeoLocation(String url) {
        return new RestTemplate().getForObject(url, GeoApiResponse.class);
    }
}
