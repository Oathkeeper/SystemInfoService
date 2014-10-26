package ca.owenpeterson.test.parsers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ca.owenpeterson.parsers.SensorsParser;
import ca.owenpeterson.systeminterface.SystemInterface;

public class SensorsParserTest {
	
	private SystemInterface systemInterface = new SystemInterface();
	private final String SENSORS_CMD = "sensors";

	@Test
	public void testSensorsParser_splitByAdapter() {
		String rawSensorsOutput = systemInterface.getCommandOutput(SENSORS_CMD);
		
		fail("Not yet implemented");
	}

}
