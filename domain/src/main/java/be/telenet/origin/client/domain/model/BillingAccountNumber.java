package be.telenet.origin.client.domain.model;

import lombok.Data;

@Data
public class BillingAccountNumber {

    private String number;

    public BillingAccountNumber(String value) {
        this.number = value;
    }

}
