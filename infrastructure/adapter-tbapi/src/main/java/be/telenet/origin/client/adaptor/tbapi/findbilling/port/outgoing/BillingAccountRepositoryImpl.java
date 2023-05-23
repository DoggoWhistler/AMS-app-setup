package be.telenet.origin.client.adaptor.tbapi.findbilling.port.outgoing;

import be.telenet.origin.client.adaptor.tbapi.TBApiBillingService;
import be.telenet.origin.client.adaptor.tbapi.mapper.BillingAccountMapper;
import be.telenet.origin.client.adaptor.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.domain.findbilling.port.outgoing.BillingAccountRepository;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;

import java.util.Optional;

public class BillingAccountRepositoryImpl implements BillingAccountRepository {

    private final TBApiBillingService tbApiBillingService;

    BillingAccountRepositoryImpl(TBApiBillingService tbApiBillingService) {
        this.tbApiBillingService = tbApiBillingService;
    }

    @Override
    public Optional<BillingAccount> findBillingAccount(MSISDN msisdn) {
        BillingAccountDTO billingAccountByMSISDN = tbApiBillingService.getBillingAccountByMSISDN(msisdn.getMsisdn());
        if (billingAccountByMSISDN != null) {
            return Optional.of(BillingAccountMapper.INSTANCE.dtoToBillingAccount(billingAccountByMSISDN));
        } else {
            return Optional.empty();
        }
    }
}
