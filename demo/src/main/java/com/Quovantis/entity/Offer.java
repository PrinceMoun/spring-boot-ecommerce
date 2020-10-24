package com.Quovantis.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "offers")
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
@JsonSerialize
public class Offer {
	
	@Id
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "number_of_application")
	private int numberOfApplication;

	@Override
	public String toString() {
		return "Offer [jobTitle=" + jobTitle + ", startDate=" + startDate + ", numberOfApplication="
				+ numberOfApplication + "]";
	}
	

}
