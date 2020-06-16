Feature: Create New ChangeRequest in the ServiceNow

  Scenario Outline: Create New Change Request with externalFile
    Given Set the coontent type json
    And set body as a file <files>
    When Send the post request
    Then Verify the response status code is 201

    Examples: 
      | files      |
      | data1.json |
