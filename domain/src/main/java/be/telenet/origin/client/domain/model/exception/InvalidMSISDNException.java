package be.telenet.origin.client.domain.model.exception;

public class InvalidMSISDNException extends RuntimeException {
    private final String msisdn;

    public InvalidMSISDNException(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String getMessage() {
        return String.format("Invalid IBAN %s", msisdn);
    }
}
