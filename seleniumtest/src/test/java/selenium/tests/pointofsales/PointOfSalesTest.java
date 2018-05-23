package selenium.tests.pointofsales;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.PASSWORD;
import static selenium.tests.utils.Constants.USR;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.page.login.LoginView;
import selenium.page.pos.PointOfSalesView;
import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointOfSalesTest {
	
	public static WebDriver webDriver;
	
	public static PointOfSalesView pointOfSalesView;
	
	@BeforeClass
	public static void init() throws InterruptedException {
		webDriver = DriverUtil.getChromeDriver();
		
		LoginView loginView = new LoginView(webDriver);
		loginView.login(USR, PASSWORD);
		
		pointOfSalesView = new PointOfSalesView(webDriver);
	}
	
//	@Test
//	public void test1ForwardButton() throws InterruptedException {
//		pointOfSalesView.forward();
//		pointOfSalesView.backward();
//	}
//	
//	@Test
//	public void test2PointOfSalesNumbers() {
//		assertTrue(12 ==  pointOfSalesView.getPointOfSales().size());
//	}
	
	@Test
	public void test3PointOfSaleName() throws InterruptedException {
		pointOfSalesView.getFirstPointOfSale();
	}
	
	

}
