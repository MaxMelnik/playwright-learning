package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.*;

public class MaximizingWindow {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		
		Page page = context.newPage();
		
		page.navigate("https://www.way2automation.com");
		System.out.println(page.title());
	}

}
