package selenium.tests.dailysales;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.*;

import static selenium.page.Util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import selenium.page.dailysales.DailySalesView;
import selenium.page.login.LoginView;
import selenium.page.pos.PointOfSalesView;
import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DailySalesTest {
	
	public static WebDriver webDriver;
	
	public static boolean result;
	
	public static DailySalesView dailySalesView;
	
	public static PointOfSalesView pointOfSalesView;
	
	@BeforeClass
	public static void init() throws InterruptedException {
		webDriver = DriverUtil.getChromeDriver();
		
		LoginView loginView = new LoginView(webDriver);
		loginView.login(USR, PASSWORD);
		Thread.sleep(2000);
		pointOfSalesView = new PointOfSalesView(webDriver);
		dailySalesView = pointOfSalesView.getFirstPointOfSale();
	}
	
	@Test
	public void test10_InsertDate() throws InterruptedException {
		
		dailySalesView.setDate("06-11-2018");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_DATE_MESSAGE_AL, INVALID_DATE_MESSAGE_EN);
		assertTrue("The date is invalid", result);
		refresh(webDriver);
		
		dailySalesView.setDate("20-05-2018");
		dailySalesView.getRegisterButton().click();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_REGISTRATION_DATE_AL, INVALID_REGISTRATION_DATE_EN);
		assertTrue("The date is invalid", result);
		
		dailySalesView.setDate("23-05-2018");
		Thread.sleep(1000);
	}
	
	@Test
	public void test11_FillPistolTable() throws InterruptedException {
		
		fillCell(webDriver, dailySalesView.getPistolTable(), 0, 3, "@");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getPistolTable(), 0, 3, "-1");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), NEGATIVE_INPUT_AL, NEGATIVE_INPUT_EN);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getPistolTable(), 0, 3, "1");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_CONTALITER_NUMBER_AL, INVALID_CONTALITER_NUMBER_EN);
		assertTrue("Invalid contaliter number", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getPistolTable(), 0, 3, "");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
	}
	
	@Test
	public void test12_FillVoucherTable() throws InterruptedException {
		
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getVoucherTable(), 0, 1, "@");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);

		fillCell(webDriver, dailySalesView.getVoucherTable(), 0, 1, "-1");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Negative number inserted", result);
		
		fillCell(webDriver, dailySalesView.getVoucherTable(), 0, 1, "1000000000");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Large number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getVoucherTable(), 0, 1, "");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
	}
	
	@Test
	public void test13_FillBonusSales() throws InterruptedException {
		
		Thread.sleep(1000);
		
		scrollToElement(webDriver, dailySalesView.getVoucherButton());
		Thread.sleep(1000);
		dailySalesView.addBonusSales(1, 0, 1.0);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 1, "@");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 1, "-1");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 1, "1000000000");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Large number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 1, "");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 1, "0");
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 3, "@");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 3, "0");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), DISCOUNT_LIMIT_AL, DISCOUNT_LIMIT_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getBonusSalesTable(), 0, 3, "");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
	}
	
	@Test
	public void test14_FillAtuofastTable() throws InterruptedException {
		
		fillCell(webDriver, dailySalesView.getAutoFastTable(), 0, 1, "@");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getAutoFastTable(), 0, 1, "-1");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_AL);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getAutoFastTable(), 0, 1, "1000000000");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Large number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getAutoFastTable(), 0, 1, "");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		
		refresh(webDriver);
	}
	
	@Test
	public void test15_FillTestTable() throws InterruptedException {
		
		fillCell(webDriver, dailySalesView.getTestTable(), 0, 1, "@");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getTestTable(), 0, 1, "-1");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getTestTable(), 0, 1, "1000000000");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Large number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getTestTable(), 0, 1, "");
		dailySalesView.dummyClick();
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
	}
	
	
	@Test
	public void test16_FillDailySpending() throws InterruptedException {
		
		scrollToElement(webDriver, dailySalesView.getCalculateCashSalesButton());
		Thread.sleep(1000);
		dailySalesView.addDailySpending(0.0);
		Thread.sleep(1000);
		
		
		fillCell(webDriver, dailySalesView.getDailySpendingTable(), 0, 1, "@");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getDailySpendingTable(), 0, 1, "-1");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getDailySpendingTable(), 0, 1, "1000000000");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Large number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getDailySpendingTable(), 0, 1, "");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
		
	}
	
	@Test
	public void test17_FillPosSales() throws InterruptedException {
		
		Thread.sleep(1000);
		
		scrollToElement(webDriver, dailySalesView.getCalculateCashSalesButton());
		Thread.sleep(1000);
		dailySalesView.addPosSale(0.0);
		Thread.sleep(1000);
		
		
		fillCell(webDriver, dailySalesView.getPosSalesTables(), 0, 1, "@");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getPosSalesTables(), 0, 1, "-1");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getPosSalesTables(), 0, 1, "1000000000");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_EN);
		assertTrue("Large number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getPosSalesTables(), 0, 1, "");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
//		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
		
	}
	

	@Test
	public void test18_FillMoneyTable() throws InterruptedException {
		
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getMoneyTable(), 0, 0, "@");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), INVALID_NUMBER_AL, INVALID_NUMBER_EN);
		assertTrue("Invalid number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getMoneyTable(), 0, 0, "-1");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), LIMIT_NUMBER_MESSAGE_AL, LIMIT_NUMBER_MESSAGE_AL);
		assertTrue("Negative number inserted", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getMoneyTable(), 0, 0, "");
		Thread.sleep(1000);
		result = compareInnerText(dailySalesView.getGrowl(), EMPTY_FIELD_AL, EMPTY_FIELD_EN);
		assertTrue("The field is empty", result);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getMoneyTable(), 0, 0, "0");
	}
	
	@Test
	public void test19_CheckAmounts() throws InterruptedException {
		
		Thread.sleep(2000);
		
		dailySalesView.dummyClick();
		dailySalesView.fillPistolTable(2, 6, 1.0);
		Thread.sleep(1000);
		
		fillCell(webDriver, dailySalesView.getVoucherTable(), 0, 1, "2");
		Thread.sleep(1000);
		
		dailySalesView.addBonusSales(1, 5, 1.0);
		Thread.sleep(1000);
		
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		
		result = compareInnerText(dailySalesView.getGrowl(), AMOUNTS_ERROR_AL, AMOUNTS_ERROR_EN);
		assertTrue("Amount of sold liters doesn't match with countaliters declared value", result);
		Thread.sleep(1000);
		
		refresh(webDriver);
	}
	
	
	@Test
	public void test20_FillPistolTable() throws InterruptedException {
		
		dailySalesView.dummyClick();
		double totalSales = dailySalesView.fillPistolTable(2, 6, 3.0);
		Thread.sleep(1000);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedTotalSales = extractDouble(dailySalesView.getTotalSales());
		assertEquals("Total sales amounts doesn't match", totalSales, confirmedTotalSales, 0.01);
	}

	@Test
	public void test21_FillVocuherTable() throws InterruptedException {
		
		double voucherSales = fillTable(webDriver, dailySalesView.getVoucherTable(), 1, 3, 1.0);
		Thread.sleep(1000);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedVoucherSales = extractDouble(dailySalesView.getVoucherSales());
		assertEquals("Voucher sales amounts doesn't match", voucherSales, confirmedVoucherSales, 0.01);
	}
	
	@Test
	public void test22_FillAutofastTable() throws InterruptedException {
		
		double autofastSales = fillTable(webDriver, dailySalesView.getAutoFastTable(), 1, 3, 1.0);
		Thread.sleep(1000);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedAutofastSales = extractDouble(dailySalesView.getAutofastSales());
		assertEquals("Autofast sales amounts doesn't match", autofastSales,confirmedAutofastSales, 0.01);	
	}
	
	@Test
	public void test23_FillTestTable() throws InterruptedException {
		
		double testSales = fillTable(webDriver, dailySalesView.getTestTable(), 1, 3, 1.0);
		Thread.sleep(1000);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedTestSales = extractDouble(dailySalesView.getTestSales());
		assertEquals("Test sales amounts doesn't match", testSales, confirmedTestSales, 0.01);
	}
	
	@Test
	public void test24_CreateBonusSale() throws InterruptedException {
		
		scrollToElement(webDriver, dailySalesView.getVoucherButton());
		Thread.sleep(1000);
		double bonusSales = dailySalesView.addBonusSales(1, 5, 5.0);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedBonusSales = extractDouble(dailySalesView.getBonusSales());
		assertEquals("Bonus sales amounts doesn't match", bonusSales, confirmedBonusSales, 0.01);
	}
	
	@Test
	public void test25_CreateDailySpening() throws InterruptedException {
		
		scrollToElement(webDriver, dailySalesView.getCalculateCashSalesButton());
		Thread.sleep(1000);
		dailySalesView.addDailySpending(500.0);
		Thread.sleep(1000);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedDailySpendings = extractDouble(dailySalesView.getDailySpendings());
		assertEquals("Daily spending amounts doesn't match", 500.0, confirmedDailySpendings, 0.01);
		
	}
	
	@Test
	public void test26_CreatePosSale() throws InterruptedException {
		
		scrollToElement(webDriver, dailySalesView.getCalculateCashSalesButton());
		Thread.sleep(1000);
		dailySalesView.addPosSale(500.0);
		Thread.sleep(1000);
		dailySalesView.getCalculateButton().click();
		Thread.sleep(1000);
		double confirmedPosSales = extractDouble(dailySalesView.getPosSales());
		assertEquals("Pos sales amounts doesn't match", 500.0, confirmedPosSales, 0.01);
	}
	
	@Test
	public void test27_ConclusionsTest() throws InterruptedException {
		
		double totalSales = extractDouble(dailySalesView.getTotalSales());
		double voucherSales = extractDouble(dailySalesView.getVoucherSales());
		double autofastSales = extractDouble(dailySalesView.getAutofastSales());
		double bonusSales = extractDouble(dailySalesView.getBonusSales());
		double testSales = extractDouble(dailySalesView.getTestSales());
		double cashSales = extractDouble(dailySalesView.getCashSales());
		double spendings = extractDouble(dailySalesView.getDailySpendings());
		double posSales = extractDouble(dailySalesView.getPosSales());
		double expectedMoney = extractDouble(dailySalesView.getExpectedMoney());
		
//		double expectedCashSales = totalSales - (voucherSales + autofastSales - testSales - 5*1);
//		assertEquals("Invalid cash sales calculation", cashSales, expectedCashSales, 0.01);
		
		
		assertEquals("Invalid exprected money calculation", expectedMoney, cashSales - posSales - spendings, 0.01);
		
		dailySalesView.getRegisterButton().click();
		Thread.sleep(1000);
		
		
		
		assertEquals("Total sales confirmation error", totalSales, extractDouble(dailySalesView.getConfirmedTotalSales()), 0.01);
		assertEquals("Voucher sales confirmation error", voucherSales, extractDouble(dailySalesView.getConfirmedVoucherSales()), 0.01);
		assertEquals("Autofast sales confirmation error", autofastSales, extractDouble(dailySalesView.getConfirmedAutofastSales()), 0.01);
		assertEquals("Bonus sales confirmation error", bonusSales, extractDouble(dailySalesView.getConfirmedBonusSales()), 0.01);
		assertEquals("Test sales confirmation error", testSales, extractDouble(dailySalesView.getConfirmedTestSales()), 0.01);
		assertEquals("Cash sales confirmation error", cashSales, extractDouble(dailySalesView.getConfirmedCashSales()), 0.01);
		assertEquals("Spendings sales confirmation error", spendings, extractDouble(dailySalesView.getConfirmedDailySpending()), 0.01);
		assertEquals("Pos sales confirmation error", posSales, extractDouble(dailySalesView.getPosSales()), 0.01);
		
		
	}
	
	
//	@AfterClass
//	public static void close() {
//		
//		webDriver.quit();
//	}
	
}
