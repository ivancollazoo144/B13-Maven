package com.steps;

 

import com.page.AdminPage;
import com.page.JobTitlesPage;
import com.page.LoginPage;
import com.page.MenuPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Hooks;

public class JobTitlesStep {

	LoginPage loginObj;
	MenuPage menuObj;
	AdminPage adminObj;
	JobTitlesPage jobTitleObj;

	@Given("Admin User navigates to NTK Login page {string}")
	public void navigateToNTK(String url) throws InterruptedException {
		Hooks.setUp("firefox");
		Hooks.driver.get(url);

		loginObj = new LoginPage(Hooks.driver);
		menuObj = new MenuPage(Hooks.driver);
		adminObj = new AdminPage(Hooks.driver);
		jobTitleObj = new JobTitlesPage(Hooks.driver);

	}

	@Given("Admin User provides credentials {string} {string}")
	public void enterUserCredentials(String username, String password) {
		loginObj.enterUsername(username);
		loginObj.enterPassword(password);
	}

	@Given("Admin User clicks login button")
	public void clickLoginBtn() {
		loginObj.clickLogin();
	}

	@When("Admin User navigates to {string} page")
	public void navigateToPage(String page) {
		menuObj.navigateTo(page);
	}

	@When("Admin User selects {string} from {string} dropdown")
	public void selectValueFromDropdown(String jobTitles, String job) throws InterruptedException {
		Thread.sleep(1000);
		adminObj.fromTopMenuNavigateTo(job, jobTitles);
	}

	@When("Admin User clicks add button")
	public void clickAddBtn() {
		jobTitleObj.clickAdd();
	}

	@When("Admin User provides Job Title field values {string} {string} {string}")
	public void enterJobTitleFieldValues(String jobTitle, String jobDesc, String notes) throws InterruptedException {
		jobTitleObj.enterJobTitle(jobTitle);
 
		Thread.sleep(4000);
		jobTitleObj.enterJobDescription(jobDesc);
		 

		jobTitleObj.enterNotes(notes);
	 

	}

	@When("Admin User clicks save button")
	public void clickSaveBtn() {
		jobTitleObj.clickSave();
	}

	@Then("System displays success message {string}")
	public void verifySuccessMessage(String message) {
		String actMessage = jobTitleObj.getSuccessMessage();

		if (actMessage.equals(message)) {
			System.out.println("Testcase passed:");
		} else {
			System.out.println("Testcase Failed:");
		}

		Hooks.tearDown();
	}
	
	@Then("System displays update message {string}")
	public void verifyUpdateMessage(String message) {
		String actMessage = jobTitleObj.getUpdateMessage();

		if (actMessage.equals(message)) {
			System.out.println("Testcase passed:");
		} else {
			System.out.println("Testcase Failed:");
		}

		Hooks.tearDown();
	}
	
	@Then("System displays delete message {string}")
	public void verifyDeleteMessage(String message) {
		String actMessage = jobTitleObj.getDeleteMessage();

		if (actMessage.equals(message)) {
			System.out.println("Testcase passed:");
		} else {
			System.out.println("Testcase Failed:");
		}

		Hooks.tearDown();
	}

	@Then("System displays error message under Job Titles field {string}")
	public void verifyAlreadyExistsMessage(String message) {

		String actMessage = jobTitleObj.getAlreadyExistText();

		if (actMessage.equals(message)) {
			System.out.println("Testcase passed:");
		} else {
			System.out.println("Testcase Failed:");
		}

		Hooks.tearDown();
	}
	

 
	
	
	
	@Given("Admin User clicks edit icon {int}")
	public void clickEditIcon(Integer index) {

		jobTitleObj.editExistingJob(index);
	}

	
	@Given("Admin User clicks delete icon {int}")
	public void clickDeleteIcon(Integer index) {

		jobTitleObj.deleteExistingJob(index);
	}
	
	
	@When("Admin User clicks Yes Delete button")
	public void clickYesDeleteBtn() {
		jobTitleObj.clickYesDelete();
	}
	
	
	@Given("Admin User clicks edit icon2 {string}")
	public void admin_user_clicks_edit_icon2(String jobName) {
	   jobTitleObj.editExistingJob(jobName);
	}
}
