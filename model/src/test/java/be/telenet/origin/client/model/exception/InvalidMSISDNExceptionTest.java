package be.telenet.origin.client.model.exception;

import be.telenet.origin.client.model.exception.InvalidMSISDNException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidMSISDNExceptionTest {

    @Test
    void getMessage() {
        assertEquals("Invalid MSISDN 123", new InvalidMSISDNException("123").getMessage());
    }

}
