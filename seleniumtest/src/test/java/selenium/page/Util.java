package selenium.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {
	
	/*
	 * Return table's rows
	 */
	public static List<WebElement> getRows(WebElement table){
		
		if(table != null) {
			return table.findElements(By.tagName("tr"));
		}
		return null;
	}

	/*
	 * Return row's columns
	 */
	public static List<WebElement> getColumns(WebElement row){
		
		return row.findElements(By.tagName("td"));
	}
	
	/*
	 * Extract double number from web element
	 */
	public static double extractDouble(WebElement element) {
		return Double.parseDouble(element.getText().replace(",", ""));
	}
	
	/*
	 * Return web element's input
	 */
	public static WebElement getInputElement(WebElement element) {
		return element.findElement(By.tagName("input"));
	}
	
	/*
	 * Return web element's span
	 */
	public static WebElement getSpanElement(WebElement element) {
		return element.findElement(By.tagName("span"));
	}
	
	/*
	 * Implicit wait
	 */
	public static void sleep(WebDriver webDriver) {
		webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/*
	 * Get actions instance
	 */
	public static Actions getActions(WebDriver driver) {
		return new Actions(driver);
	}
	
	/*
	 * Fill table 
	 */
	public static double fillTable(WebDriver webDriver, WebElement table, int quantityColumn, int valueColumn, double quantity) {
		
		double sum = 0;
		try {
			for(WebElement row : getRows(table)) {
				List<WebElement> columns = getColumns(row);
				getInputElement(columns.get(quantityColumn)).sendKeys(Double.toString(quantity));
				Thread.sleep(1000);
				sum += extractDouble(getSpanElement(columns.get(valueColumn)));
			}
			return sum;
		} catch(Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}
	
	/*
	 * Fill table's cell 
	 */
	public static void fillCell(WebDriver webDriver, WebElement table, int rowIndex, int columnIndex, String value) {
		getActions(webDriver).moveToElement(getColumns(getRows(table).get(rowIndex)).get(columnIndex)).click().sendKeys(value)
					.build()
					.perform();			
	}
	
	/*
	 * Compare inner text
	 */
	public static boolean compareInnerText(WebElement element, String ARG_AL, String ARG_EN) {

		return element.getText().contains(ARG_AL) || element.getText().contains(ARG_EN);
	}
	
	/*
	 * Refresh page
	 */
	public static void refresh(WebDriver webDriver) {
		webDriver.navigate().refresh();
	}
	
	/*
	 * Scrolling to an element
	 */
	public static void scrollToElement(WebDriver webDriver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("arguments[0].scrollIntoView();", element); 
	}
	
	/*
	 * Return span element from teable footer
	 */
	public static WebElement getSpanFromTableFooter(WebDriver webDriver, By by) {
		return webDriver.findElement(by).findElement(By.tagName("tfoot")).findElement(By.tagName("tr")).findElements(By.tagName("td")).get(1).findElement(By.tagName("span"));
	}
	
	
	
}
