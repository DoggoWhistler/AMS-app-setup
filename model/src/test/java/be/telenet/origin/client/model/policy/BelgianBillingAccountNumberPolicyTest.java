package be.telenet.origin.client.model.policy;

import be.telenet.origin.client.model.policy.BelgianBillingAccountNumberPolicy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BelgianBillingAccountNumberPolicyTest {

    @Test
    void testIsValid() {
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid("bla"));
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid(""));
        assertFalse((new BelgianBillingAccountNumberPolicy()).isValid(null));
        assertTrue((new BelgianBillingAccountNumberPolicy()).isValid("012345678912"));
    }

}
