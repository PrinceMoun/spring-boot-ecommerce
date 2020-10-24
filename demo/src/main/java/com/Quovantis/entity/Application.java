package com.Quovantis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Override
	public String toString() {
		return "Application [relatedOffer=" + relatedOffer + ", candidateEmail=" + candidateEmail + ", resumeText="
				+ resumeText + ", applicationStatus=" + applicationStatus + "]";
	}
	

}
