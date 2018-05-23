package selenium.page.dailysales;

import static selenium.utils.StaleUtils.returnNotStaleWebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static selenium.page.Util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.page.BaseView;

public class DailySalesView extends BaseView {
	
	private List<WebElement> tableRows;
	private List<WebElement> tableColumns;
	
	@FindBy(id="contentForm:registrationDate_input")
	private WebElement date;
	@FindBy(className = "ui-growl-message")
	private WebElement growl;
	@FindBy(id= "contentForm:accordion:pistolTable_data")
	private WebElement pistolTable;
	@FindBy(id="contentForm:accordion:voucherTable_data")
	private WebElement voucherTable;
	@FindBy(id="contentForm:accordion:openVoucherDialog")
	private WebElement voucherButton;
	@FindBy(id="contentForm:accordion:bonus_sales_button")
	private WebElement bonusSalesButton;
	@FindBy(id="contentForm:accordion:autoFastTable_data")
	private WebElement autoFastTable;
	@FindBy(id="contentForm:accordion:testTable_data")
	private WebElement testTable;
	@FindBy(id="contentForm:accordion:calculateCashSalesBtn")
	private WebElement calculateCashSalesButton;	
	@FindBy(id="contentForm:accordion:daily_spending_button")
	private WebElement dailySpendingButton;	
	@FindBy(id="contentForm:accordion:pos_sales")
	private WebElement posSalesButton;	
	@FindBy(id="contentForm:accordion:inventoryTable_data")
	private WebElement moneyTable;	
	@FindBy(id="contentForm:accordion:comments")
	private WebElement commentsField;	
	@FindBy(id="contentForm:accordion:calculateBtn")
	private WebElement calculateButton;	
	@FindBy(id="contentForm:accordion:total_sales")
	private WebElement totalSales;	
	@FindBy(id= "contentForm:accordion:voucher_sales")
	private WebElement voucherSales;	
	@FindBy(id= "contentForm:accordion:bonus_sales")
	private WebElement bonusSales;	
	@FindBy(id= "contentForm:accordion:autofast_sales")
	private WebElement autofastSales;	
	@FindBy(id= "contentForm:accordion:test_sales")
	private WebElement testSales;	
	@FindBy(id= "contentForm:accordion:cash_sales")
	private WebElement cashSales;	
	@FindBy(id= "contentForm:accordion:poss_sales")
	private WebElement posSales;	
	@FindBy(id= "contentForm:accordion:daily_spendings")
	private WebElement dailySpendings;	
	@FindBy(id= "contentForm:accordion:expected_money")
	private WebElement expectedMoney;	
	@FindBy(id= "contentForm:addBtn")
	private WebElement registerButton;	
	@FindBy(id= "contentForm:resetBtn")
	private WebElement resetButton;
	@FindBy(id = "contentForm:accordion:cardTable_data")
	private WebElement bonusSalesTable;
	@FindBy(id = "contentForm:accordion:cardTable:0:products")
	private WebElement productsDropdown;
	@FindBy(id = "contentForm:accordion:cardTable:0:products_1")
	private WebElement productsDropDownFirstOption;
	@FindBy(id = "contentForm:accordion:dailySpendings_data")
	private WebElement dailySpendingTable;
	@FindBy(id = "contentForm:accordion:posSales_data")
	private WebElement posSalesTables;
	@FindBy(id = "contentForm:accordion:posSales:0:posBank")
	private WebElement banksDropdown;
	@FindBy(id = "contentForm:accordion:posSales:0:posBank_1")
	private WebElement banksDropdownFirstOption;
	

	public DailySalesView(WebDriver webDriver) throws InterruptedException {
		super(webDriver);
		PageFactory.initElements(webDriver, this); 
	}
	
	public double fillPistolTable(int contaLiterRow, int valueColumn, double quantity) throws InterruptedException {
		
		double sum = 0;
		double newContaLiter;
		tableRows = pistolTable.findElements(By.tagName("tr"));
		for(WebElement row : tableRows) {
			tableColumns = row.findElements(By.tagName("td"));
			newContaLiter = Double.parseDouble(tableColumns.get(contaLiterRow).getText()) + quantity;
			getActions().moveToElement(tableColumns.get(contaLiterRow + 1).findElement(By.tagName("input")))
						.click()
						.sendKeys(Double.toString(newContaLiter)).build().perform();
			Thread.sleep(1000);
			sum += Double.parseDouble(tableColumns.get(valueColumn).findElement(By.tagName("span")).getText());
		}
		return sum;
	}
	
