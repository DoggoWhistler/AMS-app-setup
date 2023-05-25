package be.telenet.origin.client.domain.usecase.updatebilling.port;

import be.telenet.origin.client.domain.model.BillingAccount;

public interface BillingAccountRepositoryPort {
    BillingAccount updateBillingAccount(BillingAccount billingAccount);
}
