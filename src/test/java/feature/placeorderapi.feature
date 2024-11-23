Feature: Place Order API Testing

  Scenario Outline: Verify Place Order API Response
    Given I send a request to the Place Order API
    When I include the request body in the API
    And I verify the response contains status "<status>" and scope "<scope>"
    Then I validate that the status code is "<code>"

    Examples:
      | status | scope | code |
      | OK     | APP   | 200  |
