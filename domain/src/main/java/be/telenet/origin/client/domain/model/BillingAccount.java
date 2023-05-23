package be.telenet.origin.client.domain.model;

import lombok.Data;

@Data
public class BillingAccount {

    private final BillingAccountNumber billingAccountNumber;
    private final MSISDN msisdn;

    public BillingAccount(BillingAccountNumber billingAccountNumber, MSISDN msisdn) {
        this.billingAccountNumber = billingAccountNumber;
        this.msisdn = msisdn;
    }

}
