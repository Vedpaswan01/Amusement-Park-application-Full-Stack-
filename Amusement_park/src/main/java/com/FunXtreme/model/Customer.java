package com.FunXtreme.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerID;

	
	@NotNull
	@Size(min = 4, max = 12, message = "Username should has minimum 4 to 12 characters")
	private String username;
	@Size(min = 4, max = 12, message = "Password should has minimum 4 to 12 characters")
	private String password;
	@NotNull
	private String address;
	@Size(min = 10, message = "Mobile Number should be of 10 digits!")
	private String mobileNumber;
	@Email
	private String email;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Ticket> tickets;

}
