package be.telenet.origin.client.domain.model;

public class InvalidBillingAccountNumberException extends Throwable {
    public InvalidBillingAccountNumberException(String number) {
        super("Invalid billing account number: " + number);
    }
}
