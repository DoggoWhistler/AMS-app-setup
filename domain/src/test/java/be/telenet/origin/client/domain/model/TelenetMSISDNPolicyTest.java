package be.telenet.origin.client.domain.model;

import be.telenet.origin.client.domain.model.policy.TelenetMSISDNPolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TelenetMSISDNPolicyTest {

    @Test
    void testPolicy() {
        assertFalse(new TelenetMSISDNPolicy().isValid("123"));
        assertTrue(new TelenetMSISDNPolicy().isValid("32496362678"));
    }

}
