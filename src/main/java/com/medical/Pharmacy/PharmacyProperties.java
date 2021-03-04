package com.medical.Pharmacy;

public class PharmacyProperties {
	private String name;
	private String lic_no;
	private String address;
	private String contact;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLic_no() {
		return lic_no;
	}
	public void setLic_no(String lic_no) {
		this.lic_no = lic_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Pharmacy detials name=" + name + ", lic_no=" + lic_no + "\n            address=" + address + ", mobile=" + contact
				+ "]";
	}
	
	
}
