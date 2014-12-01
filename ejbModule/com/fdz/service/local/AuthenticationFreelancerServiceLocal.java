package com.fdz.service.local;

import java.util.List;

import javax.ejb.Local;

import com.fdz.domain.Freelancer;
@Local
public interface AuthenticationFreelancerServiceLocal {
	void createFreelancer(Freelancer user);
	List<Freelancer> findAllFreelancers();
	Freelancer authenticate(String login, String password);
	boolean loginExists(String login);
	void saveOrUpdateFreelancer(Freelancer freelancer);
	void disableAccountFreelancer(int idFreelancer);
}
