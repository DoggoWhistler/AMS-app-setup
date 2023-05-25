package be.telenet.origin.client.domain.model;

public record TelenetMSISDNPolicy() implements MSISDNPolicy {
    @Override
    public boolean isValid(String msisdn) {
        return msisdn != null && msisdn.startsWith("32") && msisdn.length() == 11;
    }
}
