package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidMSISDNException;
import lombok.Builder;

@Builder
public record MSISDN(String msisdn) {
    private static final MSISDNPolicy policy = new TelenetMSISDNPolicy();

    public MSISDN {
        if (!policy.isValid(msisdn)) {
            throw new InvalidMSISDNException(msisdn);
        }
    }

}
