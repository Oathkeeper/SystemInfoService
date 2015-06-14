package ca.owenpeterson.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss aaa");
	
	public static String formatDateToString(Date date) {
		String formattedDate;
		formattedDate = dateFormat.format(date);
		return formattedDate;
	}

}
