package be.telenet.origin.client.domain.findbilling.service;

import be.telenet.origin.client.domain.findbilling.port.incoming.FindBillingUseCase;
import be.telenet.origin.client.domain.findbilling.port.outgoing.BillingAccountRepository;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.Optional;

public class FindBillingUseCaseImpl implements FindBillingUseCase {

    private final BillingAccountRepository billingAccountRepository;

    public FindBillingUseCaseImpl(BillingAccountRepository repository){
        this.billingAccountRepository = repository;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN mobileNumber) {
        return billingAccountRepository.findBillingAccount(mobileNumber);
    }
}
