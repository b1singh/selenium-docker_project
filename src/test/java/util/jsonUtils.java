package util;

import java.io.File;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import Tests.vendorPortal.VendorPortalTestData;

public class jsonUtils {
	private static final Logger log=LoggerFactory.getLogger(jsonUtils.class);
	private static final ObjectMapper mapper=new ObjectMapper();
	
	public static <T> T getTestData(String path, Class<T> type) {
		try {
			InputStream stream=ResourceLoader.getResource(path);
			return mapper.readValue(stream, type);
			
		}catch (Exception e) {			
			log.info("unable to read test data {}",path);
		}
		return null;
	}
	
	

}