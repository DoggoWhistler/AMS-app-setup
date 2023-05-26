package be.telenet.origin.client.adaptor.tbapi;

import be.telenet.origin.client.adaptor.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.domain.model.MSISDN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingAccountRepositoryTest {

    private TBApiBillingService tbApiBillingService = msisdn -> BillingAccountDTO.builder().id("012345678912").build();

    @Test
    void findBillingAccount() {
        new BillingAccountRepository(tbApiBillingService).findBillingAccount(new MSISDN(" 0496362600")).ifPresentOrElse(
                billingAccount -> assertEquals("012345678912", billingAccount.billingAccountNumber().number()),
                () -> fail("Billing account not found"));
    }

    @Test
    void updateBillingAccountNotImplemented() {
        assertNull(new BillingAccountRepository(tbApiBillingService).updateBillingAccount(null));
    }

}
