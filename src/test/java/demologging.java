import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class demologging {
	public static final Logger log=LoggerFactory.getLogger(demologging.class);
	public static void main(String[] args) {
		
		log.info("hello");
		log.debug("debugging");
		log.error("error found");
		log.warn("warning");
	}

}
