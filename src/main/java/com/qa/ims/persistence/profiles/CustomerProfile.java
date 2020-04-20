package com.qa.ims.persistence.profiles;

public class CustomerProfile {

	private Long customer_id;
	private String forename;
	private String surname;
	private int age;
	private String email;
	private String address;
	private String username;

	public CustomerProfile(String forename, String surname) {
		this.forename = forename;
		this.surname = surname;
	}

	public CustomerProfile(Long customer_id, String forename, String surname) {
		this.customer_id = customer_id;
		this.forename = forename;
		this.surname = surname;
	}

	public final Long getId() {
		return customer_id;
	}

	public final void setId(Long customer_id) {
		this.customer_id = customer_id;
	}

	public final String getForename() {
		return forename;
	}

	public final void setForename(String forename) {
		this.forename = forename;
	}

	public final String getSurname() {
		return surname;
	}

	public final void setSurname(String surname) {
		this.surname = surname;
	}

	public final int getAge() {
		return age;
	}

	public final void setAge(int age) {
		this.age = age;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public String toString() {
		return "id:" + customer_id + " first name:" + forename + " surname:" + surname;
	}

}
