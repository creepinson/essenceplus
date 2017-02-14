package me.creepinson.lib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	public static Logger logger;
	public static Logger getLogger() {
		if(logger == null){
			logger = LogManager.getFormatterLogger("MeepersPlus");
		}
		return logger;
	}
	
	
}
