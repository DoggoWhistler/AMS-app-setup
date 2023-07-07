package be.telenet.origin.client.model;

import be.telenet.origin.client.model.exception.InvalidBillingAccountNumberException;
import be.telenet.origin.client.model.policy.BelgianBillingAccountNumberPolicy;
import be.telenet.origin.client.model.policy.BillingAccountNumberPolicy;

public record BillingAccountNumber(String number) {

    private static final BillingAccountNumberPolicy policy = new BelgianBillingAccountNumberPolicy();

    public BillingAccountNumber {
        if (!policy.isValid(number)){
            throw new InvalidBillingAccountNumberException(number);
        }
    }

}
