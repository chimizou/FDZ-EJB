package com.fdz.service.local;

import javax.ejb.Local;
import com.fdz.domain.JobOwner;

@Local
public interface JobOwnerServiceLocal {
	void saveOrUpdate(JobOwner jobowner);
}
