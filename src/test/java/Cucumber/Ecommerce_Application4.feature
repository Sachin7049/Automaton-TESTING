
Feature: Purchase Product in Ecommerce Application

  Background:
    Given I am on the homepage of the ecommerce application

  Scenario Outline: Positive test of submitting the order
    Given Login with name "<name>" and password "<password>"
    When I add "<productName>" to the cart
    And I checkout "<productName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message should be displayed

    Examples:
      | name                     | password        | productName |
      | testuser1234@yopmail.com | Welcome@123   | ZARA COAT 3 |
