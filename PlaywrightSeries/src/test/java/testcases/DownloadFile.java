package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://www.selenium.dev/downloads/");
		
		Download file = page.waitForDownload(() -> {
			page.locator("//html/body/div/main/div[3]/div[3]/div/div[2]/p[2]/a").click();
		});
		
		file.saveAs(Paths.get("./src/test/resources/files/selenium.jar"));
	}
}
