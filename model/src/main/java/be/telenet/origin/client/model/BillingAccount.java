package be.telenet.origin.client.model;

import lombok.Builder;

@Builder
public record BillingAccount(BillingAccountNumber billingAccountNumber, MSISDN msisdn) {
}
