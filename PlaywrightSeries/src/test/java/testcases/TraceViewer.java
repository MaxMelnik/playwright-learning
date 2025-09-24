package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator.PressSequentiallyOptions;

public class TraceViewer {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		BrowserContext context = browser.newContext();

		// Start tracing before creating / navigating a page.
		context.tracing().start(new Tracing.StartOptions()
		  .setScreenshots(true)
		  .setSnapshots(true)
		  .setSources(false));
		
		Page page = context.newPage();
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
		// System.out.println(page.locator("//*[@id=\"selectionc1\"]").innerText());
		
		// Stop tracing and export it into a zip archive.
		context.tracing().stop(new Tracing.StopOptions()
		  .setPath(Paths.get("trace.zip")));
		
		page.close();
		context.close();
		playwright.close();
	}

}
