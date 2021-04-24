package com.sigsomsavath.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	@NotNull(message = "First name can't be null")
	private String firstname;
	@NotNull(message = "Lastname can't be null")
	private String lastname;
	@NotNull(message = "email shouldn't be null")
	@Email
	private String email;
	@NotNull(message = "can't have a null password")
	@Size(min = 8, message = "Greater than 8 length email")
	private String password;

	public UserDetailsRequestModel(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
}