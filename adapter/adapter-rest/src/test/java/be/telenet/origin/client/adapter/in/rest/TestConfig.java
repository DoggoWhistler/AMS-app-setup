package be.telenet.origin.client.adapter.in.rest;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.application.port.in.FindBillingAccountUseCase;
import be.telenet.origin.client.application.port.in.UpdateBillingAccountUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.Optional;

@ApplicationScoped
public class TestConfig {

    @Produces
    FindBillingAccountUseCase findBillingUseCase(){
        return billingAccountNumber -> Optional.of(BillingAccount.builder().msisdn(billingAccountNumber).build());
    }

    @Produces
    UpdateBillingAccountUseCase updateBillingUseCase(){
        return billingAccount -> null;
    }

}
