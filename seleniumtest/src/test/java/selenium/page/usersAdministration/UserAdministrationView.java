package selenium.page.usersAdministration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static selenium.tests.utils.Constants.*;

import selenium.page.AbstractView;
import selenium.page.dashboard.DashboardView;

public class UserAdministrationView extends AbstractView {

	private WebElement name;
	private WebElement surname;
	private WebElement email;
	private WebElement address;
	private WebElement password;
	private WebElement addButton;
	private WebElement clearButton;
	private WebElement dropdown;
	
	
	private DashboardView dashboardView;
	
	private boolean emptyFields;
	private boolean messagePresent;
	
	private By nameLocator = By.id("contentForm:userName");
	private By surnameLocator = By.id("contentForm:userSurname");
	private By dropdownLocator = By.id("contentForm:userRole");
	private By emailLocator = By.id("contentForm:userEmail");
	private By addressLocator = By.id("contentForm:userAddress");
	private By passwordLocator = By.id("contentForm:userPassword");
	private By addButtonLocator = By.id("contentForm:addUsers");
	private By clearButtonLocator = By.id("contentForm:clearButton");
	
	

	public UserAdministrationView(WebDriver webDriver) throws InterruptedException {
		super(webDriver);
		dashboardView = new DashboardView(webDriver);
		dashboardView.navigateToUserAdministration();
		name = webDriver.findElement(nameLocator);
		surname = webDriver.findElement(surnameLocator);
		dropdown = webDriver.findElement(dropdownLocator);
		email = webDriver.findElement(emailLocator);
		address = webDriver.findElement(addressLocator);
		password = webDriver.findElement(passwordLocator);
		addButton = webDriver.findElement(addButtonLocator);
		clearButton = webDriver.findElement(clearButtonLocator);
	}
	
	public void fill(String theEmail) {
		getName().sendKeys(TEST);
		getSurname().sendKeys(TEST);
		getEmail().sendKeys(theEmail);
		getAddress().sendKeys(TEST);
		getPassword().sendKeys(PASSWORD);
		
		getDropdown().click();
		WebElement option = webDriver.findElement(By.id("contentForm:userRole_1"));
		option.click();
	}
	
	public void clear() {
		getClearButton().click();
	}
	
	public void submit() {
		getAddButton().click();
	}
	
//	public void checkFields() {
//		StringBuilder sb = new StringBuilder().append(name.getText()).append(surname.getText()).append(email.getText()).append(address.getText()).append(password.getText());
//		emptyFields = (sb.length() == 0);
//	}
	
	public void catchMessage() {
		WebElement msg = webDriver.findElement(By.className("ui-growl-message"));
		messagePresent = msg.getText().contains(INVALID_EMAIL);
	}
	public boolean isEmptyFields() {
		return emptyFields;
	}
	public boolean isMessagePresent() {
		return messagePresent;
	}
	public WebElement getName() {
		return webDriver.findElement(nameLocator);
	}
	public WebElement getSurname() {
		return webDriver.findElement(surnameLocator);
	}
	public WebElement getEmail() {
		return webDriver.findElement(emailLocator);
	}
	public WebElement getAddress() {
		return webDriver.findElement(addressLocator);
	}
	public WebElement getPassword() {
		return webDriver.findElement(passwordLocator);
	}
	public WebElement getAddButton() {
		return webDriver.findElement(addButtonLocator);
	}
	public WebElement getClearButton() {
		return webDriver.findElement(clearButtonLocator);
	}
	public DashboardView getDashboardView() {
		return dashboardView;
	}
	public WebElement getDropdown() {
		return webDriver.findElement(dropdownLocator);
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
