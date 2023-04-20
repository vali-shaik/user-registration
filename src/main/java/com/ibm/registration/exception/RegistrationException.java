package com.ibm.registration.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationException extends Exception
{
    public RegistrationException(String exceptionMessage)
    {
        super(exceptionMessage);
    }
}
