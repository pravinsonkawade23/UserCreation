package com.qa.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static String getValue(String key) {

		Properties properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Repository\\Details.properties");
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
