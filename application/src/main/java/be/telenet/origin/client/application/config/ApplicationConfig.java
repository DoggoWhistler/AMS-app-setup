package be.telenet.origin.client.application.config;

import be.telenet.origin.client.domain.usecase.findbilling.FindBillingRepositoryPort;
import be.telenet.origin.client.domain.usecase.findbilling.FindBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.findbilling.FindBillingUseCase;
import be.telenet.origin.client.domain.usecase.updatebilling.UpdateBillingRepositoryPort;
import be.telenet.origin.client.domain.usecase.updatebilling.UpdateBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.updatebilling.UpdateBillingUseCase;
import jakarta.enterprise.inject.Produces;

/**
 * As our domain is pure and free of framework annotations, we need to manually produce the beans that we need in our application.
 */
public class ApplicationConfig {

    @Produces
    public UpdateBillingUseCasePort updateBillingUseCase(UpdateBillingRepositoryPort updateBillingRepository){
        return new UpdateBillingUseCase(updateBillingRepository);
    }

    @Produces
    public FindBillingUseCasePort findBillingUseCasePort(FindBillingRepositoryPort findBillingRepository){
        return new FindBillingUseCase(findBillingRepository);
    }

}
