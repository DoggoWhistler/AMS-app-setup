package be.telenet.origin.client.adapter.out.tbapi.model;

import lombok.Builder;

@Builder
public record BillingAccountDTO(String id, String billingPeriodicity) {

}
