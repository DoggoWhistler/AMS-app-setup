package be.telenet.origin.client.application.service;

import be.telenet.origin.client.application.port.in.UpdateBillingAccountUseCase;
import be.telenet.origin.client.application.port.out.UpdateBillingAccountRepository;
import be.telenet.origin.client.model.BillingAccount;

public class UpdateBillingAccountService implements UpdateBillingAccountUseCase {

    private final UpdateBillingAccountRepository billingAccountRepository;

    public UpdateBillingAccountService(UpdateBillingAccountRepository repository) {
        this.billingAccountRepository = repository;
    }

    @Override
    public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
        return billingAccountRepository.updateBillingAccount(billingAccount);
    }
}
