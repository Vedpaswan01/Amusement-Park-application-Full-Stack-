package com.FunXtreme.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAdminSession {
	@Id
	@Column(unique = true)
	private Integer userID;
	private String uuid;
	private LocalDateTime localDateTime;
}
