package be.telenet.origin.client.adaptor.restapi;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.MSISDN;
import be.telenet.origin.client.domain.usecase.findbilling.port.FindBillingUseCasePort;
import be.telenet.origin.client.domain.usecase.updatebilling.port.UpdateBillingUseCasePort;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Optional;

@Path("/api/v1/billing")
@Slf4j
@Tag(name = "Example API", description = "This is an example API for new rest services. Be sure to document it.",
        externalDocs = @ExternalDocumentation(description = "Confluence", url = "https://confluence.rel.apps.telenet.be/display/myspace/client-service-example/REST+API+Documentation"))
public class ApiResource {

    private final FindBillingUseCasePort findBillingUseCase;
    private final UpdateBillingUseCasePort updateBillingUseCase;

    public ApiResource(FindBillingUseCasePort findBillingUseCase, UpdateBillingUseCasePort updateBillingUseCase) {
        this.findBillingUseCase = findBillingUseCase;
        this.updateBillingUseCase = updateBillingUseCase;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{msisdn}")
    public BillingAccount findBillingAccount(@PathParam("msisdn") @Parameter(example = "0469213586") String msisdn) {
        log.debug("Find billing account: {}", msisdn);
        Optional<BillingAccount> billingAccount = findBillingUseCase.findBillingAccount(new MSISDN(msisdn));
        return billingAccount.orElseThrow(() -> new NotFoundException("Billing account not found"));
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public void updateBillingAccount(BillingAccount billingAccount) {
        log.info("Update billing account: {}", billingAccount.billingAccountNumber());
        updateBillingUseCase.updateBillingAccount(billingAccount);
    }
}
