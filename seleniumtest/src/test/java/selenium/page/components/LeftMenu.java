package selenium.page.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.page.BaseView;

public class LeftMenu extends BaseView {

	private WebElement menuButton;
	private WebElement usersRolesButton;
	private WebElement userAdministrationButton;
	private WebElement administratorSubMenu;
	private WebElement productMenuItem;

	private By menuButtonLocator;
	private By administratorSubMenuLocator;
	private By productMenuItemLocator;
	private By usersRolesButtonLocator;
	private By userAdministrationButtonLocator;

	public LeftMenu(WebDriver webDriver) {
		super(webDriver);
		initializeLocators();
		findWebElements(webDriver);

	}

	private void initializeLocators() {
		menuButtonLocator = By.id("menu-button");
		usersRolesButtonLocator = By.id("users_roles");
		userAdministrationButtonLocator = By.id("user_administration");
		administratorSubMenuLocator = By.id("adminSubmenu");
		productMenuItemLocator = By.xpath("//*[@id=\"Product_administration\"]/a");
	}

	private void findWebElements(WebDriver webDriver) {
		menuButton = webDriver.findElement(menuButtonLocator);

	}

	public void navigateToUsersManagment() throws InterruptedException {

		menuButton.click();
		Thread.sleep(1000);
		usersRolesButton = webDriver.findElement(usersRolesButtonLocator);
		usersRolesButton.click();
		Thread.sleep(1000);
		userAdministrationButton = webDriver.findElement(userAdministrationButtonLocator);
		userAdministrationButton.click();
		Thread.sleep(1000);

	}

	public void navigateToProductManagment() throws InterruptedException {

		menuButton.click();
		Thread.sleep(1000);
		administratorSubMenu = webDriver.findElement(administratorSubMenuLocator);
		administratorSubMenu.click();
		Thread.sleep(1000);
		productMenuItem = webDriver.findElement(productMenuItemLocator);
		productMenuItem.click();

	}

}
