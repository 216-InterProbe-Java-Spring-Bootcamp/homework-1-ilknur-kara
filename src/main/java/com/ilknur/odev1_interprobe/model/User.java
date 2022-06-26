package com.ilknur.odev1_interprobe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * @author İlknur Kara
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TABLE")
public class User {

	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "LASTNAME", length = 50, nullable = false)
	private String lastname;

	@Email
	@Column(name = "EMAIL", length = 50, nullable = false)
	private String email;

	@Column(name = "PHONE_NUMBER", length = 15, nullable = false)
	private String phoneNumber;

}
