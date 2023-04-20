package com.ibm.registration.beans;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GeoApiResponse {
    private String countryCode;
    private String city;
}
