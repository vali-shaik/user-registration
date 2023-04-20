package com.ibm.registration.service;

import com.ibm.registration.beans.GeoApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface IGeoApiService
{
    GeoApiResponse getGeoLocation(String url);
}
