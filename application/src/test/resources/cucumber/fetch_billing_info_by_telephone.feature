Feature: Can we fetch billing accounts by telephone number?

  Scenario: A billing account exists linked to this telephone number
    Given msisdn is "0496362600"
    When we search for a billing account
    Then I should be returned the billing account linked to "0496362600"
