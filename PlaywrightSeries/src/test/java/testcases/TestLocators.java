package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.PressSequentiallyOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class TestLocators {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://gmail.com");

		//page.locator("[id=\"identifierId\"]")
		page.locator("#identifierId")
		.pressSequentially(
				"trainer@way2automation.com", 
				new PressSequentiallyOptions()
				.setDelay(100));
		//page.type("#identifierId", ".type", new TypeOptions().setDelay(100));

		//page.click("text=Далі");
		page.click("button:has-text('Далі')");
		page.locator("[type=password]")
		.fill("1234");
		page.click("button:has-text('Далі')");
		System.out.println(page.locator("//*[@id=\"selectionc1\"]").innerText());
		
	}

}
