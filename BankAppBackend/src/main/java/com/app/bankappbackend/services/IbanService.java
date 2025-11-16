package com.app.bankappbackend.services;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

@Service
public class IbanService {

    /**
     * Generates a random, structurally valid Turkish IBAN.
     */
    public Iban generateRandomTurkishIban() {
        return Iban.random(CountryCode.TR);
    }

    /**
     * Generates a random Turkish IBAN and returns it as a formatted String.
     */
    public String generateRandomTurkishIbanAsString() {
        Iban iban = Iban.random(CountryCode.TR);
        return iban.toString();
    }
}
