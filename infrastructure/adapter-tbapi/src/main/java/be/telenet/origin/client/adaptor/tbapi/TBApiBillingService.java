package be.telenet.origin.client.adaptor.tbapi;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Dependent
@RegisterRestClient
public interface TBApiBillingService {

    @GET
    @Path("/billingAccount/msisdn/{msisdn}")
    @Retry(maxRetries = 2)
    BillingAccountDTO getBillingAccountByMSISDN(@PathParam("msisdn") String msisdn);

}
