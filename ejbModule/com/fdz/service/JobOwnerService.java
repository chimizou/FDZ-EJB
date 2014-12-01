package com.fdz.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fdz.domain.JobOwner;
import com.fdz.service.local.JobOwnerServiceLocal;

@Stateless
public class JobOwnerService implements JobOwnerServiceLocal {
    
	@PersistenceContext
	private EntityManager em;

	public JobOwnerService() {
    }

	@Override
	public void saveOrUpdate(JobOwner jobowner) {
		em.merge(jobowner);
		
	}

}
