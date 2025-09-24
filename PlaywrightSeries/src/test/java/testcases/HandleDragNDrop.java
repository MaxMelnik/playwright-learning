package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleDragNDrop {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
	
		Locator draggable = page.locator("#draggable");
		Locator droppable = page.locator("#droppable");
		Thread.sleep(2000);
		
		Double x1 = draggable.boundingBox().x + draggable.boundingBox().width/2;
		Double y1 = draggable.boundingBox().y + draggable.boundingBox().height/2;
		Double x2 = droppable.boundingBox().x + droppable.boundingBox().width/2;
		Double y2 = droppable.boundingBox().y + droppable.boundingBox().height/2;
		page.mouse().move(x1, y1);
		page.mouse().down();
		page.mouse().move(x2, y2);
		page.mouse().up();
	}

}