	public double addBonusSales(int quantity, int valueColumn, double discountPrice) throws InterruptedException {
		
		getBonusSalesButton().click();
		Thread.sleep(1000);
		getProductsDropdown().click();
		productsDropDownFirstOption.click();
		Thread.sleep(1000);
		List<WebElement> columns = getBonusSalesTable().findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));
		Actions actions = new Actions(webDriver);
		Thread.sleep(1000);
		actions.moveToElement(columns.get(1)).click().sendKeys(Integer.toString(quantity)).build().perform();
		actions.moveToElement(columns.get(3)).click().sendKeys(Double.toString(discountPrice)).build().perform();
		Thread.sleep(1000);
		return Double.parseDouble(columns.get(5).findElement(By.tagName("span")).getText());

	}
	
	public void addDailySpending(double spending) throws InterruptedException {
		
		getDailySpendingButton().click();
		Thread.sleep(1000);
		List<WebElement> columns = getDailySpendingTable().findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));
		Actions actions = new Actions(webDriver);
		Thread.sleep(1000);
		actions.moveToElement(columns.get(1)).click().sendKeys(Double.toString(spending)).build().perform();
		actions.moveToElement(columns.get(2)).click().sendKeys("Peshkrmi i shpenzimit").build().perform();
	}
	
	public void addPosSale(double sale) throws InterruptedException {
		
		getPosSalesButton().click();
		Thread.sleep(1000);
		getBanksDropdown().click();
		Thread.sleep(1000);
		banksDropdownFirstOption.click();
		Thread.sleep(1000);
		List<WebElement> columns = getPosSalesTables().findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(columns.get(1)).click().sendKeys(Double.toString(sale)).build().perform();
	}
	
	public WebElement getPistolTable() {
		return returnNotStaleWebElement(pistolTable, By.id( "contentForm:accordion:pistolTable"), webDriver);
	}

	public WebElement getDate() {
		return returnNotStaleWebElement(date, By.id("contentForm:registrationDate_input"), webDriver);
	}

	public void setDate(String theDate) {
		getActions().moveToElement(getDate()).click().sendKeys(theDate).build().perform();
		dummyClick();
	}

    public WebElement getTotalSales() {
		return returnNotStaleWebElement(totalSales, By.id("contentForm:accordion:total_sales"), webDriver);
	}

	public WebElement getVoucherTable() {
		return  returnNotStaleWebElement(voucherTable, By.id("contentForm:accordion:voucherTable_data"), webDriver);
	}

	public WebElement getAutoFastTable() {
		return returnNotStaleWebElement(autoFastTable, By.id("contentForm:accordion:autoFastTable_data"), webDriver);
	}

	public WebElement getTestTable() {
		return returnNotStaleWebElement(testTable, By.id("contentForm:accordion:testTable_data"), webDriver);
	}

	public WebElement getMoneyTable() {
		return returnNotStaleWebElement(moneyTable, By.id("contentForm:accordion:inventoryTable_data"), webDriver);
	}

	public WebElement getCalculateCashSalesButton() {
		return returnNotStaleWebElement(calculateCashSalesButton, By.id("contentForm:accordion:calculateCashSalesBtn"), webDriver);
	}

	public WebElement getResetButton() {
		return returnNotStaleWebElement(resetButton, By.id("contentForm:resetBtn"), webDriver);
	}
	
	public WebElement getCalculateButton() {
		return returnNotStaleWebElement(calculateButton, By.id("contentForm:accordion:calculateBtn"), webDriver);
	}

	public WebElement getVoucherSales() {
		return returnNotStaleWebElement(voucherSales, By.id("contentForm:accordion:voucher_sales"), webDriver);
	}

	public WebElement getCashSales() {
		return returnNotStaleWebElement(cashSales, By.id("contentForm:accordion:cash_sales"), webDriver);
	}

	public WebElement getExpectedMoney() {
		return returnNotStaleWebElement(expectedMoney, By.id("contentForm:accordion:expected_money"), webDriver);
	}

	public WebElement getAutofastSales() {
		return returnNotStaleWebElement(autofastSales, By.id("contentForm:accordion:autofast_sales"), webDriver);
	}

	public WebElement getTestSales() {
		return returnNotStaleWebElement(testSales, By.id("contentForm:accordion:test_sales"), webDriver);
	}

	public WebElement getBonusSalesButton() {
		return returnNotStaleWebElement(bonusSalesButton, By.id("contentForm:accordion:bonus_sales_button"), webDriver);
	}
	
	public WebElement getVoucherButton() {
		return returnNotStaleWebElement(voucherButton, By.id("contentForm:accordion:openVoucherDialog"), webDriver);
	}

	public WebElement getBonusSalesTable() {
		return returnNotStaleWebElement(bonusSalesTable, By.id("contentForm:accordion:cardTable_data"), webDriver);
	}

	public WebElement getProductsDropdown() {
		return returnNotStaleWebElement(productsDropdown, By.id("contentForm:accordion:cardTable:0:products"), webDriver);
	}

	public WebElement getBonusSales() {
		return returnNotStaleWebElement(bonusSales, By.id("contentForm:accordion:bonus_sales"), webDriver);
	}

	public WebElement getDailySpendingButton() {
		return returnNotStaleWebElement(dailySpendingButton, By.id("contentForm:accordion:daily_spending_button"), webDriver);
	}

	public WebElement getDailySpendingTable() {
		return returnNotStaleWebElement(dailySpendingTable, By.id("contentForm:accordion:dailySpendings_data"), webDriver);
	}

	public WebElement getDailySpendings() {
		return returnNotStaleWebElement(dailySpendings, By.id("contentForm:accordion:daily_spendings"), webDriver);
	}

	public WebElement getPosSalesButton() {
		return returnNotStaleWebElement(posSalesButton, By.id("contentForm:accordion:pos_sales"), webDriver);
	}

	public WebElement getBanksDropdown() {
		return returnNotStaleWebElement(banksDropdown, By.id("contentForm:accordion:posSales:0:posBank_items"), webDriver);
	}

	public WebElement getPosSales() {
		return returnNotStaleWebElement(posSales, By.id("contentForm:accordion:poss_sales"), webDriver);
	}

	public WebElement getPosSalesTables() {
		return returnNotStaleWebElement(posSalesTables, By.id("contentForm:accordion:posSales_data"), webDriver);
	}

	public WebElement getRegisterButton() {
		return returnNotStaleWebElement(registerButton, By.id("contentForm:addBtn"), webDriver);
	}
	
	public WebElement getGrowl() {
//		WebDriverWait wait = new WebDriverWait(webDriver, 5);
//		return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-growl-message")));
		return returnNotStaleWebElement(growl, By.className("ui-growl-message"), webDriver);
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)							
//				.withTimeout(30, TimeUnit.SECONDS) 			
//				.pollingEvery(5, TimeUnit.SECONDS) 			
//				.ignoring(StaleElementReferenceException.class);
//		
//		return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-growl-message")));
	}
	
	
	
	public void dummyClick() {
		getActions().moveToElement(webDriver.findElement(By.id("page-top"))).click().perform();
	}
	
	private Actions getActions() {
		return new Actions(webDriver);
	}

	public WebElement getConfirmedTotalSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:pistols"));
	}
	
	public WebElement getConfirmedVoucherSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:vouchersData"));
	}
	
	public WebElement getConfirmedTestSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:testData"));
	}
	
	public WebElement getConfirmedCashSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:cashData"));
	}
	
	public WebElement getConfirmedBonusSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:bonusData"));
	}
	
	public WebElement getConfirmedAutofastSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:autofastData"));
	}
	
	public WebElement getConfirmedDailySpending() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:dailySpendingsData"));
	}
	
	public WebElement getConfirmedPosSales() {
		return getSpanFromTableFooter(webDriver, By.id("contentForm:posSalesData"));
	}
	
}
