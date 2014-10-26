package ca.owenpeterson.testclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {
	static Logger logger = LogManager.getLogger(LoggerTest.class.getName());

	public static void main(String[] args) {
		logger.debug("debug log test.");
		logger.info("info log test.");
		logger.warn("warn log test.");
		logger.fatal("fatal log test.");

	}

}
