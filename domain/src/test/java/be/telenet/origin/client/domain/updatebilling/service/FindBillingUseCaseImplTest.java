package be.telenet.origin.client.domain.updatebilling.service;

import be.telenet.origin.client.domain.findbilling.port.incoming.FindBillingUseCase;
import be.telenet.origin.client.domain.findbilling.port.outgoing.BillingAccountRepository;
import be.telenet.origin.client.domain.findbilling.service.FindBillingUseCaseImpl;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.BillingAccountNumber;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.model.exception.InvalidMSISDNException;
import be.telenet.origin.client.domain.updatebilling.infrastructure.InMemoryBillingAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindBillingUseCaseImplTest {

    private InMemoryBillingAccountRepository repository;
    private FindBillingUseCase useCase;

    @BeforeEach
    void setupDependencies() {
        repository = new InMemoryBillingAccountRepository();
        useCase = new FindBillingUseCaseImpl(repository);
    }

    @Test
    @DisplayName("When looking up a billing account for an invalid mobile number, it should throw an exception")
    void findBillingAccountWithInvalidMsisdn() {
        assertThrows(InvalidMSISDNException.class, () -> useCase.findBillingAccount(new MSISDN("047012345")));
    }

    @Test
    @DisplayName("When looking up a billing account for a mobile number, it should return the billing account")
    void findBillingAccountWithValidMsisdn() {
        repository.persistBillingAccount(new BillingAccount(new BillingAccountNumber("123"), new MSISDN("32470123456")));
        Optional<BillingAccount> billingAccount = useCase.findBillingAccount(new MSISDN("32470123456"));
        assertThat(billingAccount).isPresent();
    }

}
