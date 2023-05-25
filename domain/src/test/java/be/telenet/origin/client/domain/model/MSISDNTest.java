package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidMSISDNException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MSISDNTest {

    @Test
    void testInvalidMSISDN() {
        MSISDN.MSISDNBuilder msisdn = MSISDN.builder().msisdn("123");
        assertThrows(InvalidMSISDNException.class, () -> { msisdn.build(); });
    }

    @Test
    void testValidMSISDN() {
        assertDoesNotThrow(() -> MSISDN.builder().msisdn("32496362600").build());
    }

}
