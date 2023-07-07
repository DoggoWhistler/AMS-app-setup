package be.telenet.origin.client.model.exception;

public class InvalidBillingAccountNumberException extends RuntimeException {
    public InvalidBillingAccountNumberException(String number) {
        super(String.format("Invalid billing account %s", number));
    }
}
