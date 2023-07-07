package be.telenet.origin.client.application.port.in;

import be.telenet.origin.client.model.BillingAccount;

public interface UpdateBillingAccountUseCase {

    BillingAccount updateBillingAccount(BillingAccount billingAccount);
}
