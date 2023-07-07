package be.telenet.origin.client.model.policy;

public interface BillingAccountNumberPolicy {

    boolean isValid(String accountNumber);
}
