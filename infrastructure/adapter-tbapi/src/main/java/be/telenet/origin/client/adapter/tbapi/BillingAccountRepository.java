package be.telenet.origin.client.adapter.tbapi;

import be.telenet.origin.client.adapter.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingRepositoryPort;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
 import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@JBossLog
@ApplicationScoped
public class BillingAccountRepository implements FindBillingRepositoryPort, UpdateBillingRepositoryPort {

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
        log.errorf("Not implemented");
        return null;
    }
}
