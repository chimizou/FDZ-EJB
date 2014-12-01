package com.fdz.service.local;

import javax.ejb.Local;

import com.fdz.domain.Freelancer;

@Local
public interface FreelancerServiceLocal {

	void saveOrUpdate(Freelancer freelancer);

}
