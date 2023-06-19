package be.telenet.origin.client.pact;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.core.model.annotations.PactDirectory;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import be.telenet.origin.client.adapter.tbapi.TBApiBillingRestClient;
import be.telenet.origin.client.adapter.tbapi.model.BillingAccountDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.io.FileUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test is a consumer test for the TBApi. It is only partially useful as TBApi currently does not validate the providing side of the pacts.
 * They are useful to validate the consumer side of the pacts, using TBApi as a mock server.
 */
@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "tbapi", port = "8085")
@PactDirectory("target/pacts")
@PactBroker(host = "localhost", tags = {"test"}, scheme = "https",
        enablePendingPacts = "false",
        providerTags = "master"
)
@QuarkusTest
class TBApiConsumerPactTest {

    @Inject
    @RestClient
    TBApiBillingRestClient tbApiBillingRestClient;

    /**
     * The agreement we make between the consumer, the client service, and the provider. In this case TBApi
     *
     * If the client service uses a domain service instead, mock the domain service api and implement provider pact tests on the domain service.
     *
     */
    @Pact(provider = "tbapi", consumer = "client-service-example")
    V4Pact createPact(PactDslWithProvider builder) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", MediaType.APPLICATION_JSON);

        return builder
                .given("billing account exists")
                .uponReceiving("get request")
                .path("/billingAccount/msisdn/0496362600")
                .method(HttpMethod.GET)
                .willRespondWith()
                .status(Response.Status.OK.getStatusCode())
                .headers(headers)
                .body(FileUtils.readFileToString(new File("src/test/resources/billingContact.json"), "UTF-8"))
                .toPact(V4Pact.class);

    }

    @Test
    void testConsumption() {
        BillingAccountDTO billingAccountByMSISDN = tbApiBillingRestClient.getBillingAccountByMSISDN("0496362600");
        assertEquals("9166440568213618016", billingAccountByMSISDN.id());
    }
}
