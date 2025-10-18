package parameterization;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParametrizationExcel {

	@Test(dataProvider="getData")
	public void testData(Hashtable<String, String> data) {
		
		System.out.println(data.get("username")+"---"+data.get("password"));
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		Object[][] data = new Object[2][1];
		
		Hashtable<String, String> table1 =
				new Hashtable<String, String>();
		
		table1.put("username",  "Bob");
		table1.put("password",  "pass");
		table1.put("is_active",  "Y");
		table1.put("key",  "value");
		
		data[0][0] = table1;

		Hashtable<String, String> table2 =
				new Hashtable<String, String>();
		
		table2.put("username",  "John");
		table2.put("password",  "@#$password$#@");
		table2.put("is_active",  "N");
		table2.put("key",  "value");
		
		data[1][0] = table2;

		return data;
				
	}
}
