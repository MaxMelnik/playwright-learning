package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestHandleLink {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://www.wikipedia.org");
		
		Locator links = page.locator("a");

		System.out.println(links.count());
		
		for (int i=0; i<links.count(); i++) {
			String text = links.nth(i).innerText();
			String url = links.nth(i).getAttribute("href");
			System.out.println(i + ". " + text + ": " + url);
		}
		
		Locator block = page.locator("//*[@id=\"www-wikipedia-org\"]/footer/nav");
		Locator blockLinks = block.locator("a");
		
		System.out.println("----Links from the block----");
		
		System.out.println(blockLinks.count());
		
		for (int i=0; i<blockLinks.count(); i++) {
			String text = blockLinks.nth(i).innerText();
			String url = blockLinks.nth(i).getAttribute("href");
			System.out.println(i + ". " + text + ": " + url);
		}
		
		blockLinks.nth(2).click();
	}

}
