package be.telenet.origin.client.adaptor.tbapi;

import be.telenet.origin.client.domain.usecase.findbilling.port.BillingAccountRepositoryPort;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@Slf4j
@ApplicationScoped
public class BillingAccountRepository implements be.telenet.origin.client.domain.usecase.findbilling.port.BillingAccountRepositoryPort, be.telenet.origin.client.domain.usecase.updatebilling.port.BillingAccountRepositoryPort {

    private final TBApiBillingService tbApiBillingService;

    BillingAccountRepository(@RestClient TBApiBillingService tbApiBillingService) {
        this.tbApiBillingService = tbApiBillingService;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN msisdn) {
        BillingAccountDTO billingAccountByMSISDN = tbApiBillingService.getBillingAccountByMSISDN(msisdn.msisdn());
        if (billingAccountByMSISDN != null) {
            return Optional.of(BillingAccountMapper.INSTANCE.dtoToBillingAccount(billingAccountByMSISDN));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public BillingAccount updateBillingAccount(BillingAccount billingAccount) {
        log.error("Not implemented");
        return null;
    }
}
