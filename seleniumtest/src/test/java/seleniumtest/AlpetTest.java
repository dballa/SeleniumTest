package seleniumtest;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlpetTest {

	public static DriverUtil driverUtil = new DriverUtil();
	public static WebDriver driver = driverUtil.getDriver();

	@Test
	public void loginTest() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:8080/alpet-fe/login.xhtml");
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt9\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt11\"]"));
		userName.sendKeys("admin");
		password.sendKeys("Admin123+");
		driver.findElement(By.xpath("//*[@id=\"j_idt8:j_idt14\"]")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		assertTrue(url.contains("dashboard"));

	}

	@Test
	public void manageProductTest() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"menu-button\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"j_idt36\"]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Product_administration\"]/a")).click();
		Thread.sleep(1000);
		String urlProduct = driver.getCurrentUrl();
		assertTrue(urlProduct.contains("productView.xhtml"));

	}

	@Test
	public void dataTableNotEmptyTest() {
		WebElement dataTable = driver.findElement(By.xpath("//*[@id=\"contentForm:productTable\"]/div[2]/table"));
		List<WebElement> tableRows=(List<WebElement>) dataTable.findElement(By.tagName("tr"));
	}

}
