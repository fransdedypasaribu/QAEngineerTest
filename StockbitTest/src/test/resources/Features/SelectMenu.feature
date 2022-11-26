Feature: Demo QA Testing

#  Question1
  @SelectMenu
  Scenario: I want to fill in select menu
    Given User go to "https://demoqa.com/select-menu"
    When User in "Select Menu" page
    And User choose select value "Another root option"
    And User choose select one "Other"
    And User choose old style select menu "Aqua"
    And User choose multi select drop down all color
    Then User success input all select menu

#  Question2
  @EmptyBook
  Scenario: I want to see empty rows in book store
    Given User go to "https://demoqa.com/books"
    When User in "Book Store" page
    And User search book "qa engineer"
    Then User see "No rows found"

#  Question3
  @Books
  Scenario: I want to see book in book store
    Given User go to "https://demoqa.com/books"
    When User in "Book Store" page
    And User search book "Git Pocket Guide"
    And User click book "Git Pocket Guide"
    Then User see "Git Pocket Guide"