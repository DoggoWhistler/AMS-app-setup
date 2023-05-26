package be.telenet.origin.client.adaptor.tbapi.model;

import lombok.Builder;

@Builder
public record BillingAccountDTO(String id, String billingPeriodicity) {

}
