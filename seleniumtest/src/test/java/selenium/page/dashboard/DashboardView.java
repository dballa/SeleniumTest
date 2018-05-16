package selenium.page.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static selenium.tests.utils.Constants.*;

import selenium.page.AbstractView;
import selenium.page.login.LoginView;


public class DashboardView extends AbstractView {
	
	private WebElement menuButton;
	private WebElement usersRolesButton;
	private WebElement userAdministrationButton;
	
	private LoginView loginView;
	
	private By menuButtonLocator = By.id("menu-button");
	private By usersRolesButtonLocator = By.id("users_roles");
	private By userAdministrationButtonLocator = By.id("user_administration");
	

	public DashboardView(WebDriver webDriver) throws InterruptedException {
		super(webDriver);
		loginView = new LoginView(webDriver);
		loginView.login(USR, PWD);
		menuButton = webDriver.findElement(menuButtonLocator);
		usersRolesButton = webDriver.findElement(usersRolesButtonLocator);
		userAdministrationButton = webDriver.findElement(userAdministrationButtonLocator);	
	}
	
	public void navigateToUserAdministration() throws InterruptedException {
			menuButton.click();
			Thread.sleep(1000);
			usersRolesButton.click();
			Thread.sleep(1000);
			userAdministrationButton.click();
		}

}
