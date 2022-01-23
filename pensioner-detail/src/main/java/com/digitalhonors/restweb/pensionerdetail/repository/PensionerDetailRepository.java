package com.digitalhonors.restweb.pensionerdetail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitalhonors.restweb.pensionerdetail.model.PensionerDetail;

@Repository
public interface PensionerDetailRepository extends CrudRepository<PensionerDetail, Long> {
	PensionerDetail findByAadhaarNumber(Long aadhaarNumber);

}
