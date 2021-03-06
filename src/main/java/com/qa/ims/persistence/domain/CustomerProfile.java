package com.qa.ims.persistence.domain;

public class CustomerProfile {

	private Long id;
	private String forename;
	private String surname;
	private int age;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		CustomerProfile other = (CustomerProfile) obj;
		if (forename == null) {
			if (other.forename != null) {
				return false;
			}
		} else if (!forename.equals(other.forename)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!surname.equals(other.surname)) {
			return false;
		}
		return true;
	}

	public String toString() {
		if (age == 0) {
			ageAsListed = "N/A";
		} else {
			ageAsListed = Integer.toString(age); /// To be tested
		}

		return "id: " + id + " | first name: " + forename + " | surname: " + surname
				+ "\n ------------------------------------------------------";
	}
}
