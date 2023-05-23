package be.telenet.origin.client.domain.updatebilling.port.incoming;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.BillingAccountNumber;
import be.telenet.origin.client.domain.model.MSISDN;

public interface UpdateBillingUseCase {

    BillingAccount updateBillingAccount(BillingAccount billingAccount);
}
