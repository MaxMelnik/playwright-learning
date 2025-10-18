package parameterization;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@Test(dataProvider = "dp1")
	public void doLogin(String username, String password) {
		System.out.println(username + "---" + password);
	}

	@DataProvider(name = "dp1")
	public Object[][] getData(Method m) {

		Object[][] data = null;

		if (m.getName().equals("testLogin")) {

			data = new Object[2][2];

			data[0][0] = "trainer@way2automation.com";
			data[0][1] = "pass1";

			data[1][0] = "java@way2automation.com";
			data[1][1] = "pass2";
			
		} else if (m.getName().equals("testUserReg")) {
			
			data = new Object[2][3];

			data[0][0] = "Bob";
			data[0][1] = "Smith";
			data[0][2] = "trainer@way2automation.com";

			data[1][0] = "John";
			data[1][1] = "Miller";
			data[1][2] = "java@way2automation.com";
		}

		return data;
	}

	@DataProvider(name = "dp2")
	public Object[][] getRegData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "Bob";
		data[0][1] = "Smith";
		data[0][2] = "trainer@way2automation.com";

		data[1][0] = "John";
		data[1][1] = "Miller";
		data[1][2] = "java@way2automation.com";

		return data;
	}

}
