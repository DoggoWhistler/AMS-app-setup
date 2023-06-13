package be.telenet.origin.client.adapter.tbapi.model;

import lombok.Builder;

@Builder
public record BillingAccountDTO(String id, String billingPeriodicity) {

}
