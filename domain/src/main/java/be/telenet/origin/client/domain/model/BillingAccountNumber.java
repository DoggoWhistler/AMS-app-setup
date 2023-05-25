package be.telenet.origin.client.domain.model;

import lombok.Data;

public record BillingAccountNumber(String number) {

    public BillingAccountNumber {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Billing account number cannot be null or empty");
        }
    }

}
