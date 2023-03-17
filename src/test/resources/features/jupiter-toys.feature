Feature: Planit Testing Automation Assignment for Jatin Khurana

  @Data=src/test/resources/setup/jupiter-toys.properties
  Scenario: Test case #1
    Given From the home page go to contact page
    And Click submit button
    But Verify error messages
    And Populate mandatory fields
      | Forename | Email                   | Message                   |
      | Jatin    | jatinkhuranna@gmail.com | Jupiter toys are awesome. |
    And Click submit button
    Then Validate errors are gone

  @Data=src/test/resources/setup/jupiter-toys.properties
  Scenario: Test case #2
    Given From the home page go to contact page
    And Populate mandatory fields, submit & Validate successful submission message
      | Forename | Email                   | Message                                                                                            |
      | Jatin    | jatinkhuranna@gmail.com | Jupiter toys are awesome.                                                                          |
      | Mark     | mark@nz.com             | Quality is not good. I would like to return my Fluffy Bunny, please refund.                        |
      | Kate     | Kate@hotmail.com        | Last week, I bought a Teddy Bear for my niece, she loved it. Thank you.                            |
      | Kevin    | Kevin@nz.com            | Best Toys in Wellington.                                                                           |
      | Planit   | Planit@nz.com           | I am surprised, I ordered in the morning and got my Handmade Doll by evening. fastest delivery |

  @Data=src/test/resources/setup/jupiter-toys.properties
  Scenario: Test case #3
    Given From the home page go to shop page
    Given Buy "2-Stuffed Frog, 5-Fluffy Bunny, 3-Valentine Bear"
    And Go to the cart page
    Then Verify the subtotal for each product is correct
    Then Verify the price for each product
    Then Verify that total = sum(sub totals)