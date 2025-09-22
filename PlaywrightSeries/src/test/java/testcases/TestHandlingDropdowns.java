package testcases;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class TestHandlingDropdowns {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("https://www.wikipedia.org");

		// select by value
		page.selectOption("select", "sv");
		
		//select by text
		page.selectOption("select", new SelectOption().setLabel("Eesti"));

		//select by index
		page.selectOption("select", new SelectOption().setIndex(1));
		
		
		/*Locator values = page.locator("select > option");
		System.out.println(values.count());
		
		
		for (int i=0; i<values.count(); i++) {
			String text = values.nth(i).innerText();
			String lang = values.nth(i).getAttribute("lang");
			System.out.println(i + ". " + text + ": " + lang);
		}*/
		
		List <ElementHandle> values = page.querySelectorAll("select > option");
		
		System.out.println(values.size());
		
		for (ElementHandle value: values) {
			String text = value.innerText();
			String lang = value.getAttribute("lang");
			System.out.println(text + ": " + lang);
		}
		
		page.close();
		playwright.close();
	}

}
