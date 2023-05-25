package be.telenet.origin.client.adaptor.tbapi;

import lombok.Builder;
import lombok.Data;

@Builder
public record BillingAccountDTO(String id, String billingPeriodicity) {

}
