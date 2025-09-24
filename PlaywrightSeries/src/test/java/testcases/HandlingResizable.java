package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingResizable {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");
	
		Locator resizable = page.locator("//*[@id=\"resizable\"]/div[3]");
		Thread.sleep(2000);
		
		Double x = resizable.boundingBox().x + resizable.boundingBox().width/2;
		Double y = resizable.boundingBox().y + resizable.boundingBox().height/2;
		page.mouse().move(x, y);
		page.mouse().down();
		page.mouse().move(x + 400, y + 200);
		page.mouse().up();
	}

}
