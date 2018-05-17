package selenium.page.components;

import org.openqa.selenium.WebDriver;

public class NavigationComponents {

	private LeftMenu leftMenu;
	private Header header;

	public NavigationComponents(WebDriver webDriver) {
		super();
		leftMenu = new LeftMenu(webDriver);
		header = new Header(webDriver);
	}

	public LeftMenu getLeftMenu() {
		return leftMenu;
	}

	public void setLeftMenu(LeftMenu leftMenu) {
		this.leftMenu = leftMenu;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

}
