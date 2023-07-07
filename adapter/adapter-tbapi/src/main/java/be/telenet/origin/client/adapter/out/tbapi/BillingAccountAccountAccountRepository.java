package be.telenet.origin.client.adapter.out.tbapi;

import be.telenet.origin.client.adapter.out.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;
import be.telenet.origin.client.application.port.out.FindBillingAccountRepository;
import be.telenet.origin.client.application.port.out.UpdateBillingAccountRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;

@JBossLog
@ApplicationScoped
public class BillingAccountAccountAccountRepository implements FindBillingAccountRepository, UpdateBillingAccountRepository {

    private final TBApiBillingAccountRestClient tbApiBillingAccountRestClient;

    BillingAccountAccountAccountRepository(@RestClient TBApiBillingAccountRestClient tbApiBillingAccountRestClient) {
        this.tbApiBillingAccountRestClient = tbApiBillingAccountRestClient;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN msisdn) {
        BillingAccountDTO billingAccountByMSISDN = tbApiBillingAccountRestClient.getBillingAccountByMSISDN(msisdn.msisdn());
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
