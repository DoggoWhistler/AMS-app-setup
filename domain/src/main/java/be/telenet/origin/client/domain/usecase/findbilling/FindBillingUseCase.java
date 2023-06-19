package be.telenet.origin.client.domain.usecase.findbilling;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import lombok.extern.jbosslog.JBossLog;

import java.util.Optional;

@JBossLog
public class FindBillingUseCase implements FindBillingUseCasePort {

    private final FindBillingRepositoryPort billingAccountRepository;

    public FindBillingUseCase(FindBillingRepositoryPort repository) {
        this.billingAccountRepository = repository;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN mobileNumber) {
        log.debugf("FindBillingUseCase.findBillingAccount %s", mobileNumber);
        return billingAccountRepository.findBillingAccount(mobileNumber);
    }
}
