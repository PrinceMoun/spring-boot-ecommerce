package com.Quovantis.domain.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quovantis.entity.Application;

@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<Application, String> {

}
