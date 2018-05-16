package selenium;

import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.EMAIL;
import static selenium.tests.utils.Constants.INVALID_EMAIL;
import static selenium.tests.utils.Constants.NAME;
import static selenium.tests.utils.Constants.PASSWORD;
import static selenium.tests.utils.Constants.SURNAME;
import static selenium.tests.utils.Constants.TEST;
import static selenium.tests.utils.Constants.WRONG_EMAIL;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlpetTest {

	public static WebDriver driver = DriverUtil.getChromeDriver();

	@Test
	public void test1Login() throws InterruptedException {

		driver.navigate().to("http://localhost:8081/alpet-fe/login.xhtml");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("loginForm:username"));
		WebElement password = driver.findElement(By.id("loginForm:password"));
		username.sendKeys("admin");
		password.sendKeys("Admin123+");
		driver.findElement(By.id("loginForm:loginButton")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("dashboard.xhtml"));
		Thread.sleep(2000);

	}
	
	@Test
	public void test2ManageUser() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("menu-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("users_roles")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("user_administration")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("userView.xhtml"));
		Thread.sleep(2000);
	}
	
	@Test
	public void test3ClearButton() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.id("contentForm:userName"));
		userName.sendKeys(TEST);
		WebElement userSurname = driver.findElement(By.id("contentForm:userSurname"));
		userSurname.sendKeys(TEST);
		WebElement userEmail = driver.findElement(By.id("contentForm:userEmail")); 
		userEmail.sendKeys(TEST);
		WebElement userAddress = driver.findElement(By.id("contentForm:userAddress"));
		userAddress.sendKeys(TEST);
		WebElement userPassword = driver.findElement(By.id("contentForm:userPassword"));
		userPassword.sendKeys(TEST);
		Thread.sleep(2000);
		driver.findElement(By.id("contentForm:clearButton")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.id("contentForm:userName")).getText().isEmpty());
		assertTrue(driver.findElement(By.id("contentForm:userSurname")).getText().isEmpty());
		assertTrue(driver.findElement(By.id("contentForm:userUserName")).getText().isEmpty());
		assertTrue(driver.findElement(By.id("contentForm:userEmail")).getText().isEmpty());
		assertTrue(driver.findElement(By.id("contentForm:userAddress")).getText().isEmpty());
		assertTrue(driver.findElement(By.id("contentForm:userPassword")).getText().isEmpty());
		Thread.sleep(2000);
	}
	
	@Test
	public void test4AddUserFail() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.id("contentForm:userName"));
		userName.sendKeys(NAME);
		WebElement userSurname = driver.findElement(By.id("contentForm:userSurname"));
		userSurname.sendKeys(SURNAME);
		WebElement dropdown = driver.findElement(By.id("contentForm:userRole"));
		dropdown.click();
		WebElement option = driver.findElement(By.id("contentForm:userRole_1"));
		option.click();
		WebElement userEmail = driver.findElement(By.id("contentForm:userEmail")); 
		userEmail.sendKeys(WRONG_EMAIL);
		WebElement userPassword = driver.findElement(By.id("contentForm:userPassword"));
		userPassword.sendKeys(PASSWORD);
		Thread.sleep(2000);
		driver.findElement(By.id("contentForm:addUsers")).click();
		Thread.sleep(1000);
		WebElement msg = driver.findElement(By.className("ui-growl-message"));
		assertTrue(msg.getText().contains(INVALID_EMAIL));	
		driver.findElement(By.id("contentForm:clearButton")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void test5EmptyFields() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.id("contentForm:addUsers")).click();
		List<WebElement> elements = driver.findElements(By.className("ui-growl-title"));
		assertTrue(elements.size() == 5);
		Thread.sleep(5000);
	}
	
	@Test
	public void test6AddUser() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.id("contentForm:userName"));
		userName.sendKeys(NAME);
		WebElement userSurname = driver.findElement(By.id("contentForm:userSurname"));
		userSurname.sendKeys(SURNAME);
		WebElement userEmail = driver.findElement(By.id("contentForm:userEmail")); 
		userEmail.sendKeys(EMAIL);
		WebElement userPassword = driver.findElement(By.id("contentForm:userPassword"));
		userPassword.sendKeys(PASSWORD);
		WebElement dropdown = driver.findElement(By.id("contentForm:userRole"));
		dropdown.click();
		WebElement option = driver.findElement(By.id("contentForm:userRole_1"));
		option.click();
		Thread.sleep(2000);
		driver.findElement(By.id("loginForm:loginButton")).click();
		Thread.sleep(2000);
	}

}
