package be.telenet.origin.client.domain.model.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidBillingAccountNumberExceptionTest {

    @Test
    void testConstructor() {
        InvalidBillingAccountNumberException actualInvalidBillingAccountNumberException = new InvalidBillingAccountNumberException("Number");
        assertEquals("Invalid billing account Number", actualInvalidBillingAccountNumberException.getMessage());
    }

}
