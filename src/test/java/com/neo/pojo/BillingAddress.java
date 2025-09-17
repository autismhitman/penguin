package com.neo.pojo;

public class BillingAddress {

	// |firstname| lastname|country| address_line1| city| state| zip |email|

	private String firstName;
	private String lastName;
	private String country;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BillingAddress(String firstName, String lastName, String country, String address, String city, String state,
			String zip, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
	}

	 

	@Override
	public String toString() {
		return "BillingAddress [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", email=" + email
				+ "]";
	}

}
