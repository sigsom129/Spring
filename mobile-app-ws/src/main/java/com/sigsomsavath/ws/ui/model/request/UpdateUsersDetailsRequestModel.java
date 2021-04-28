package com.sigsomsavath.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUsersDetailsRequestModel {
	@NotNull(message = "First name can't be null")
	private String firstname;
	@NotNull(message = "Lastname can't be null")
	@Size(min = 2, message ="More than 2 Characters")
	private String lastname;
	
	
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
	

}
