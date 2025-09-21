package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.*;

public class NonIncognitoWindowTest {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		String defaultProfilePath = "C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
		// String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		BrowserContext browserContext = playwright.chromium()
				.launchPersistentContext(
						Paths.get(defaultProfilePath), 
						new BrowserType.LaunchPersistentContextOptions()
							.setChannel("chrome")
							.setHeadless(false));
 
		Page page = browserContext.newPage();
		
		page.navigate("https://www.way2automation.com");
		System.out.println(page.title());
		page.navigate("https://google.com");
		System.out.println(page.title());
		Thread.sleep(1000);
		page.goBack(new GoBackOptions().setTimeout(500));
		Thread.sleep(1000);
		page.goForward(new GoForwardOptions().setTimeout(500));
		Thread.sleep(1000);
		page.reload();
	}

}
