package com.Quovantis.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Table(name="applications")
public class Application {
	
	@Column(name="related_offer")
	private String relatedOffer;
	
	@Id
	@Column(name="candidate_email")
	private String candidateEmail;
	
	@Column(name="resume_text")
	private String resumeText;
	
	@Column(name="application_status")
	private String applicationStatus;


	//@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	//@JoinColumn(name ="related_offer", referencedColumnName = "job_title")
	//@JsonBackReference
	/*
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name ="related_offer")
	@JsonIgnore

	private Offer offers;
	*/

	@Override
	public String toString() {
		return "Application [relatedOffer=" + relatedOffer + ", candidateEmail=" + candidateEmail + ", resumeText="
				+ resumeText + ", applicationStatus=" + applicationStatus + "]";
	}
	

}
