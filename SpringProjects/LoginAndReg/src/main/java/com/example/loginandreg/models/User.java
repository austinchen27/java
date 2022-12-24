package com.example.loginandreg.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required!")
	@Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	private String userName;
	
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=3, max=128, message="Password must be between 3 and 128 characters")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=3, max=128, message="Confirm Password must be between 3 and 128 characters")
	private String confirm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	

}



//1. Attributes
//- required fields: id, userName, email, password, confirm
//- password: set max with a larger number as hashed password maybe longer
//- confirm: needs to be transient so that it won't get stored in database


//TODO - Don't forget to generate getters and setters
//2. Zero-arguments constructors


//3. Getters/Setters



