package be.telenet.origin.client.adaptor.restapi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ApiResourceTest {

    @Test
    public void testFindBillingAccount() {
        given()
          .when().get("/api/v1/billing/32496362600")
          .then()
             .statusCode(200)
//             .body(is("Hello RESTEasy"))
        ;
    }

}
