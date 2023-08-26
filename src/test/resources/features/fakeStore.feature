Feature: Create, update and delete user

  @PostUser
  Scenario: Create a successful user
    When I consume the service endpoint
    Then I can validate the response of the service


  @PutUser
  Scenario: Update a user
    When I consume the service endpoint and I update the information
    Then I can validate the response of the server


  @DeleteUser
  Scenario: Delete a user
    When I consume the endpoint and I send the id
    Then I can validate the phone
