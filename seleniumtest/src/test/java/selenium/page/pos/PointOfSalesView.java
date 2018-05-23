package selenium.page.pos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.page.BaseView;
import selenium.page.components.NavigationComponents;
import selenium.page.dailysales.DailySalesView;

import static selenium.utils.StaleUtils.returnNotStaleWebElement;

public class PointOfSalesView extends BaseView {
	
	private NavigationComponents navigationComponents;
	
	private WebElement forwardButton;
	private WebElement backwardButton;
	private List<WebElement> pointOfSales;
	
	private By pointOfSalesLocator;
	private By forwardButtonLocator;
	private By backwardButtonLocator;

	public PointOfSalesView(WebDriver webDriver) throws InterruptedException {
		
		super(webDriver);
		navigationComponents = new NavigationComponents(webDriver);
		navigationComponents.getLeftMenu().navigateToPointOfSales();
		Thread.sleep(2000);
		initializeLocators();
		forwardButton = webDriver.findElement(forwardButtonLocator);
		backwardButton = webDriver.findElement(backwardButtonLocator);
		pointOfSales = webDriver.findElements(pointOfSalesLocator);
	}
	
	private void initializeLocators() {
		backwardButtonLocator = By.className("ui-paginator-prev");
		forwardButtonLocator = By.className("ui-paginator-next");
		pointOfSalesLocator = By.className("ui-datagrid-column");
		
	}
	
	/*
	 * Click forward button
	 */
	public void forward() throws InterruptedException {
		
		getForwardButton().click();
		Thread.sleep(2000);
		findPointOfSales();
	}
	
	/*
	 * Click backward button
	 */
	public void backward() throws InterruptedException {
		
		getBackwardButton().click();
		Thread.sleep(2000);
		findPointOfSales();
	}
	
	/*
	 * Find point of sales elements
	 */
	public void findPointOfSales() {
		if(pointOfSales != null) {
			pointOfSales.clear();
		}
		pointOfSales = webDriver.findElements(By.className("ui-datagrid-column"));
	}
	
	public DailySalesView getFirstPointOfSale() throws InterruptedException {
		
	pointOfSales.get(0).findElement(By.id("contentForm:data_grid:0:pos_img")).click();
	return new DailySalesView(webDriver);
}

	public WebElement getForwardButton() {
		return returnNotStaleWebElement(forwardButton, forwardButtonLocator, webDriver);
	}

	public WebElement getBackwardButton() {
		return returnNotStaleWebElement(backwardButton, backwardButtonLocator, webDriver);
	}

	public List<WebElement> getPointOfSales() {
		return pointOfSales;
	}
	
	
}
