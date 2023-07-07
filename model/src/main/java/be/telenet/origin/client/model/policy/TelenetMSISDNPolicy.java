package be.telenet.origin.client.model.policy;

public record TelenetMSISDNPolicy() implements MSISDNPolicy {
    @Override
    public boolean isValid(String msisdn) {
        return msisdn != null && msisdn.startsWith("04") && msisdn.length() == 10;
    }
}
