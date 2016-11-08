package com.first.springweb.util;

import com.first.springweb.obj.Address;
import com.first.springweb.obj.AddressBO;

public class AddressUtil {

	public static AddressBO convertToAddressBO(Address address) {
		AddressBO bo = new AddressBO();

		bo.setAddressId(Long.valueOf(address.getAddressId()));
		bo.setAddressLine1(address.getAddressLine1());
		bo.setAddressLine2(address.getAddressLine2());
		bo.setCity(address.getCity());
		bo.setCountry(address.getCountry());
		bo.setCounty(address.getCounty());
		bo.setState(address.getState());
		bo.setZip(Long.valueOf(address.getZip()));

		return bo;
	}

}
