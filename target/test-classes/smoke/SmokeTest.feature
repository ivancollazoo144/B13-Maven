Feature: Job Titles Functionality

  Background: 
    Given Admin User navigates to NTK Login page "https://ntkhr.noortecktraining.com/web/index.php/auth/login"
    And Admin User provides credentials "ntk-admin" "Password123@12"
    And Admin User clicks login button
    And Admin User navigates to "Admin" page
    And Admin User selects "Job Titles" from "Job" dropdown

  # Tescase 1: Create new job
  Scenario Outline: Verify Add new Job Title Functionality
    When Admin User clicks add button
    And Admin User provides Job Title field values "<jobTitle>" "<description>" "<notes>"
    And Admin User clicks save button
    Then System displays success message "Successfully Saved"

    Examples: 
      | jobTitle      | description | notes         |
      | B13Cucumber44 | Java is fun | More Homework |

  # Testcase 2: Create duplicate job
  Scenario Outline: Verify User cannot add duplicate job
    When Admin User clicks add button
    And Admin User provides Job Title field values "<jobTitle>" "<description>" "<notes>"
    Then System displays error message under Job Titles field "Already exists"

    Examples: 
      | jobTitle | description | notes |
      | a        |             |       |

  #Testcase 3: edit existing job
  Scenario Outline: Verify User can edit existing job
    When Admin User clicks edit icon <index>
    And Admin User provides Job Title field values "<jobTitle>" "<description>" "<notes>"
    And Admin User clicks save button
    Then System displays update message "Successfully Updated"

    Examples: 
      | jobTitle  | description | notes    | index |
      | B13XYZ444 | xyzDesc     | xyzNotes |     0 |

  #Testcase 4: delete existing job
  Scenario Outline: Verify User can delete existing job
    When Admin User clicks delete icon <index>
    And Admin User clicks Yes Delete button
    Then System displays delete message "Successfully Deleted"

    Examples: 
      | index |
      |     0 |
