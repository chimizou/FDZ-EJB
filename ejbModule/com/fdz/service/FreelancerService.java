package com.fdz.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fdz.domain.Freelancer;
import com.fdz.service.local.FreelancerServiceLocal;

@Stateless
public class FreelancerService implements FreelancerServiceLocal {
	
	@PersistenceContext
	private EntityManager em;

    public FreelancerService() {
    }

    @Override
	public void saveOrUpdate(Freelancer freelancer) {
		em.merge(freelancer);
	}


	
}
