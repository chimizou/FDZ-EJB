package com.fdz.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fdz.domain.Freelancer;
import com.fdz.service.local.AuthenticationFreelancerServiceLocal;



@Stateless
public class AuthenticationFreelancerService implements AuthenticationFreelancerServiceLocal{

	@PersistenceContext
	private EntityManager em;
	
	public AuthenticationFreelancerService() {
	}
    
	public void createFreelancer(Freelancer freelancer) {
		em.persist(freelancer);
	}
	public Freelancer authenticate(String login, String password) {
		Freelancer found = null;
		String jpql = "select u from Freelancer u where u.login=:login and u.password=:password";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try{
			found = (Freelancer) query.getSingleResult();
		}catch(Exception ex){
			Logger.getLogger(AuthenticationFreelancerService.class.getName()).log(Level.WARNING, "authentication attempt failure with login="+login+" and password="+password);
		}
		return found;
	}

	public List<Freelancer> findAllFreelancers() {
		return em.createQuery("select u from Freelancer u").getResultList();
	}


	public boolean loginExists(String login) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from Freelancer u where u.login=:login";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		exists = (Boolean)query.getSingleResult();
		return exists;
	}

	@Override
	public void saveOrUpdateFreelancer(Freelancer freelancer) {
		em.merge(freelancer);
		
	}

	@Override
	public void disableAccountFreelancer(int idFreelancer) {
		String jpql = "update Freelancer u set u.state='1' where u.idFreelancer=:idFreelancer";
		Query query = em.createQuery(jpql);
		query.setParameter("idFreelancer", idFreelancer);
		
	}

}
