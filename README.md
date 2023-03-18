# planit Jupiter-Toys
Solution is built on 'Cucumber Framework' with a twisted page object model design pattern.
It's very dynamic in nature. Users only need to touch the feature files & properties files, anyone without having any technical knowledge can run & understand this.
for example:

1. I have leveraged Cucumber's Datatables which are dynamic in nature, you just need add or remove records & your contact creation is done. for example 
    And Populate mandatory fields, submit & Validate successful submission message
      | Forename | Email                   | Message                                                                                            |
      | Jatin    | jatinkhuranna@gmail.com | Jupiter toys are awesome.                                                                          |
      | Mark     | mark@nz.com             | Quality is not good. I would like to return my Fluffy Bunny, please refund.                        |


3. "Given Buy "2-Stuffed Frog, 5-Fluffy Bunny, 3-Valentine Bear"" Now In this change the number & Toy name, and it will add to cart dynamically. for example "Given Buy "10-Smiley Face, 5-Valentine Bear"" & we are done.


  Scenario: Test case #1
    Given From the home page go to contact page
    And Click submit button
    But Verify error messages
    And Populate mandatory fields
      | Forename | Email                   | Message                   |
      | Jatin    | jatinkhuranna@gmail.com | Jupiter toys are awesome. |
    And Click submit button
    Then Validate errors are gone

  Scenario: Test case #2
    Given From the home page go to contact page
    And Populate mandatory fields, submit & Validate successful submission message
      | Forename | Email                   | Message                                                                                            |
      | Jatin    | jatinkhuranna@gmail.com | Jupiter toys are awesome.                                                                          |
      | Mark     | mark@nz.com             | Quality is not good. I would like to return my Fluffy Bunny, please refund.                        |
      | Kate     | Kate@hotmail.com        | Last week, I bought a Teddy Bear for my niece, she loved it. Thank you.                            |
      | Kevin    | Kevin@nz.com            | Best Toys in Wellington.                                                                           |
      | Planit   | Planit@nz.com           | I am surprised, I ordered in the morning and got my Handmade Doll by evening. fastest delivery |

  Scenario: Test case #3
    Given From the home page go to shop page
    Given Buy "2-Stuffed Frog, 5-Fluffy Bunny, 3-Valentine Bear"
    And Go to the cart page
    Then Verify the subtotal for each product is correct
    Then Verify the price for each product
    Then Verify that total = sum(sub totals)
