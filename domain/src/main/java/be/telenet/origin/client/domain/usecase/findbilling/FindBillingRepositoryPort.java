package be.telenet.origin.client.domain.usecase.findbilling;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.Optional;

public interface FindBillingRepositoryPort {
    Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber);
}
