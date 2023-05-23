package be.telenet.origin.client.adaptor.restapi;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.BillingAccountNumber;
import be.telenet.origin.client.domain.model.MSISDN;
import com.google.api.Billing;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/billing")
public class ApiResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{msisdn}")
    public BillingAccount findBillingAccount(@PathParam("msisdn") String msisdn) {
        return new BillingAccount(new BillingAccountNumber("1234"), new MSISDN("32496362600"));
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public void updateBillingAccount(BillingAccount billingAccount) {
        ;
    }
}
