package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidMSISDNException;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MSISDN {
    private static final MSISDNPolicy policy = new TelenetMSISDNPolicy();
    private final String msisdn;

    public MSISDN(final String msisdn) {
        if (!policy.isValid(msisdn)) {
            throw new InvalidMSISDNException(msisdn);
        }
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }
}
