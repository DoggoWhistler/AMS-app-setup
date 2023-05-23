package be.telenet.origin.client.domain.updatebilling.port.outgoing;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

public interface BillingAccountRepository {
    BillingAccount updateBillingAccount(BillingAccount billingAccount);
}
