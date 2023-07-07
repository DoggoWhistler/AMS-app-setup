package be.telenet.origin.client.bdd;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkiverse.cucumber.CucumberQuarkusTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;

/**
 * We need to extend the CucumberQuarkusTest class if we want to use quarkus beans in the step definitions.
 * We want to use the @WireMockTest(httpPort = 8085) annotation, but it triggers use of xstream libraries which use protected code from JDK17, which is not allowed since java modules introduced in java 16.
 */
@SuppressWarnings("java:S2187")
class BehaviorTest extends CucumberQuarkusTest {

    static WireMockServer wireMockServer;

    @BeforeAll
    static void setupTbApi() throws IOException {
        wireMockServer = new WireMockServer(8085);
        wireMockServer.start();

        wireMockServer.stubFor(
                get("/billingAccount/msisdn/0496362600")
                .willReturn(
                        okJson(FileUtils.readFileToString(new File("src/test/resources/billingContact.json"), Charset.forName("UTF-8")))
                )
        );
    }

    @AfterAll
    static void stopTbApi() throws IOException {
        wireMockServer.stop();
    }

}
