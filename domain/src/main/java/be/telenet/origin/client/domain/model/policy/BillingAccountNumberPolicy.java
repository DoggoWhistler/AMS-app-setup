package be.telenet.origin.client.domain.model.policy;

public interface BillingAccountNumberPolicy {

    boolean isValid(String accountNumber);
}
