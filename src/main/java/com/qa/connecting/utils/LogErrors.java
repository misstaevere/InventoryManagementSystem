package com.qa.connecting.utils;

import org.apache.log4j.Logger;

public class LogErrors {

	public void log(Logger logger, Exception exception) {
		logger.error(exception.getMessage());
		for (StackTraceElement element : exception.getStackTrace()) {
			logger.debug(element);
		}
	}
}
