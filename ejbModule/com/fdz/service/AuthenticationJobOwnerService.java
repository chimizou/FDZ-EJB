package com.fdz.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fdz.domain.Freelancer;
import com.fdz.domain.JobOwner;
import com.fdz.service.local.AuthenticationJobOwnerServiceLocal;



@Stateless
public class AuthenticationJobOwnerService implements AuthenticationJobOwnerServiceLocal{

	@PersistenceContext
	private EntityManager em;
	
	public AuthenticationJobOwnerService() {
	}
    
	public void createJobOwner(JobOwner jobowner) {
		em.persist(jobowner);
	}
	public JobOwner authenticate(String login, String password) {
		JobOwner found = null;
		String jpql = "select u from JobOwner u where u.login=:login and u.password=:password";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try{
			found = (JobOwner) query.getSingleResult();
		}catch(Exception ex){
			Logger.getLogger(AuthenticationJobOwnerService.class.getName()).log(Level.WARNING, "authentication attempt failure with login="+login+" and password="+password);
		}
		return found;
	}

	public List<JobOwner> findAllJobOwners() {
		return em.createQuery("select u from JobOwner u").getResultList();
	}


	public boolean loginExists(String login) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from JobOwner u where u.login=:login";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		exists = (Boolean)query.getSingleResult();
		return exists;
	}
	
	@Override
	public void saveOrUpdateJobOwner(JobOwner jobowner) {
		em.merge(jobowner);
		
	}

}
