package selenium.tests.dshboard;

import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.PWD;
import static selenium.tests.utils.Constants.USR;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import selenium.page.dashboard.DashboardView;
import selenium.page.login.LoginView;
import selenium.utils.DriverUtil;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DashboardTest {

	public static WebDriver driver;
	public static LoginView loginView;
	public static DashboardView dashboardView;
	
	@BeforeClass
	public static void init() throws InterruptedException {
		driver = DriverUtil.getChromeDriver();
		loginView = new LoginView(driver);
		loginView.login(USR, PWD);
		Thread.sleep(2000);
		dashboardView=new DashboardView(driver);
	}
	
	@Test
	public void test1CheckDaysBeforeSupplyTest() throws InterruptedException {
		
		dashboardView.checkDaysBeforeSupply();
		assertTrue(dashboardView.isDaysCalculation());
	}
	@Test
	public void test2EnglishLanguageTest() throws InterruptedException {
		dashboardView.englishLanguage();
		assertTrue(dashboardView.isSystemInEnglish());
	}
	@Test
	public void test3AlbanianLanguageTest() throws InterruptedException {
		dashboardView.albanianLanguage();
		assertTrue(dashboardView.isSystemInAlbanian());
		
	}
	@Test
	public void test4RedirectToProfileTest() {
		dashboardView.redirectToProfile();
		assertTrue(dashboardView.isOnProfileView());
	}
	
	@Test
	public void test5LogoutTest() {
		
		dashboardView.logout();
		assertTrue(dashboardView.isLogedOut());
	}

	@AfterClass
	public static void close() {
		driver.quit();
	}

}
