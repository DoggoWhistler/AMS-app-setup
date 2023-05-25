package be.telenet.origin.client.domain.model.exception;

public class InvalidMSISDNException extends RuntimeException {
    public InvalidMSISDNException(String msisdn) {
        super(String.format("Invalid MSISDN %s", msisdn));
    }

}
