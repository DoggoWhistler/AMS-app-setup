package be.telenet.origin.client.adapter.out.tbapi;

import be.telenet.origin.client.adapter.out.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.model.MSISDN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingAccountRepositoryTest {

    private TBApiBillingAccountRestClient tbApiBillingAccountRestClient = msisdn -> BillingAccountDTO.builder().id("012345678912").build();

    @Test
    void findBillingAccount() {
        new BillingAccountAccountAccountRepository(tbApiBillingAccountRestClient).findBillingAccount(new MSISDN( "0496362600")).ifPresentOrElse(
                billingAccount -> assertEquals("012345678912", billingAccount.billingAccountNumber().number()),
                () -> fail("Billing account not found"));
    }

    @Test
    void updateBillingAccountNotImplemented() {
        assertNull(new BillingAccountAccountAccountRepository(tbApiBillingAccountRestClient).updateBillingAccount(null));
    }

}
