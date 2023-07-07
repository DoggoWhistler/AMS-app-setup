package be.telenet.origin.client.model.exception;

import be.telenet.origin.client.model.exception.InvalidBillingAccountNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidBillingAccountNumberExceptionTest {

    @Test
    void testConstructor() {
        InvalidBillingAccountNumberException actualInvalidBillingAccountNumberException = new InvalidBillingAccountNumberException("Number");
        assertEquals("Invalid billing account Number", actualInvalidBillingAccountNumberException.getMessage());
    }

}
