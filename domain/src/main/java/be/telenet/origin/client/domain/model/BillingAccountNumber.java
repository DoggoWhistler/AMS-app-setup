package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidBillingAccountNumberException;
import be.telenet.origin.client.domain.model.policy.BelgianBillingAccountNumberPolicy;
import be.telenet.origin.client.domain.model.policy.BillingAccountNumberPolicy;

public record BillingAccountNumber(String number) {

    private static final BillingAccountNumberPolicy policy = new BelgianBillingAccountNumberPolicy();

    public BillingAccountNumber {
        if (!policy.isValid(number)){
            throw new InvalidBillingAccountNumberException(number);
        }
    }

}
