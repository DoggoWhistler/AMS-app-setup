package be.telenet.origin.client.bdd.steps;

import be.telenet.origin.client.adaptor.restapi.ApiResource;
import be.telenet.origin.client.domain.model.BillingAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    String msisdn;
    BillingAccount billingAccount;
    @Inject
    ApiResource apiResource;

    @Given("msisdn is {string}")
    public void msisdn_is(String msisdn) {
        this.msisdn = msisdn;
    }
    @When("we search for a billing account")
    public void we_search_for_a_billing_account() {
        billingAccount = apiResource.findBillingAccount(msisdn);
    }
    @Then("I should be returned the billing account {string}")
    public void i_should_be_returned_the_billing_account_linked_to(String billingAccountNumber) {
        assertEquals(billingAccountNumber, billingAccount.billingAccountNumber().number());
    }

}
