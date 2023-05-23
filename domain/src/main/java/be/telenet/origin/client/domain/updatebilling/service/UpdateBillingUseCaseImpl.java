package be.telenet.origin.client.domain.updatebilling.service;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.updatebilling.port.incoming.UpdateBillingUseCase;
import be.telenet.origin.client.domain.updatebilling.port.outgoing.BillingAccountRepository;

public class UpdateBillingUseCaseImpl implements UpdateBillingUseCase {

    private final BillingAccountRepository billingAccountRepository;

    public UpdateBillingUseCaseImpl(BillingAccountRepository repository){
        this.billingAccountRepository = repository;
    }

    @Override
    public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
        return billingAccountRepository.updateBillingAccount(billingAccount);
    }
}
