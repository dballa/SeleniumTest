package selenium.page.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.page.BaseView;
import selenium.page.utils.PageUtils;
import static selenium.tests.utils.Constants.*;
import static selenium.utils.StaleUtils.returnNotStaleWebElement;

public class DashboardView extends BaseView {

	PageUtils pageUtil;
	@FindBy(id = "contentForm:selectSalePoint")
	private WebElement selectSalePoint;
	@FindBy(id = "contentForm:selectSalePoint_1")
	private WebElement firstSalePoint;
	@FindBy(xpath = "//*[@id=\"contentForm:totalDeposit_data\"]/tr[1]/td[2]/span")
	private WebElement currentQuantityOfFirstProduct;
	@FindBy(xpath = "//*[@id=\"contentForm:averageTable_data\"]/tr[1]/td[2]/span")
	private WebElement avarageSale;
	@FindBy(xpath = "//*[@id=\"contentForm:predictions_data\"]/tr[1]/td[2]/span")
	private WebElement daysBeforeSupply;
	@FindBy(id = "settings")
	private WebElement settingsButton;
	@FindBy(id = "form:logout")
	private WebElement logoutButton;
	@FindBy(id = "englishLanguageButton")
	private WebElement englishButton;
	@FindBy(id = "contentForm:salePoint")
	private WebElement textToDetectLanguage;
	@FindBy(id = "albanianLanguageButton")
	private WebElement albanianButton;
	@FindBy(id="profileButton")
	private WebElement profileButton;

	private boolean daysCalculation;
	private boolean logedOut;
	private boolean systemInEnglish;
	private boolean systemInAlbanian;
	private boolean onProfileView;

	public DashboardView(WebDriver webDriver) {
		super(webDriver);
		pageUtil = new PageUtils();
	}

	public void checkDaysBeforeSupply() throws InterruptedException {
		selectSalePoint.click();
		firstSalePoint.click();
		// TODO to be changed later
		Thread.sleep(3000);

		double quantity = Double.parseDouble(pageUtil.removeComma(currentQuantityOfFirstProduct.getText()));
		double avarageOfSales = Double.parseDouble(pageUtil.removeComma(avarageSale.getText()));
		int daysNumber = Integer.parseInt(daysBeforeSupply.getText());
		int daysNumerFromView = (int) (quantity / avarageOfSales);
		if (daysNumber == daysNumerFromView) {
			daysCalculation = true;
		} else
			daysCalculation = false;
	}
	


	public void englishLanguage() throws InterruptedException {
		settingsButton.click();
		englishButton.click();
		// TODO to be changed later
		Thread.sleep(2000);
		systemInEnglish =getTextToDetectLanguage().getText().equals(ENGLISH_TEXT);
	}

	public void albanianLanguage() throws InterruptedException {
		settingsButton.click();
		albanianButton.click();
		// TODO to be changed later
		Thread.sleep(2000);
		System.out.println(getTextToDetectLanguage().getText());
		systemInAlbanian=getTextToDetectLanguage().getText().equals(ALBANIAN_TEXT);
	}
	public void redirectToProfile() {
		settingsButton.click();
		profileButton.click();
		onProfileView=webDriver.getCurrentUrl().contains(USER_PROFILE);
	}

	public void logout() {
		settingsButton.click();
		logoutButton.click();
		logedOut = webDriver.getCurrentUrl().contains(LOGIN);
	}

	public boolean isDaysCalculation() {
		return daysCalculation;
	}

	public void setDaysCalculation(boolean daysCalculation) {
		this.daysCalculation = daysCalculation;
	}

	public boolean isLogedOut() {
		return logedOut;
	}

	public void setLogedOut(boolean logedOut) {
		this.logedOut = logedOut;
	}

	public boolean isSystemInEnglish() {
		return systemInEnglish;
	}

	public void setSystemInEnglish(boolean systemInEnglish) {
		this.systemInEnglish = systemInEnglish;
	}

	public boolean isSystemInAlbanian() {
		return systemInAlbanian;
	}

	public void setSystemInAlbanian(boolean systemInAlbanian) {
		this.systemInAlbanian = systemInAlbanian;
	}

	public boolean isOnProfileView() {
		return onProfileView;
	}

	public void setOnProfileView(boolean onProfileView) {
		this.onProfileView = onProfileView;
	}

	public WebElement getTextToDetectLanguage() {
		return returnNotStaleWebElement(textToDetectLanguage,By.id("salePointStatus"),webDriver);
	}

}
