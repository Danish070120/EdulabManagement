package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "developer")
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "developer_id")
	private int developerId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_of_date")
	private LocalDate dateOfBirth;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Company company;

}
