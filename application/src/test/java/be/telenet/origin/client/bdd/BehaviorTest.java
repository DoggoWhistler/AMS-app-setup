package be.telenet.origin.client.bdd;

import io.quarkiverse.cucumber.CucumberQuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

// we need to extend the CucumberQuarkusTest class if we want to use quarkus beans in the step definitions.
@Disabled
@SuppressWarnings("java:S2187")
public class BehaviorTest extends CucumberQuarkusTest {

    @BeforeAll
    static void setupTbApi(){
        // TODO
    }

}
