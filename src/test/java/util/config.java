package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class config {
	
	public static final Logger log=LoggerFactory.getLogger(config.class);
	//public static final String DEFAULT_PROPERTIES=System.getProperty("user.dir")+"/src/test/java/resources/config/default-config.properties";
	public static final String DEFAULT_PROPERTIES="config/default-config.properties";
	
	public static void initialize() {
		// load default property
		Properties properties;
		properties=getProperty();
		
		// check for any ovverride
		for(String key:properties.stringPropertyNames()) {
			if(System.getProperties().containsKey(key)) {
				properties.setProperty(key, System.getProperty(key));
			}
		}
		// print
		log.info("Test properties");
		for(String key:properties.stringPropertyNames()) {
			log.info("{} {} ",key,properties.getProperty(key));
		}
	}
	public static String get(String key) {
		Properties properties;
		properties=getProperty();
		String value=properties.getProperty(key);
		return value;
	}
	
	public static Properties getProperty() {
		System.out.println(DEFAULT_PROPERTIES);
		Properties prop=new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(DEFAULT_PROPERTIES);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	
	

}
