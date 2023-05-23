package be.telenet.origin.client.domain.findbilling.port.outgoing;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.Optional;

public interface BillingAccountRepository {
    Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber);
}
