package ca.owenpeterson.integration.test;

import static org.junit.Assert.*;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ca.owenpeterson.exception.CommandExecutionException;
import ca.owenpeterson.service.SystemInfoServiceController;
import ca.owenpeterson.service.SystemInfoServiceManager;

public class SystemClientIntegrationTest {
	
	private Mockery mockery;
	private SystemInfoServiceManager mockSystemInfoServiceManager;
	private SystemInfoServiceController action;
	
	@Before
	public void setUp() throws Exception {
		mockery = new Mockery();
		mockery.setImposteriser(ClassImposteriser.INSTANCE);
		
		action = mockery.mock(SystemInfoServiceController.class);
		
		mockSystemInfoServiceManager = mockery.mock(SystemInfoServiceManager.class);
		//FieldUtils.writeField("systemInfoServicemanager", action, mockSystemInfoServiceManager);
		
	}

	@Ignore("work in progress")
	@Test
	public void SystemInfoService_getUptime_throwsException() throws Exception {
		Exception exception = new CommandExecutionException();
		
		setExpecation_GetUptime_ThrowsException(exception);
		
		action.getUptime();
		
		mockery.assertIsSatisfied();
		
	}
	
	public void setExpecation_GetUptime_ThrowsException(final Exception exception) throws Exception {
		this.mockery.checking(new Expectations(){
			{
				oneOf(mockSystemInfoServiceManager.getUptime());
				will(throwException(exception));
			}
		});
	}

}
