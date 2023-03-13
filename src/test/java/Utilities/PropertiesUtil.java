package Utilities;

import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	Properties properties;
	public PropertiesUtil(RemoteWebDriver driver) throws IOException {
			FileReader input = new FileReader("C:\\Users\\HP\\eclipse-workspace\\org.Jenkins\\src\\test\\resources\\TestDataFiles\\Config.properties");
			properties = new Properties();
			properties.load(input);
		
		
	}
	public String browser(){
		String browser=properties.getProperty("browser");
		if(browser!=null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl(RemoteWebDriver driver){
		String url=properties.getProperty("siteurl");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getUserName(){
		String uid=properties.getProperty("username");
		if(uid!=null)
			return uid;
		else
			throw new RuntimeException("username not specified in the Configuration.properties file.");
	}

	public String getPassword(){
		String pwd=properties.getProperty("password");
		if(pwd!=null)
			return pwd;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
	public String getBrowser(){
		String brw=properties.getProperty("chromebr");
		if(brw!=null)
			return brw;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
}