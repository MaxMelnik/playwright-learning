package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator.PressSequentiallyOptions;

public class HandlingTabsAndPopups {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");
	
		
		Page popup = page.waitForPopup(() -> {
			page.locator("text=Privacy Policy").nth(0).click();
		});
		
		popup.locator("//*[@id=\"header-sign-up-btn\"]").click();
		Thread.sleep(2000);
		popup.locator("#user_name")
			.pressSequentially(
					"Maks Melnyk", 
					new PressSequentiallyOptions()
					.setDelay(100));
	}

}
