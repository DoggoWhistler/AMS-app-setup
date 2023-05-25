package be.telenet.origin.client.domain.usecase.findbilling.port;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.Optional;

public interface FindBillingUseCasePort {

    Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber);
}
