package be.telenet.origin.client.adaptor.tbapi;

import be.telenet.origin.client.adaptor.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.domain.model.BillingAccount;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;
import java.util.Set;

@RegisterRestClient
public interface TBApiBillingService {

    @GET
    @Path("/billingAccount/msisdn/{msisdn}")
    @Retry(maxRetries = 2)
    BillingAccountDTO getBillingAccountByMSISDN(@QueryParam("msisdn") String msisdn);

}
