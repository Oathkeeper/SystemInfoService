package ca.owenpeterson.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.owenpeterson.jaxb.Sensors;
import ca.owenpeterson.jaxb.Uptime;
import ca.owenpeterson.parsers.SensorsParser;
import ca.owenpeterson.parsers.UptimeParser;
import ca.owenpeterson.systeminterface.SystemInterface;

@Component
public class SystemInfoServiceManager {
	
	static Logger logger = LogManager.getLogger(SystemInfoServiceManager.class);
	
	//@Autowired
	private SystemInterface systemInterface = new SystemInterface();
	
	private final String UPTIME_CMD = "uptime";
	private final String SENSORS_CMD = "sensors";
	
	public Uptime getUptime() {
		String rawUptime = systemInterface.getCommandOutput(UPTIME_CMD);
		rawUptime = StringUtils.normalizeSpace(rawUptime);
		Uptime uptime = UptimeParser.parseToUptime(rawUptime);
		
		return uptime;
		
	}
	
	public Sensors getSensorInfo() {
		logger.debug("SystemInfoServiceManger():getSensorInfo(): Begin");
		String rawSensorsOutput = systemInterface.getCommandOutput(SENSORS_CMD);
		Sensors sensors = SensorsParser.parseToSensors(rawSensorsOutput);
		logger.debug("SystemInfoServiceManger():getSensorInfo(): End. Returning sensors.");
		return sensors;	
		
	}

}
