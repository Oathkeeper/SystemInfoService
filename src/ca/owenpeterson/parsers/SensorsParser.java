package ca.owenpeterson.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.jaxb.sensors.Adapter;
import ca.owenpeterson.jaxb.sensors.AdapterList;
import ca.owenpeterson.jaxb.sensors.Sensors;
import ca.owenpeterson.jaxb.sensors.Temperature;
import ca.owenpeterson.jaxb.sensors.TemperatureList;

public class SensorsParser {
	
	static Logger logger = LogManager.getLogger(SensorsParser.class);
	
	public static Sensors parseToSensors(String rawSensorsOutput) {
		logger.debug("SensorsParser():parseToSensors(): Begin.");
		Sensors sensors = new Sensors();
		AdapterList adapterList = new AdapterList();
		List<String> splitAdapters;
		
		
		splitAdapters = splitByAdapter(rawSensorsOutput);
		
	
		logger.debug("iterating over adapter strings to extract required info");
		for (String str : splitAdapters) {
			String name = extractAdapterName(str);
			logger.debug("Processing adapter: " + name);
			String type = extractAdapterType(str);
			TemperatureList temperatures = extractTemperatures(str);
			Adapter adapter = new Adapter(name, type, temperatures);
			adapterList.add(adapter);
			logger.debug("New adapter created and added to list.");
		}
		
		sensors.setAdapters(adapterList);
		logger.debug("List of adapters set on sensors object. Returning sensors.");
		
		return sensors;		
		
	}
	
	private static List<String> splitByAdapter(String rawSensorsOutput) {
		logger.debug("Splitting raw sensors string by adapter");
		String input = rawSensorsOutput;
		List<String> adapterList = new ArrayList<String>();		
		
		while(input.contains(";")) {
			String currentAdapter;
			currentAdapter = StringUtils.substringBefore(input, ";");
			input = StringUtils.remove(input, currentAdapter);
			input = StringUtils.removeStart(input, ";");
			
			adapterList.add(currentAdapter);
		}
		
		if (input.equals(";")) {
			input = StringUtils.remove(input,";");
		}
		
		logger.debug("Sensors string finished splitting. returning list of adapters.");
		return adapterList;		
	}
	
	private static TemperatureList extractTemperatures(String adapterOutput) {
		logger.debug("Begining to extract temperatures for the current adapter.");
		TemperatureList temperatureList = new TemperatureList();
		
		if (StringUtils.isNotEmpty(adapterOutput)) {
			logger.debug("begining Temp extraction on Sensors output");
			Scanner stringReader = new Scanner(adapterOutput);
			String line = null;
			try {
				while (stringReader.hasNext()) {
					line = stringReader.nextLine();
					if (StringUtils.startsWith(line, "temp")) {
						String tempLine = StringUtils.substringBefore(line, "(");
						String name = StringUtils.substringBefore(tempLine, ":");
						String value = StringUtils.substringAfter(tempLine, " ");
						name = StringUtils.trim(name);
						value = StringUtils.trim(value);
						Temperature temperature = new Temperature(name, value);
						temperatureList.add(temperature);
					}
				}
				stringReader.close();
			} catch (NoSuchElementException nex) {
				logger.debug("No newline characters found in file.");
				logger.error(nex);
			}
		}
		
		logger.debug("Finished extracting temperatures for the current adapter.");
		return temperatureList;
		
	}
	
	private static String extractAdapterName(String adapterOutput) {
		String name = StringUtils.substringBefore(adapterOutput, "Adapter");
		name = StringUtils.remove(name, "/n");
		name = StringUtils.trim(name);
		return name;
	}
	
	private static String extractAdapterType(String adapterOutput) {
		String type = StringUtils.substringBetween(adapterOutput, "Adapter:", "\n");
		type = StringUtils.trim(type);
		return type;
	}

}
