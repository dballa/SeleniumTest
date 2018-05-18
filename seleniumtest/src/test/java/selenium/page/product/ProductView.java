package selenium.page.product;

import static selenium.tests.utils.Constants.*;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.page.BaseView;
import selenium.page.components.NavigationComponents;

public class ProductView extends BaseView {

	private NavigationComponents navigationComponents;

	@FindBy(id = "contentForm:addButton")
	private WebElement addProductButton;

	@FindBy(id = "contentForm:newpwd")
	private WebElement productName;

	@FindBy(id = "contentForm:desc")
	private WebElement productDescription;

	@FindBy(id = "contentForm:openDialog")
	private WebElement openAddProductDialog;

	@FindBy(id = "contentForm:productTable_data")
	private WebElement dataTable;

	@FindBy(xpath = "//*[@id=\"contentForm:productTable_data\"]/tr[1]/td[1]")
	private WebElement addedRowOnTable;

	@FindBy(xpath = "//*[@id=\"contentForm:productTable_data\"]/tr[1]/td[1]")
	private WebElement cellToEdit;

	@FindBy(xpath = "//*[@id=\"contentForm:productTable_data\"]/tr[1]/td[1]")
	private WebElement cellAfterEdit;

	@FindBy(id = "contentForm:productTable:0:disableProduct")
	private WebElement disableToggle;

	@FindBy(id = "contentForm:productTable:0:enableProduct")
	private WebElement enableToggle;

	@FindBy(id = "contentForm")
	private WebElement contentForm;

	@FindBy(id = "contentForm:disableProduct")
	private WebElement confirmDisableButton;

	private boolean addedCorrectProduct;
	private boolean editCorrectProduct;
	private boolean toggleDisabled;

	public ProductView(WebDriver webDriver) {
		super(webDriver);
		navigationComponents = new NavigationComponents(webDriver);

	}

	public void addProduct() throws InterruptedException {
		int randomInt = new Random().nextInt(5000);

		openAddProductDialog.click();
		String generatedName = PRODUCT_NAME + randomInt;
		productName.sendKeys(generatedName);
		productDescription.sendKeys(PRODUCT_DESCRIPTION);
		addProductButton.click();
		// TODO to be changed later
		Thread.sleep(1000);
		String nameOfProductAdded = addedRowOnTable.getText();

		addedCorrectProduct = generatedName.equals(nameOfProductAdded);
	}

	public void editProduct() throws InterruptedException {
		int randomInt = new Random().nextInt(5000);

		Actions actions = new Actions(webDriver);
		actions.moveToElement(cellToEdit);
		actions.click();
		String textToAdd = PRODUCT_NAME + randomInt;
		actions.sendKeys(textToAdd);
		actions.build().perform();

		contentForm.click();
		// TODO to be changed later
		Thread.sleep(500);

		editCorrectProduct = cellAfterEdit.getText().equals(textToAdd);
	}

	/*
	 * to be executed after add method
	 */
	public void disableProduct() throws InterruptedException {
	
		disableToggle.click();
		// TODO to be changed later
		Thread.sleep(500);
		confirmDisableButton.click();
		// TODO to be changed later
		Thread.sleep(500);
		
		toggleDisabled = isPresentById("contentForm:productTable:0:enableProduct");

	}


	public boolean isAddedCorrectProduct() {
		return addedCorrectProduct;
	}

	public void setAddedCorrectProduct(boolean addedCorrectProduct) {
		this.addedCorrectProduct = addedCorrectProduct;
	}

	public boolean isEditCorrectProduct() {
		return editCorrectProduct;
	}

	public void setEditCorrectProduct(boolean editCorrectProduct) {
		this.editCorrectProduct = editCorrectProduct;
	}

	public boolean isToggleDisabled() {
		return toggleDisabled;
	}

	public void setToggleDisabled(boolean toggleDisabled) {
		this.toggleDisabled = toggleDisabled;
	}

	public NavigationComponents getNavigationComponents() {
		return navigationComponents;
	}

	public void setNavigationComponents(NavigationComponents navigationComponents) {
		this.navigationComponents = navigationComponents;
	}

}
