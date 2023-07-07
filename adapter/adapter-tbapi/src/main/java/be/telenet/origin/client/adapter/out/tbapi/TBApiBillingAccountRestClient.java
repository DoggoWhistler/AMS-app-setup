package be.telenet.origin.client.adapter.out.tbapi;

import be.telenet.origin.client.adapter.out.tbapi.model.BillingAccountDTO;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Dependent
@RegisterRestClient
public interface TBApiBillingAccountRestClient {

    @GET
    @Path("/billingAccount/msisdn/{msisdn}")
    @Retry(maxRetries = 2)
    @Produces(MediaType.APPLICATION_JSON)
    BillingAccountDTO getBillingAccountByMSISDN(@PathParam("msisdn") String msisdn);

}
