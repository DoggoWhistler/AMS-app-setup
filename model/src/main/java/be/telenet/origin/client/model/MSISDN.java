package be.telenet.origin.client.model;

import be.telenet.origin.client.model.exception.InvalidMSISDNException;
import be.telenet.origin.client.model.policy.MSISDNPolicy;
import be.telenet.origin.client.model.policy.TelenetMSISDNPolicy;
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
