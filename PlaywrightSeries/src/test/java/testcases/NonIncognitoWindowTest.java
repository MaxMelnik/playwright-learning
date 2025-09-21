package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class NonIncognitoWindowTest {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		String defaultProfilePath = "C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		BrowserContext browserContext = playwright.chromium()
				.launchPersistentContext(
						Paths.get(defaultProfilePath), 
						new BrowserType.LaunchPersistentContextOptions()
							.setHeadless(false)
							.setExecutablePath(Paths.get(chromePath)));
 
		Page page = browserContext.newPage();
		
		page.navigate("https://www.way2automation.com");
		System.out.println(page.title());
	}

}
