 Scenario Outline: Login to the store
    Given open the Browser and hit the URL
    And click on the signIn button
    When Enter the "<username>" and "<Password>"
    Then For the <test> successful login user should navigate to the home page

    Examples: 
      | username          | Password | test  |
      | tester@test.com   | Tester   | 1 |
      | tester@testing.in | Tester   | 2 |
      | tester@test.com   | testing  | 3 |
      | Test@test.com     | testing  | 4 |

Feature: Login to the open store
      Scenario: search and purchase the product
      Given open the browser 
      And Login to the site
      When Search the product "<Dress>" 
      And Select the dress
      And Select the color and size 
      And get the price and the text of the product
      And click to the cart option
      And click on the process 
      And Verifi the address by clickin on process
  
     
    