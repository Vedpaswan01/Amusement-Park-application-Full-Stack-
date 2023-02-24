package com.FunXtreme.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin  {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminID;

	@NotNull
	@Size(min = 4, max = 12, message = "Username must have minimum 4 to 12 characters")
	private String username;
	@Size(min = 4, max = 12, message = "Password must have minimum 4 to 12 characters")
	private String password;
	@NotNull
	private String address;
	@Size(min = 10, message = "Mobile Number must have 10 digits!")
	private String mobileNumber;
	@Email
	private String email;
	
	
	

}
