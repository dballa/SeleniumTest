package seleniumtest.page.login;

import static seleniumtest.Util.DASHBOARD;
import static seleniumtest.Util.USR;
import static seleniumtest.Util.PWD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumtest.AbstractView;
import seleniumtest.Util;

public class LoginView extends AbstractView {

	private WebElement username;
	private WebElement password;
	private WebElement loginButton;

	private boolean loggedIn;

	private By usernameLocator = By.id("loginForm:username");
	private By passwordLocator = By.id("loginForm:password");
	private By loginButtonLocator = By.id("loginForm:loginButton");

	public LoginView(WebDriver webDriver) {
		super(webDriver);
		navigateToLogin();
		username = webDriver.findElement(usernameLocator);
		password = webDriver.findElement(passwordLocator);
		loginButton = webDriver.findElement(loginButtonLocator);

	}

	public void login() throws InterruptedException {

		username.sendKeys(USR);
		password.sendKeys(PWD);

		loginButton.click();
		Thread.sleep(2000);
		loggedIn = webDriver.getCurrentUrl().contains(DASHBOARD);

	}

	private void navigateToLogin() {
		
		webDriver.navigate().to(Util.LOGIN_URL);
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
