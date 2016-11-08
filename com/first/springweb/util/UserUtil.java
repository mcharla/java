package com.first.springweb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.first.springweb.obj.AddressBO;
import com.first.springweb.obj.User;
import com.first.springweb.obj.UserBO;
import com.first.springweb.obj.Phone;
import com.first.springweb.obj.PhoneBO;

public class UserUtil {

	public static UserBO convertToCustomerBO(User customer) {

		UserBO bo = new UserBO();

		bo.setEmail(customer.getEmail());
		bo.setFirstName(customer.getFirstName());
		bo.setLastName(customer.getLastName());
		bo.setCustomerId(Long.valueOf(customer.getCustomerId()));
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			bo.setDateOfBirth(sdf.parse(customer.getDateOfBirth()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		AddressBO addressBO = AddressUtil.convertToAddressBO(customer.getAddress());
		bo.setAddress(addressBO);
		
		List<Phone> phones = customer.getPhones();
		List<PhoneBO> phoneBOs = new ArrayList<PhoneBO>();
		for (Phone phone : phones) {
			phoneBOs.add(PhoneUtil.convertToPhoneBO(phone));
		}
		bo.setPhones(phoneBOs);

		return bo;
	}

}









