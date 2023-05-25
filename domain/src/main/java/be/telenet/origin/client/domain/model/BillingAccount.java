package be.telenet.origin.client.domain.model;

import lombok.Builder;

@Builder
public record BillingAccount(BillingAccountNumber billingAccountNumber, MSISDN msisdn) {
}
