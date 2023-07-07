package be.telenet.origin.client.application.service;

import be.telenet.origin.client.application.port.in.FindBillingAccountUseCase;
import be.telenet.origin.client.application.port.out.FindBillingAccountRepository;
import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;
import lombok.extern.jbosslog.JBossLog;

import java.util.Optional;

@JBossLog
public class FindBillingAccountService implements FindBillingAccountUseCase {

    private final FindBillingAccountRepository billingAccountRepository;

    public FindBillingAccountService(FindBillingAccountRepository repository) {
        this.billingAccountRepository = repository;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN mobileNumber) {
        log.debugf("FindBillingUseCase.findBillingAccount %s", mobileNumber);
        return billingAccountRepository.findBillingAccount(mobileNumber);
    }
}
