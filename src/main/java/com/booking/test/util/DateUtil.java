package com.booking.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getNextSaturday() {
		Calendar calendar = Calendar.getInstance(); // текущая дата и время в календаре
		while (calendar.get(Calendar.DAY_OF_WEEK) != 7) {   // берет из салендаря день недели (Воскресенье это 1 день)и сравнивает его с 7 (Субботой)
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		return formateDate(calendar.getTime());
	}

	public static String getNextSunday() {

		String saturday = getNextSaturday();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(saturday));
			calendar.add(Calendar.DATE, 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formateDate(calendar.getTime());

	}

	private static String formateDate(Date date) {
		String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		return formattedDate;
	}
}
