package net.nikosath.springbootrestunittest.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Data;

@Entity
public class FictionalCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fictionalCharacterId;
	private String firstName;
	private String lastName;
	@Transient
	private String fullName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate birthdate;

	protected FictionalCharacter() {
	}
	
	public FictionalCharacter(Long fictionalCharacterId, String firstName, String lastName,
			Gender gender, LocalDate birthdate) {
		super();
		this.fictionalCharacterId = fictionalCharacterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public FictionalCharacter(String firstName, String lastName, Gender gender, LocalDate birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public Long getFictionalCharacterId() {
		return fictionalCharacterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

}
