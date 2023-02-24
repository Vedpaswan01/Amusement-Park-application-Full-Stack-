package com.FunXtreme.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

	@Email
	private String email;

	@Size(min = 4, max = 12, message = "Password should has minimum 4 to 12 characters")
	private String password;

}
