package com.FunXtreme.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUser {
	
	@NotNull
	@Size(min = 4, max = 12, message = "Password should has minimum 4 to 12 characters")
	private String username;
	@Size(min = 4, max = 12, message = "Password should has minimum 4 to 12 characters")
	private String password;
	@NotNull
	private String address;
	@Size(min = 10, message = "Mobile Number should be of 10 digits!")
	private String mobileNumber;
	@Email
	private String email;

	
	

}
