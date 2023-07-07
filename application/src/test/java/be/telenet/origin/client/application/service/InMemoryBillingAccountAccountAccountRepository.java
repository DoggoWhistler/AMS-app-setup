package be.telenet.origin.client.application.service;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;
import be.telenet.origin.client.application.port.out.FindBillingAccountRepository;
import be.telenet.origin.client.application.port.out.UpdateBillingAccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBillingAccountAccountAccountRepository implements UpdateBillingAccountRepository, FindBillingAccountRepository {

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
