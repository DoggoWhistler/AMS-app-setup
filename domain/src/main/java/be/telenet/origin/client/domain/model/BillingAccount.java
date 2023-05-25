package be.telenet.origin.client.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
public record BillingAccount(BillingAccountNumber billingAccountNumber, MSISDN msisdn) {
}
