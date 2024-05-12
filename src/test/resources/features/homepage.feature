#author: Sebastian Reyes
#langague: en

Feature: Search by keyword

  @stories
  Scenario: Searching for a term
    Given "Sergey" is researching things on the internet
    When he looks up "Cucumber"
    Then he should see information about "Cucumber"