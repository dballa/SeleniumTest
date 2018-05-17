package selenium.tests.product;

import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.PWD;
import static selenium.tests.utils.Constants.USR;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import selenium.page.login.LoginView;
import selenium.page.product.ProductView;
import selenium.utils.DriverUtil;

public class ProductTest {

	public static WebDriver driver;
	public static LoginView loginView;
	public static ProductView productView;

	@BeforeClass
	public static void init() throws InterruptedException {
		driver = DriverUtil.getChromeDriver();
		loginView = new LoginView(driver);
		loginView.login(USR, PWD);
		Thread.sleep(2000);
		productView = new ProductView(driver);
	}

	@Test
	public void addProductTest() throws InterruptedException {

		productView.getNavigationComponents().getLeftMenu().navigateToProductManagment();
		productView.addProduct();
		assertTrue(productView.isAddedCorrectProduct());
	}
	
	@Test
	public void editProductTest() throws InterruptedException {
		productView.editProduct();
		assertTrue(productView.isEditCorrectProduct());
	}

	@Test
	public void disableProduct() throws InterruptedException {
		productView.disableProduct();
		assertTrue(productView.isToggleDisabled());
	}
	@AfterClass
	public static void close() {
		driver.quit();
	}
}
