package be.telenet.origin.client.application.config;

import be.telenet.origin.client.application.port.out.FindBillingAccountRepository;
import be.telenet.origin.client.application.port.in.FindBillingAccountUseCase;
import be.telenet.origin.client.application.service.FindBillingAccountService;
import be.telenet.origin.client.application.port.out.UpdateBillingAccountRepository;
import be.telenet.origin.client.application.port.in.UpdateBillingAccountUseCase;
import be.telenet.origin.client.application.service.UpdateBillingAccountService;
import jakarta.enterprise.inject.Produces;

/**
 * As our application is pure and free of framework annotations, we need to manually produce the beans that we need in our application.
 */
public class ApplicationConfig {

    @Produces
    public UpdateBillingAccountUseCase updateBillingUseCase(UpdateBillingAccountRepository updateBillingAccountRepository){
        return new UpdateBillingAccountService(updateBillingAccountRepository);
    }

    @Produces
    public FindBillingAccountUseCase findBillingUseCasePort(FindBillingAccountRepository findBillingAccountRepository){
        return new FindBillingAccountService(findBillingAccountRepository);
    }

}
