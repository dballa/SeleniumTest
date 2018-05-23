package selenium.page.usersAdministration;

import static selenium.tests.utils.Constants.INVALID_EMAIL_AL;
import static selenium.tests.utils.Constants.INVALID_EMAIL_EN;
import static selenium.tests.utils.Constants.PASSWORD;
import static selenium.tests.utils.Constants.TEST;
import static selenium.utils.StaleUtils.returnNotStaleWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.page.BaseView;
import selenium.page.components.NavigationComponents;

public class UserAdministrationView extends BaseView {

	private NavigationComponents navigationComponents;

	@FindBy(id = "contentForm:userName")
	private WebElement name;
	@FindBy(id = "contentForm:userSurname")
	private WebElement surname;
	@FindBy(id = "contentForm:userEmail")
	private WebElement email;
	@FindBy(id = "contentForm:userAddress")
	private WebElement address;
	@FindBy(id = "contentForm:userPassword")
	private WebElement password;
	@FindBy(id = "contentForm:addUsers")
	private WebElement addButton;
	@FindBy(id = "contentForm:clearButton")
	private WebElement clearButton;

	@FindBy(id = "contentForm:userRole")
	private WebElement dropdown;

	@FindBy(id = "contentForm:userRole_1")
	private WebElement dropDownFirstOption;

	@FindBy(className = "ui-growl-message")
	private WebElement growl;

	private boolean emptyFields;
	private boolean messagePresent;

	public UserAdministrationView(WebDriver webDriver) throws InterruptedException {
		super(webDriver);
		navigationComponents = new NavigationComponents(webDriver);
		navigationComponents.getLeftMenu().navigateToUsersManagment();

	}

	/*
	 * Method to fill dhe field with wrong or correct email
	 */
	public void fill(String theEmail) {
		getName().sendKeys(TEST);
		getSurname().sendKeys(TEST);
		getEmail().sendKeys(theEmail);
		getAddress().sendKeys(TEST);
		getPassword().sendKeys(PASSWORD);

		getDropdown().click();

		dropDownFirstOption.click();
	}

	public void clear() {
		getClearButton().click();
	}

	public void submit() {
		getAddButton().click();
	}

	public void catchMessage() {

		messagePresent = growl.getText().contains(INVALID_EMAIL_AL) || growl.getText().contains(INVALID_EMAIL_EN);

	}

	public boolean fieldsAreEmpty() {
		if (getName().getText().isEmpty())
			return true;
		else if (getPassword().getText().isEmpty())
			return true;
		else if (getSurname().getText().isEmpty())
			return true;
		else if (getEmail().getText().isEmpty())
			return true;
		else if (getAddress().getText().isEmpty())
			return true;

		return false;

	}

	public boolean isEmptyFields() {
		return emptyFields;
	}

	public boolean isMessagePresent() {
		return messagePresent;
	}

	public WebElement getName() {

		return returnNotStaleWebElement(name, By.id("contentForm:userName"), webDriver);

	}

	public WebElement getSurname() {
		return returnNotStaleWebElement(surname, By.id("contentForm:userSurname"), webDriver);
	}

	public WebElement getEmail() {
		return returnNotStaleWebElement(email, By.id("contentForm:userEmail"), webDriver);

	}

	public WebElement getAddress() {
		return returnNotStaleWebElement(address, By.id("contentForm:userAddress"), webDriver);
	}

	public WebElement getPassword() {
		return returnNotStaleWebElement(password, By.id("contentForm:userPassword"), webDriver);
	}

	public WebElement getAddButton() {
		return returnNotStaleWebElement(addButton, By.id("contentForm:addUsers"), webDriver);
	}

	public WebElement getClearButton() {
		return returnNotStaleWebElement(clearButton, By.id("contentForm:clearButton"), webDriver);

	}

	public WebElement getDropdown() {
		return returnNotStaleWebElement(dropdown, By.id("contentForm:userRole"), webDriver);

	}

	public void setName(WebElement name) {
		this.name = name;
	}

	public void setSurname(WebElement surname) {
		this.surname = surname;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public void setAddress(WebElement address) {
		this.address = address;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setAddButton(WebElement addButton) {
		this.addButton = addButton;
	}

	public void setClearButton(WebElement clearButton) {
		this.clearButton = clearButton;

	}

	public void setDropdown(WebElement dropdown) {
		this.dropdown = dropdown;
	}
}
