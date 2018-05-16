package selenium.page.product;

import static selenium.tests.utils.Constants.*;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium.page.AbstractView;

public class ProductView extends AbstractView {

	private WebElement addProductButton;
	private WebElement productName;
	private WebElement productDescription;
	private WebElement openAddProductDialog;
	private WebElement dataTable;
	private WebElement addedRowOnTable;
	private WebElement cellToEdit;
	private WebElement cellAfterEdit;
	private WebElement disableToggle;
	private WebElement enableToggle;

	private By openAddProductDialogLocator = By.id("contentForm:openDialog");
	private By productNameLocator = By.id("contentForm:newpwd");
	private By productDescriptionLocator = By.id("contentForm:desc");
	private By addProductButtonLocator = By.id("contentForm:add");
	private By dataTableLocator = By.id("contentForm:productTable_data");
	private By addedRowOnTableLocator = By.xpath("//*[@id=\"contentForm:productTable_data\"]/tr[1]/td[1]");
	private By cellToEditLocator = By.xpath("//*[@id=\"contentForm:productTable_data\"]/tr[1]/td[1]");
	private By cellAfterEditLocator = By.xpath("//*[@id=\"contentForm:productTable_data\"]/tr[1]/td[1]");
	private By disableToggleLocator = By.id("contentForm:productTable:0:disableProduct");
	private By enableToggleLocator = By.id("contentForm:productTable:0:enableProduct");

	private boolean addedCorrectProduct;
	private boolean editCorrectProduct;
	private boolean toggleDisabled;

	public ProductView(WebDriver webDriver) {
		super(webDriver);

	}

	public void addProduct() throws InterruptedException {
		int i = new Random().nextInt(5000) + 5;
		openAddProductDialog = webDriver.findElement(openAddProductDialogLocator);
		openAddProductDialog.click();
		Thread.sleep(500);
		productName = webDriver.findElement(productNameLocator);
		String nameToSend = PRODUCT_NAME + i;
		productName.sendKeys(nameToSend);
		productDescription = webDriver.findElement(productDescriptionLocator);
		productDescription.sendKeys(PRODUCT_DESCRIPTION);
		addProductButton = webDriver.findElement(addProductButtonLocator);
		addProductButton.click();
		Thread.sleep(2000);
		dataTable = webDriver.findElement(dataTableLocator);
		addedRowOnTable = dataTable.findElement(addedRowOnTableLocator);
		String nameOfProductAdded = addedRowOnTable.getText();
		addedCorrectProduct = nameToSend.equals(nameOfProductAdded);
	}

	public void editProduct() throws InterruptedException {
		int i = new Random().nextInt(5000) + 5;
		cellToEdit = webDriver.findElement(cellToEditLocator);
		Actions actions = new Actions(webDriver);
		actions.moveToElement(cellToEdit);
		actions.click();
		String textToAdd = PRODUCT_NAME + i;
		actions.sendKeys(textToAdd);
		actions.build().perform();
		webDriver.findElement(By.id("contentForm")).click();
		Thread.sleep(500);
		cellAfterEdit = webDriver.findElement(cellAfterEditLocator);
		editCorrectProduct = cellAfterEdit.getText().equals(textToAdd);
	}

	public void disableProduct() throws InterruptedException {
		disableToggle = webDriver.findElement(disableToggleLocator);
		if (disableToggle.isEnabled()) {
			disableToggle.click();
			Thread.sleep(1000);
			webDriver.findElement(By.id("contentForm:disableProduct")).click();

		}
		Thread.sleep(2000);
		enableToggle=webDriver.findElement(enableToggleLocator);
		toggleDisabled=enableToggle.isEnabled();

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

}
