package be.telenet.origin.client.application.port.out;

import be.telenet.origin.client.model.BillingAccount;

public interface UpdateBillingAccountRepository {
    BillingAccount updateBillingAccount(BillingAccount billingAccount);
}
