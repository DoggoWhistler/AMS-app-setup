package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.exception.InvalidMSISDNException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelenetMSISDNPolicyTest {

    @Test
    void testPolicy() {
        assertFalse(new TelenetMSISDNPolicy().isValid("123"));
        assertTrue(new TelenetMSISDNPolicy().isValid("32496362678"));
    }

}
