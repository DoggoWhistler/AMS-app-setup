package be.telenet.origin.client.domain.usecase.updatebilling;

import be.telenet.origin.client.domain.model.BillingAccount;

public class UpdateBillingUseCase implements UpdateBillingUseCasePort {

    private final UpdateBillingRepositoryPort billingAccountRepository;

    public UpdateBillingUseCase(UpdateBillingRepositoryPort repository) {
        this.billingAccountRepository = repository;
    }

    @Override
    public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
        return billingAccountRepository.updateBillingAccount(billingAccount);
    }
}
