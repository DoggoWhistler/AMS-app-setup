package be.telenet.origin.client.domain.usecase.updatebilling;

import be.telenet.origin.client.domain.model.BillingAccount;

public interface UpdateBillingRepositoryPort {
    BillingAccount updateBillingAccount(BillingAccount billingAccount);
}
