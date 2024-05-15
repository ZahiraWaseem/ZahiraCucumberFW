package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {

	public static String readDataFromPropertyFile(String fileName,String propertyKey) {
		File file = new File("./data/"+fileName+".properties");
		FileInputStream fis;
		String propertyvalue="";
		try {
			fis = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fis);
			propertyvalue = properties.getProperty(propertyKey);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	     return propertyvalue;	
	}

}
