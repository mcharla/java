package com.first.springweb.obj;

import java.util.Date;
import java.util.List;

public class UserBO {
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth; 
	private AddressBO address;
	private List<PhoneBO> phones;
	private String email;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public AddressBO getAddress() {
		return address;
	}
	public void setAddress(AddressBO address) {
		this.address = address;
	}
	public List<PhoneBO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneBO> phones) {
		this.phones = phones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
