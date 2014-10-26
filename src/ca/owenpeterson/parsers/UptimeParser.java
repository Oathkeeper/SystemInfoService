package ca.owenpeterson.parsers;

import org.apache.commons.lang3.StringUtils;

import ca.owenpeterson.jaxb.Uptime;

public class UptimeParser {
	
	public static Uptime parseToUptime(String rawUptime) {
		String currentTime = extractCurrentTime(rawUptime);
		String currentUptime = extractUptime(rawUptime);
		String users = extractUsers(rawUptime);
		String load = extractLoad(rawUptime);
		
		
		Uptime uptime = new Uptime();
		uptime.setCurrentTime(StringUtils.trim(currentTime));
		uptime.setUptime(StringUtils.trim(currentUptime));
		uptime.setUsers(StringUtils.trim(users));
		uptime.setLoad(StringUtils.trim(load));
		
		return uptime;
		
	}
	
	private static String extractCurrentTime(String rawUptime) {
		String currentTime = StringUtils.substringBefore(rawUptime, " ");		
		return currentTime;
	}
	
	private static String extractUptime(String rawUptime) {
		String currentUptime = StringUtils.substringBetween(rawUptime, "up", ",");
		return currentUptime;
	}
	
	private static String extractUsers(String rawUptime) {
		String users = StringUtils.substringBetween(rawUptime, ",");
		return users;
	}
	
	private static String extractLoad(String rawUptime) {
		String load = StringUtils.substringAfter(rawUptime, "users,");
		return load;
	}

}
