package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.PressSequentiallyOptions;

public class HandlingShadowDOM {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
	
		page.locator("#input")
			.pressSequentially(
					"java", 
					new PressSequentiallyOptions()
					.setDelay(100));
		
		Thread.sleep(2000);
		
		page.navigate("chrome://downloads/");
		
		page.locator("#searchInput")
			.pressSequentially(
					"java", 
					new PressSequentiallyOptions()
					.setDelay(100));
	}

}
