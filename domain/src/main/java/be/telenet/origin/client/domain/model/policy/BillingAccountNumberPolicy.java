package be.telenet.origin.client.domain.model;

public interface BillingAccountNumberPolicy {

    boolean isValid(String accountNumber);
}
