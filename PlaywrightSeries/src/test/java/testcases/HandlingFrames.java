package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class HandlingFrames {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		page.frameLocator("#iframeResult")
			.locator("body > button")
			.click(new ClickOptions().setTimeout(2000));
		
		page.frameLocator("#iframeResult")
			.locator("body > button")
			.screenshot(
					new Locator.ScreenshotOptions()
						.setPath(Paths.get("./screenshots/button.png")));

		page.screenshot(
				new Page.ScreenshotOptions()
					.setPath(Paths.get("./screenshots/page.png")));
		/*
		Locator frames = page.locator("iframe");

		System.out.println(frames.count());
		
		for (int i=0; i<frames.count(); i++) {
			System.out.println(frames.nth(i).getAttribute("id"));
		}
		*/
	}

}
