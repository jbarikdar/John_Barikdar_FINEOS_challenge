Scenario: Add a user and validate the user has been added to the table
  Given User is on landing page
  When User clicks on Add User button
  And Enters First Name
  And Enters Last Name
  And Enters User Name
  And Enters Password
  And Selects Company
  And Selects Role
  And Enters Email
  And Enters Cell Phone
  And Clicks on Ok Button
  Then User information is displayed on the first row

  Scenario: Delete user User Name: novak and validate user has been deleted
  Given User locates username <novak>
  When User clicks on the delete button
  And Confirms OK
  Then Username <novak> is deleted
