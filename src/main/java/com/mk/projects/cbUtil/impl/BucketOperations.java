package com.mk.projects.cbUtil.impl;

import com.mk.projects.cbUtil.ConnectionManager;

public interface BucketOperations {

	public void openBucket (String bucketName);
	
	public void upsertDocument (AbstractCouchbaseDocument json, ConnectionManager cm);
}
