package com.Quovantis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date startDate;
	
	@Column(name = "number_of_application")
	private int numberOfApplication;

	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "relatedOffer")
	@OneToMany(mappedBy = "offers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@Column(nullable = false)
	//@JsonManagedReference
	private List<Application> allApplicattion;

	@Override
	public String toString() {
		return "Offer [jobTitle=" + jobTitle + ", startDate=" + startDate + ", numberOfApplication="
				+ numberOfApplication + "]";
	}
	

}
