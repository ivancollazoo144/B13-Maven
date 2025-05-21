package com.page;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTitlesPage {

	@FindBy(xpath = "//h6[text()='Job Titles']")
	WebElement pageHeader;

	@FindBy(xpath = "//*[text()=' Add ']")
	WebElement addBtn;

	@FindBy(xpath = "//*[text()=' Save ']")
	WebElement saveBtn;

	@FindBy(xpath = "//*[text()=' Cancel ']")
	WebElement cancelBtn;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement jobTitleField;

	@FindBy(xpath = "//*[@placeholder='Type description here']")
	WebElement jobDescriptionField;

	@FindBy(xpath = "//*[@placeholder='Add note']")
	WebElement noteField;

	@FindBy(xpath = "//*[text()='Successfully Saved']")
	WebElement successMessage;

	// *[contains(text(),'Successfully')]

	@FindBy(xpath = "//*[text()='Successfully Updated']")
	WebElement updateMessage;

	@FindBy(xpath = "//*[text()='Successfully Deleted']")
	WebElement deleteMessage;

	@FindBy(xpath = "//*[text()='Already exists']")
	WebElement alreadyExistMessage;

	@FindBy(css = ".oxd-icon.bi-pencil-fill")
	List<WebElement> editIconList;

	@FindBy(css = ".oxd-icon.bi-trash")
	List<WebElement> deleteIconList;

	@FindBy(xpath = "//*[text()=' Yes, Delete ']")
	WebElement yesDeleteBtn;

	@FindBy(xpath = "//*[@style='flex: 2 1 0%;']/div")
	List<WebElement> jobList;

	public JobTitlesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickAdd() {
		addBtn.click();
	}

	public void clickSave() {
		saveBtn.click();
	}

	public void clickCancel() {
		cancelBtn.click();
	}

	public void enterJobTitle(String title) {
		jobTitleField.clear();
		jobTitleField.sendKeys(title);
	}

	public void enterJobDescription(String description) {
		jobDescriptionField.clear();
		jobDescriptionField.sendKeys(description);
	}

	public void enterNotes(String notes) {
		noteField.clear();
		noteField.sendKeys(notes);
	}

	public String getPageHeader() {
		String text = pageHeader.getText();
		return text;
	}

	public String getSuccessMessage() {
		String message = successMessage.getText();
		return message;
	}

	public String getAlreadyExistText() {
		String text = alreadyExistMessage.getText();
		return text;
	}

	public void editExistingJob(int index) {

		for (int i = 0; i < editIconList.size(); i++) {

			if (i == index) {
				WebElement el = editIconList.get(0);
				el.click();
				break;
			}
		}

	}

	public void editExistingJob(String jobName) {

		int index = getIndexOfJob(jobName);

		for (int i = 0; i < editIconList.size(); i++) {

			if (i == index) {
				WebElement el = editIconList.get(0);
				el.click();
				break;
			}
		}

	}

	public void deleteExistingJob(int index) {

		for (int i = 0; i < deleteIconList.size(); i++) {

			if (i == index) {
				WebElement el = deleteIconList.get(0);
				el.click();
				break;
			}
		}

	}

	public int getIndexOfJob(String jobName) {
		int index = -1;

		for (int i = 0; i < jobList.size(); i++) {

			String name = jobList.get(0).getText();

			System.out.println("************" + name + "**************");
			if (jobName.equals(name)) {
				System.out.println(name + "breaking Out" + i);
				index = i;
				break;
			}

		}
		return index + 1;
	}

	public String getUpdateMessage() {
		String message = updateMessage.getText();
		return message;
	}

	public String getDeleteMessage() {
		String message = deleteMessage.getText();
		return message;
	}

	public void clickYesDelete() {
		yesDeleteBtn.click();
	}

}
