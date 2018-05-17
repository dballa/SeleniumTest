package selenium.page.login;

import static selenium.tests.utils.Constants.DASHBOARD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.page.BaseView;
import selenium.tests.utils.Constants;

public class LoginView extends BaseView {

	@FindBy(id = "form:username")
	private WebElement username;

	@FindBy(id = "form:password")
	private WebElement password;

	@FindBy(id = "form:loginButton")
	private WebElement loginButton;

	private boolean loggedIn;

	public LoginView(WebDriver webDriver) throws InterruptedException {
		super(webDriver);

		webDriver.manage().window().maximize();

		navigateToLogin();

	}

	public void login(String usr, String pass) throws InterruptedException {

		username.sendKeys(usr);
		password.sendKeys(pass);
		loginButton.click();
		Thread.sleep(2000);
		loggedIn = webDriver.getCurrentUrl().contains(DASHBOARD);
	}

	private void navigateToLogin() {

		webDriver.navigate().to(Constants.LOGIN_URL);
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
