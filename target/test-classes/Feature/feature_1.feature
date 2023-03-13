Feature: 

  Scenario: Validate the login working currectly or not
    Given User open the chrome browser
    When User launch the yahoo site "https://in.mail.yahoo.com/"
    Then User give the valid username and click next button
    Then User give the valid password and click next button
    Then User check the compose button working correctly or not
    And User check compose fields working corrctly or not "your message has been sent"
    When User logout the page
    Then User close the current browser
