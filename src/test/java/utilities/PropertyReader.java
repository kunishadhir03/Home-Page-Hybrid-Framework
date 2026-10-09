package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	
	static Properties prop ;
	
	static  {
		
		try {
			
			FileInputStream file = new FileInputStream("src\\test\\resources\\configuration\\configuration.properties");
			
			prop = new Properties();
			
			prop.load(file);
			
		} 
		
		catch (Exception e) {
		    
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		
		return prop.getProperty(key);
	}

}
