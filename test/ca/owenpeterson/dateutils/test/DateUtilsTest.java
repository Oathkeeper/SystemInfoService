package ca.owenpeterson.dateutils.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import ca.owenpeterson.utils.DateUtils;

public class DateUtilsTest {
	
	@Test
	public void testFormatDate() {
		Date now = new Date();
		String formattedDate = null;
		formattedDate = DateUtils.formatDateToString(now);
		
		assertNotNull(formattedDate);
		System.out.println(formattedDate);
	}

}
