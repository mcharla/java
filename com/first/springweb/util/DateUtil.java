package com.first.springweb.util;

import java.text.ParseException;


public class DateUtil {

	public static boolean checkIfDateIsValid(String expiration) {

		try {
			WarehouseConstants.DATE_FORMAT.parse(expiration);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
