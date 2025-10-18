package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParametrizationExcel {

	@Test(dataProvider="getData")
	public void testData(String username, String password, String is_correct) {
		
		System.out.println(username+"---"+password+"---"+is_correct);
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "trainer@way2automation.com";
		data[0][1] = "pass1";
		data[0][2] = "Y";

		data[1][0] = "java@way2automation.com";
		data[1][1] = "pass2";
		data[1][2] = "N";
		
		return data;
				
	}
}
