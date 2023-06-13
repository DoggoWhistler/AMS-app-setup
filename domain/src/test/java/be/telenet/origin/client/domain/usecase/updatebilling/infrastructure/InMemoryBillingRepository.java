package be.telenet.origin.client.domain.usecase.updatebilling.infrastructure;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingRepositoryPort;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBillingRepository implements UpdateBillingRepositoryPort, FindBillingRepositoryPort {

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
