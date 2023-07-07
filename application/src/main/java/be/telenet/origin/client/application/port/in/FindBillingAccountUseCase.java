package be.telenet.origin.client.application.port.in;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;

import java.util.Optional;

public interface FindBillingAccountUseCase {

    Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber);
}
