package com.Quovantis;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quovantis.domain.repository.ApplicationRepository;
import com.Quovantis.entity.Application;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepository;

	/*
	 * @GetMapping() public ResponseEntity getApplications() { List<Application>
	 * applications = applicationRepository.findAll(); return
	 * ResponseEntity.ok(applications.toString());
	 * //ResponseEntity.ok("getApplications called"); }
	 */

	@GetMapping()
	public List<Application> getApplications() {
		// List<Application> applications = applicationRepository.findAll();
		// return ResponseEntity.ok(applications.toString());
		List<Application> list = new ArrayList<>();
		applicationRepository.findAll().forEach(list::add);
		return list;
		// ResponseEntity.ok("getApplications called");
	}

	@GetMapping("/{offer}")
	public ResponseEntity getApplicationsByOffer() {

		return ResponseEntity.ok("getApplicationsByOffer calledd");
	}

	@PostMapping(path = "/postApplication", consumes = "application/json", produces = "application/json")
	public ResponseEntity createApplication(@RequestBody Application application) {
	System.out.println(application.toString());
		final Application app = applicationRepository.save(application);
		//return ResponseEntity.ok("createApplication called");
		return ResponseEntity.ok(app);
	}

	/*
	 * @PostMapping(path = "/postApplication", consumes = "application/json",
	 * produces = "application/json") public Application
	 * createApplication(@RequestBody Application postApplication) { return
	 * applicationRepository.save(postApplication); }
	 */
}
