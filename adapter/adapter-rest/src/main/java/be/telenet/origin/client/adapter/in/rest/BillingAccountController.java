package be.telenet.origin.client.adapter.in.rest;

import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.MSISDN;
import be.telenet.origin.client.application.port.in.FindBillingAccountUseCase;
import be.telenet.origin.client.application.port.in.UpdateBillingAccountUseCase;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Optional;

@Path("/api/v1/billing-account")
@JBossLog
@Tag(name = "Example API", description = "This is an example API for new rest services. Be sure to document it.",
        externalDocs = @ExternalDocumentation(description = "Confluence", url = "https://confluence.rel.apps.telenet.be/display/myspace/client-service-example/REST+API+Documentation"))
public class BillingAccountController {

    private final FindBillingAccountUseCase findBillingAccountUseCase;
    private final UpdateBillingAccountUseCase updateBillingAccountUseCase;

    public BillingAccountController(FindBillingAccountUseCase findBillingAccountUseCase, UpdateBillingAccountUseCase updateBillingAccountUseCase) {
        this.findBillingAccountUseCase = findBillingAccountUseCase;
        this.updateBillingAccountUseCase = updateBillingAccountUseCase;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{msisdn}")
    public BillingAccount findBillingAccount(@PathParam("msisdn") @Parameter(example = "0467917023") String msisdn) {
        log.debugf("Find billing account: {}", msisdn);
        Optional<BillingAccount> billingAccount = findBillingAccountUseCase.findBillingAccount(new MSISDN(msisdn));

        return billingAccount.orElseThrow(() -> new NotFoundException("Billing account not found"));
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public void updateBillingAccount(BillingAccount billingAccount) {
        log.infof("Update billing account: {}", billingAccount.billingAccountNumber());
        updateBillingAccountUseCase.updateBillingAccount(billingAccount);
    }
}
