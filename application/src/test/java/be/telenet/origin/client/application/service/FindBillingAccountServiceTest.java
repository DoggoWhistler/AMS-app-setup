package be.telenet.origin.client.application.service;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.BillingAccountNumber;
import be.telenet.origin.client.model.MSISDN;
import be.telenet.origin.client.model.exception.InvalidMSISDNException;
import be.telenet.origin.client.application.port.in.FindBillingAccountUseCase;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindBillingAccountServiceTest {

    private InMemoryBillingAccountAccountAccountRepository repository;
    private FindBillingAccountUseCase useCase;

    @BeforeEach
    void setupDependencies() {
        repository = new InMemoryBillingAccountAccountAccountRepository();
        useCase = new FindBillingAccountService(repository);
    }

    @Test
    @DisplayName("When looking up a billing account for an invalid mobile number, it should throw an exception")
    void findBillingAccountWithInvalidMsisdn() {
        ThrowableAssert.ThrowingCallable invocation = () -> useCase.findBillingAccount(new MSISDN("047012345"));
        assertThatExceptionOfType(InvalidMSISDNException.class).isThrownBy(invocation);
    }

    @Test
    @DisplayName("When looking up a billing account for a mobile number, it should return the billing account")
    void findBillingAccountWithValidMsisdn() {
        repository.persistBillingAccount(new BillingAccount(new BillingAccountNumber("012345678912"), new MSISDN("0470123456")));
        Optional<BillingAccount> billingAccount = useCase.findBillingAccount(new MSISDN("0470123456"));
        assertThat(billingAccount).isPresent();
    }

}
