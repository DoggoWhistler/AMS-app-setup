package be.telenet.origin.client.adapter.restapi;

import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.BillingAccountNumber;
import be.telenet.origin.client.domain.model.MSISDN;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ApiResourceTest {

    @Test
    void testFindBillingAccount() {
        given()
                .when().get("/api/v1/billing/0496362600")
                .then()
                .statusCode(200)
        ;
    }

    @Test
    void testUpdateBillingAccount() {
        BillingAccount billingAccount = BillingAccount.builder()
                .billingAccountNumber(new BillingAccountNumber("012345678912"))
                .msisdn(MSISDN.builder().msisdn( "0496362600").build())
                .build();
        given()
                .body(billingAccount)
                .contentType("application/json")
                .when().put("/api/v1/billing/")
                .then()
                .statusCode(204)
        ;
    }

}
