package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	private static Properties prop;

	static {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
		}

	}

	public static String getMyValue(String key) {

		String value = prop.getProperty(key);
		return value;

	}
}
