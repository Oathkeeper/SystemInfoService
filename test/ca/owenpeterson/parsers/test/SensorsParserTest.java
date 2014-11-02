package ca.owenpeterson.parsers.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ca.owenpeterson.jaxb.Adapter;
import ca.owenpeterson.jaxb.AdapterList;
import ca.owenpeterson.jaxb.Sensors;
import ca.owenpeterson.parsers.SensorsParser;
import ca.owenpeterson.systeminterface.SystemInterface;

public class SensorsParserTest {
	
	private SystemInterface systemInterface = new SystemInterface();
	private final String SENSORS_CMD = "sensors";

	@Test
	public void testSensorsParser_splitByAdapter() throws Exception {
		String rawSensorsOutput = systemInterface.getCommandOutput(SENSORS_CMD);
		
		Sensors actual = SensorsParser.parseToSensors(rawSensorsOutput);
		
		AdapterList adapterList = actual.getAdapters();
		assertNotNull("Result of action was null.", actual);
		assertNotNull("List of adapters was null", actual.getAdapters());
		assertTrue("Adapter list should have two adapters.", adapterList.getAdapters().size() == 2 );
	}

}
