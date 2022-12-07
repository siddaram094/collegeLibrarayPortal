package com.college.library.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static String getCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static String getReturndate() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime tomorrow = now.plusDays(7);
		return dtf.format(tomorrow);
	}
}
