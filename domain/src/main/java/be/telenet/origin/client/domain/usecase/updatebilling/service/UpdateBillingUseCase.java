package be.telenet.origin.client.domain.usecase.updatebilling.service;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingRepositoryPort;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingUseCasePort;

public class UpdateBillingUseCase implements UpdateBillingUseCasePort {

    private final UpdateBillingRepositoryPort billingAccountRepository;

    public UpdateBillingUseCase(UpdateBillingRepositoryPort repository){
        this.billingAccountRepository = repository;
    }

    @Override
    public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
        return billingAccountRepository.updateBillingAccount(billingAccount);
    }
}
