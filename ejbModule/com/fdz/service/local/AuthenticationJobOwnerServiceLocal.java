package com.fdz.service.local;

import java.util.List;

import javax.ejb.Local;

import com.fdz.domain.JobOwner;
@Local
public interface AuthenticationJobOwnerServiceLocal {
	void createJobOwner(JobOwner user);
	List<JobOwner> findAllJobOwners();
	JobOwner authenticate(String login, String password);
	boolean loginExists(String login);
	void saveOrUpdateJobOwner(JobOwner jobowner);
}
