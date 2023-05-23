package be.telenet.origin.client.domain.updatebilling.infrastructure;

import be.telenet.origin.client.domain.findbilling.port.outgoing.BillingAccountRepository;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.BillingAccountNumber;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBillingAccountRepository implements BillingAccountRepository {

    private final List<BillingAccount> billingAccounts = new ArrayList<>();

    public void persistBillingAccount(final BillingAccount billingAccount) {
        billingAccounts.add(billingAccount);
    }

    public Optional<BillingAccount> findBillingAccount(final MSISDN msisdn) {
        return billingAccounts.stream()
                .filter(billingAccount -> billingAccount.getMsisdn().equals(msisdn))
                .findAny();
    }

}
