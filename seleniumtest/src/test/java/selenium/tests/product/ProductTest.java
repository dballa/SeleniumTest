package selenium.tests.product;
import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.PWD;
import static selenium.tests.utils.Constants.USR;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import selenium.page.dashboard.DashboardView;
import selenium.page.login.LoginView;
import selenium.page.product.ProductView;
import selenium.utils.DriverUtil;

public class ProductTest {
	
	
	public static WebDriver driver;
	public static LoginView loginView;
	public static DashboardView dashboardView;
	public static ProductView productView;
	
	
	@BeforeClass
	public static void  init() throws InterruptedException {
		driver = DriverUtil.getChromeDriver();
		loginView= new LoginView(driver);
		dashboardView=new DashboardView(driver);
		productView=new ProductView(driver);
	}
	@Test
	public void addProductTest() throws InterruptedException {
		loginView.login(USR, PWD);
		Thread.sleep(2000);
		dashboardView.redirectToManageProduct();
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
}
