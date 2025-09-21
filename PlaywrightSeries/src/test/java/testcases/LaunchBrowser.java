package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Started [");
        //try (Playwright playwright = Playwright.create()) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		System.out.println(width+":"+height);
		
		Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
        Page page = browserContext.newPage();
        page.navigate("https://playwright.dev");
        System.out.println(page.title());
        Thread.sleep(2000);
//        page.close();
//        playwright.close();
        //}
		System.out.println("] Ended");
	}
}
