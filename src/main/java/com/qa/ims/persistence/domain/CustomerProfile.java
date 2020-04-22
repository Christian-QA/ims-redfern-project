package com.qa.ims.persistence.domain;

public class CustomerProfile {

	private Long id;
	private String forename;
	private String surname;
	private int age;
	private String email;
	private String address;
	private String username;

	String ageAsListed;

	public CustomerProfile(String forename, String surname) {
		this.forename = forename;
		this.surname = surname;
	}

	public CustomerProfile(Long id, String forename, String surname) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
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
		if (age == 0) {
			ageAsListed = "N/A";
		} else {
			ageAsListed = Integer.toString(age); /// To be tested
		}

		return "id: " + id + " | first name: " + forename + " | surname: " + surname + " | age: " + ageAsListed
				+ "\n ------------------------------------------------------";
	}
}
