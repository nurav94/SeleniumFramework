package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static final String configFilePath = "./src/test/java/config/config.properties";
	private Properties properties;

	public ConfigReader() {

		properties = new Properties();

		try {
			FileInputStream fileInputStream = new FileInputStream(configFilePath);
			properties.load(fileInputStream);
			fileInputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}

}
