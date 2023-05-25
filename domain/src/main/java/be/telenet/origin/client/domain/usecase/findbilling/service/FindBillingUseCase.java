package be.telenet.origin.client.domain.usecase.findbilling.service;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.usecase.findbilling.port.BillingAccountRepositoryPort;
import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingUseCasePort;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
@Slf4j
public class FindBillingUseCase implements FindBillingUseCasePort {

    private final BillingAccountRepositoryPort billingAccountRepository;

    public FindBillingUseCase(BillingAccountRepositoryPort repository){
        this.billingAccountRepository = repository;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN mobileNumber) {
        log.debug("FindBillingUseCase.findBillingAccount %s", mobileNumber);
        return billingAccountRepository.findBillingAccount(mobileNumber);
    }
}
