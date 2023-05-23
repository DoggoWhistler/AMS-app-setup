package be.telenet.origin.client.domain.findbilling.port.incoming;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.Optional;

public interface FindBillingUseCase {

    Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber);
}
