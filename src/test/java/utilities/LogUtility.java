package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtility {
	public static Logger logger= Logger.getLogger(LogUtility.class);
	
	public void Info(String value) {
		PropertyConfigurator.configure("Log4j.properties");
		logger.info(value);
	}

}
