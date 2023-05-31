package be.telenet.origin.client.adaptor.tbapi;

import be.telenet.origin.client.adaptor.tbapi.model.BillingAccountDTO;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Dependent
@RegisterRestClient
public interface TBApiBillingService {

    @GET
    @Path("/billingAccount/msisdn/{msisdn}")
    @Retry(maxRetries = 2)
    @Produces(MediaType.APPLICATION_JSON)
    BillingAccountDTO getBillingAccountByMSISDN(@PathParam("msisdn") String msisdn);

}
