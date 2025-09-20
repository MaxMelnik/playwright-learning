package testcases;

import com.microsoft.playwright.*;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Started [");
        //try (Playwright playwright = Playwright.create()) {
		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://playwright.dev");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
        //}
		System.out.println("] Ended");
	}
}
