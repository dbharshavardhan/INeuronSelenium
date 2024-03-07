package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperty(String key) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/config/config.properties")));
		} catch (FileNotFoundException e) {
			System.out.println("file could not be found"+e.getMessage());
		} catch (IOException e) {
			System.out.println("file could not be loaded"+e.getMessage());
		}

		String value = pro.getProperty(key);
		return value;
	}
}
