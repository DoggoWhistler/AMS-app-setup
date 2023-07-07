package be.telenet.origin.client.application.port.out;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;

import java.util.Optional;

public interface FindBillingAccountRepository {
    Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber);
}
