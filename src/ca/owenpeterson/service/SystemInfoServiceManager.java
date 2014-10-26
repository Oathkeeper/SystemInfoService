package ca.owenpeterson.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.owenpeterson.jaxb.Uptime;
import ca.owenpeterson.parsers.UptimeParser;
import ca.owenpeterson.systeminterface.SystemInterface;

@Component
public class SystemInfoServiceManager {
	
	//@Autowired
	private SystemInterface systemInterface = new SystemInterface();
	
	private final String UPTIME_CMD = "uptime";
	
	public Uptime getUptime() {
		String rawUptime = systemInterface.getCommandOutput(UPTIME_CMD);
		rawUptime = StringUtils.normalizeSpace(rawUptime);
		Uptime uptime = UptimeParser.parseToUptime(rawUptime);
		
		return uptime;
		
	}

}
