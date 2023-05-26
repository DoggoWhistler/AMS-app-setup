package be.telenet.origin.client.application.config;

import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.findbilling.service.FindBillingUseCase;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.updatebilling.service.UpdateBillingUseCase;
import jakarta.enterprise.inject.Produces;

public class ApplicationConfig {

    @Produces
    public UpdateBillingUseCasePort updateBillingUseCase(be.telenet.origin.client.domain.usecase.updatebilling.port.BillingAccountRepositoryPort updateBillingRepository){
        return new UpdateBillingUseCase(updateBillingRepository);
    }

    @Produces
    public FindBillingUseCasePort findBillingUseCasePort(be.telenet.origin.client.domain.usecase.findbilling.port.BillingAccountRepositoryPort findBillingRepository){
        return new FindBillingUseCase(findBillingRepository);
    }

}
