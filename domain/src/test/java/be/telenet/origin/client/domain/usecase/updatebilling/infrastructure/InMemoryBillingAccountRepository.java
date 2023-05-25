package be.telenet.origin.client.domain.usecase.updatebilling.infrastructure;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBillingAccountRepository implements be.telenet.origin.client.domain.usecase.updatebilling.port.BillingAccountRepositoryPort, be.telenet.origin.client.domain.usecase.findbilling.port.BillingAccountRepositoryPort {

    private final List<BillingAccount> billingAccounts = new ArrayList<>();

    public void persistBillingAccount(final BillingAccount billingAccount) {
        billingAccounts.add(billingAccount);
    }

    public Optional<BillingAccount> findBillingAccount(final MSISDN msisdn) {
        return billingAccounts.stream()
                .filter(billingAccount -> billingAccount.msisdn().equals(msisdn))
                .findAny();
    }

    @Override
    public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
        return null;
    }
}
