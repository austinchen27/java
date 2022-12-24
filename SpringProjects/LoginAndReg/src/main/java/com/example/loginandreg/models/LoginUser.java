package com.example.loginandreg.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	
	// LoginUser models won't be stored.  It is for data binding in login
	
	// 1. Attributes
	// - required fields: email, password
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=3, max=128, message="Password must be between 3 and 128 characters")
    private String password;

	public LoginUser() {
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
	
	// 2. Zero-argument constructors
    
	
	// 3. Getters/Setters
    

}


// 1. Attributes
// - required fields: id, userName, email, password, confirm
// - password: set max with a larger number as hashed password maybe longer
// - confirm: needs to be transient so that it won't get stored in database


// TODO - Don't forget to generate getters and setters
// 2. Zero-arguments constructors


// 3. Getters/Setters
