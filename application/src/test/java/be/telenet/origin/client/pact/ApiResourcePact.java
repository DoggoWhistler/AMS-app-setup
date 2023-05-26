package be.telenet.origin.client.pact;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.core.model.annotations.PactDirectory;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

//@QuarkusTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(PactConsumerTestExt.class)
//@PactTestFor(providerName = "my-client-service", port = "8096")
//@PactDirectory("target/pacts")
public class ApiResourcePact {
    private String providerUrl;

    @BeforeAll
    void setupProvider(MockServer mockServer) {
        providerUrl = mockServer.getUrl();
    }

    @Pact(provider = "my-client-service", consumer = "my-microfrontend")
    public V4Pact createPact(PactDslWithProvider builder) {
        return builder
                .given("Upon version check")
                .uponReceiving("GET REQUEST to /version")
                .path("/version")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("v1.0.0") // This would be replaced by the actual version you expect
                .toPact(V4Pact.class);
    }

    @TestTemplate
    @PactTestFor(pactMethod = "createPact")
    void runTest() {
        given()
                .baseUri(providerUrl)
                .when()
                .get("/version")
                .then()
                .statusCode(200)
                .body(is("v1.0.0")); // This would be replaced by the actual version you expect
    }
}
