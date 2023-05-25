package be.telenet.origin.client.domain.usecase.updatebilling.service;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.usecase.updatebilling.port.BillingAccountRepositoryPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateBillingUseCaseTest {

    BillingAccountRepositoryPort repository = billingAccount -> billingAccount;

    @Test
    void testConstructor() {
        UpdateBillingUseCase updateBillingUseCase = new UpdateBillingUseCase(repository);
        BillingAccount billingAccount = updateBillingUseCase.updateBillingAccount(BillingAccount.builder().msisdn(MSISDN.builder().msisdn("32496362600").build()).build());

        assertThat(billingAccount.msisdn().msisdn()).isEqualTo("32496362600");
    }

}
