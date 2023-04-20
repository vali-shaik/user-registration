package com.ibm.registration.beans;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {
    private UUID userId;
    private String message;
}
