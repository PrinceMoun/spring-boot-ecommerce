package com.Quovantis.domain.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quovantis.entity.Offer;

@Repository
@Transactional
public interface OfferrRepository extends JpaRepository<Offer, String>{

}
