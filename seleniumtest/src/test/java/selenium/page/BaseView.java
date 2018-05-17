package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BaseView {

	protected WebDriver webDriver;

	public BaseView(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
		
		AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(webDriver, 10);

		PageFactory.initElements(ajaxElementLocatorFactory, this);
	}
	
	/*
	 * Not so fast , perdore kur nuk ke zgjidhje tjeter .
	 * Kontrollon te tere DOM per kete id dhe kthen nje array .
	 */
	protected boolean isPresentById(String id) {
		
		return webDriver.findElements(By.id(id)).size() != 0;
	}
}
