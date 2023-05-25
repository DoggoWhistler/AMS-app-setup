package be.telenet.origin.client.domain.model.policy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BelgianBillingAccountNumberPolicyTest {

    @Test
    void testIsValid() {
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid("42"));
        assertTrue((new BelgianBillingAccountNumberPolicy()).isValid("012345678912"));
    }

}
