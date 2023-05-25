package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidMSISDNException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MSISDNTest {

    @Test
    public void testInvalidMSISDN() {
        assertThrows(InvalidMSISDNException.class, () -> MSISDN.builder().msisdn("123").build());
    }

    @Test
    public void testValidMSISDN() {
        assertDoesNotThrow(() -> MSISDN.builder().msisdn("32496362600").build());
    }

}
