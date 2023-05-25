package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidBillingAccountNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingAccountNumberTest {

    @Test
    void testConstructor() {
        assertThrows(InvalidBillingAccountNumberException.class, () -> new BillingAccountNumber("123"));
        assertDoesNotThrow(() -> new BillingAccountNumber("012345678912"));
    }

}
