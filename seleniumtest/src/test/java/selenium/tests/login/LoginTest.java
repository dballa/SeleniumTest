package selenium.tests.login;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.page.login.LoginView;
import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

	public static WebDriver driver ;
	
	public LoginView loginView;
	
	@Before
	public void init() {
		driver = DriverUtil.getChromeDriver();
		loginView= new LoginView(driver);
		
	}
	
	
	@Test
	public void test_1() throws InterruptedException {
		
		loginView.login();
		assertTrue(loginView.isLoggedIn());

	}
	

	
/*	@Test
	public void test_2() throws InterruptedException {
		
		driver.findElement(By.className("icon-settings")).click();
		
	}
	
	@Test
	public void test_3() throws InterruptedException {}
*/
}
