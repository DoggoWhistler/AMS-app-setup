package be.telenet.origin.client.domain.model.exception;

public class InvalidBillingAccountNumberException extends RuntimeException {
    public InvalidBillingAccountNumberException(String number) {
        super(String.format("Invalid billing account %s", number));
    }
}
