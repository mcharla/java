package com.first.springweb.util;

import com.first.springweb.obj.Phone;
import com.first.springweb.obj.PhoneBO;

public class PhoneUtil {

	public static PhoneBO convertToPhoneBO(Phone phone) {
		PhoneBO bo = new PhoneBO();
		bo.setPhoneId(Long.valueOf(phone.getPhoneId()));
		bo.setPhoneNumber(Long.valueOf(phone.getPhoneNumber()));
		bo.setPhoneType(phone.getPhoneType());
		return bo;
	}

}

