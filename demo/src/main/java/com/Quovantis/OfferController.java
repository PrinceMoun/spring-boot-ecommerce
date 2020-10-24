package com.Quovantis;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.spi.LocationAwareLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseCookie.ResponseCookieBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import com.Quovantis.domain.repository.OfferrRepository;
import com.Quovantis.entity.Offer;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/offers")
@Slf4j
public class OfferController {
	
	@Autowired
	OfferrRepository offerRepos;
	
@GetMapping()
  public ResponseEntity<List<Offer>>	getAllOffers(){
	List<Offer> offer = offerRepos.findAll();
		return ResponseEntity.ok(offer);
}

@PostMapping()
public ResponseEntity	createOffers(){
		return ResponseEntity.ok("post called");
	}

@GetMapping("/{offerId}")
public ResponseEntity getofferById(@PathVariable("offerId") String offerID){
	Offer offer=offerRepos.findById(offerID).get();
	System.out.println(offer.toString());
	//JSONObject json

		return ok(offer);
	}
}
