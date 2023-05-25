package be.telenet.origin.client.application.config;

import be.telenet.origin.client.adaptor.tbapi.BillingAccountDTO;
import be.telenet.origin.client.adaptor.tbapi.TBApiBillingService;
import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.findbilling.service.FindBillingUseCase;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.updatebilling.service.UpdateBillingUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

public class ApplicationConfig {

    @Produces
    public UpdateBillingUseCasePort updateBillingUseCase(be.telenet.origin.client.domain.usecase.updatebilling.port.BillingAccountRepositoryPort updateBillingRepository){
        return new UpdateBillingUseCase(updateBillingRepository);
    }

    @Produces
    public FindBillingUseCasePort findBillingUseCasePort(be.telenet.origin.client.domain.usecase.findbilling.port.BillingAccountRepositoryPort findBillingRepository){
        return new FindBillingUseCase(findBillingRepository);
    }

//    @Produces
//    @ApplicationScoped
//    @RegisterRestClient
//    public TBApiBillingService tbApiBillingService(){
//        return new TBApiBillingService(findBillingRepository) {
//            @Override
//            public BillingAccountDTO getBillingAccountByMSISDN(String msisdn) {
//                return null;
//            }
//        };
//    }
}
