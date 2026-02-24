package Common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
	private static final Logger log=LoggerFactory.getLogger(BasePage.class);
	
	public void updatelog(String string) {
		log.info(string);
	}
}
