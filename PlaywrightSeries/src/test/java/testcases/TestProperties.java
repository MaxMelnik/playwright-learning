package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis 
		= new FileInputStream(
				".\\src\\test\\resources\\properties\\locators.properties"
				);
		prop.load(fis);
		
		System.out.println(prop.get("browser"));
	}

}
