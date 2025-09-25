package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestAssertions {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(
						new BrowserType
							.LaunchOptions()
							.setHeadless(false));
 
		Page page = browser.newPage();
		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		assertThat(page).hasURL("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		assertThat(page).hasTitle("HTML Tutorial - Checkboxes");
		assertThat(page.locator("#menu > a:nth-child(29)")).hasText("HTML - Tags");

		Locator checkbox = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[1]");
		//Locator checkbox2 = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[2]");

		assertThat(checkbox).isVisible();
		assertThat(checkbox).isChecked();
		//assertThat(checkbox2).isVisible();
		//assertThat(checkbox2).isChecked();
		
		page.close();
		browser.close();
		playwright.close();
	}

}
