package be.telenet.origin.client.adaptor.restapi;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingUseCasePort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.Optional;

@ApplicationScoped
public class TestConfig {

    @Produces
    FindBillingUseCasePort findBillingUseCase(){
        return new FindBillingUseCasePort(){
            @Override
            public Optional<BillingAccount> findBillingAccount(MSISDN billingAccountNumber) {
                return Optional.of(BillingAccount.builder().msisdn(billingAccountNumber).build());
            }
        };
    }

    @Produces
    UpdateBillingUseCasePort updateBillingUseCase(){
        return new UpdateBillingUseCasePort() {
            @Override
            public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
                return null;
            }
        };
    }

}
