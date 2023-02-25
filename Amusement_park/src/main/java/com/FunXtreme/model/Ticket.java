package com.FunXtreme.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Ticket {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TicketId;

	@JsonIgnore
	@OneToOne
	private Activity activity;

	private LocalDate dateTime;

	@JsonIgnore
	@ManyToOne
	private Customer customer;

}
