package be.telenet.origin.client.model.policy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BelgianBillingAccountNumberPolicyTest {

    @Test
    void testIsValid() {
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid("bla"));
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid(""));
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid(null));
        assertTrue((new BelgianBillingAccountNumberPolicy()).isValid("012345678912"));
    }

}
