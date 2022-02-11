Feature: Adidas BE Tech Challenge QA
  As a QA Automation engineer
  I want to complete the tech challenge
  So I can be hired

  Scenario Outline: Get pets' information
    Given the Petstore is available
    When the user gets the "<expected status>" pets
    Then the user should get the pets with the "<expected status>" status
    And the the user shouldn't get the pets with the "<wrong status>" status
    Examples:
      | expected status | wrong status |
      | available       | pending      |

  Scenario Outline: Adding pet
    Given the Petstore is available
    When the user adds a pet with the "<status>" status, id <id> and name "<name>"
    Then the name of the pet with id <id> should be "<name>"
    Examples:
      | status    | id         | name     |
      | available | 987987987  | tortilla |

  Scenario Outline: Updating pet's information
    Given the pet with id "<id>" is in the Petstore
    When the user updates the status of the pet with id <id> to "<status>"
    Then the status of the pet with id <id> should be "<status>"
    Examples:
      | id         | status |
      | 987987987  | sold   |

  Scenario Outline: Removing pet
    Given the pet with id "<id>" is in the Petstore
    When the user deletes the pet with id "<id>"
    Then the pet should be removed from the Petstore
    Examples:
      | id         |
      | 987987987  |