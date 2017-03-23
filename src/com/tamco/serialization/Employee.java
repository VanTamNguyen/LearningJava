package com.tamco.serialization;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tam-co on 22/03/2017.
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = -7701246967096175513L;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private transient int numberOfCards;

	public Employee(String firstName, String lastName, Date birthDate, int numberOfCards) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.numberOfCards = numberOfCards;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public void setNumberOfCards(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthDate=" + birthDate +
				", numberOfCards=" + numberOfCards +
				'}';
	}
}
