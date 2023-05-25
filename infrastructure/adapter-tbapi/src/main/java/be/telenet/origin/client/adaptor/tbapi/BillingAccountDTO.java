package be.telenet.origin.client.adaptor.tbapi;

import lombok.Builder;

@Builder
public record BillingAccountDTO(String id, String billingPeriodicity) {

}
