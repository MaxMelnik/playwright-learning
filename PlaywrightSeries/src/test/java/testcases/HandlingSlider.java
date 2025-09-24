package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingSlider {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
	
		Locator slider = page.locator("//*[@id=\"slider\"]/span");
		Thread.sleep(2000);
		
		Double x = slider.boundingBox().x + slider.boundingBox().width/2;
		Double y = slider.boundingBox().y + slider.boundingBox().height/2;
		page.mouse().move(x, y);
		page.mouse().down();
		page.mouse().move(x + 400, y);
		page.mouse().up();
	}

}
