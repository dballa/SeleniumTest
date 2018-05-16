package selenium.page;

import org.openqa.selenium.WebDriver;

public class AbstractView {

	protected WebDriver webDriver;

	public AbstractView(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}
}
