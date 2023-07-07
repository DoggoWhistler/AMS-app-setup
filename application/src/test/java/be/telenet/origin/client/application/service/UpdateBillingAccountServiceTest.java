package be.telenet.origin.client.application.service;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;
import be.telenet.origin.client.application.port.out.UpdateBillingAccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateBillingAccountServiceTest {

    UpdateBillingAccountRepository repository = billingAccount -> billingAccount;

    @Test
    void testConstructor() {
        UpdateBillingAccountService updateBillingService = new UpdateBillingAccountService(repository);
        BillingAccount billingAccount = updateBillingService.updateBillingAccount(BillingAccount.builder().msisdn(MSISDN.builder().msisdn( "0496362600").build()).build());

        assertThat(billingAccount.msisdn().msisdn()).isEqualTo( "0496362600");
    }

}
