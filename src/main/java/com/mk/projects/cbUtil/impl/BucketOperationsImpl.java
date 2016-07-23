package com.mk.projects.cbUtil.impl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.mk.projects.cbUtil.impl.AbstractCouchbaseDocument;
import com.mk.projects.cbUtil.impl.BucketOperations;
import com.mk.projects.cbUtil.ConnectionManager;

public class BucketOperationsImpl implements BucketOperations {

	private static final Logger logger = LogManager.getLogger(BucketOperationsImpl.class);

	public void openBucket(String bucketName) {
		logger.trace("Entering BucketOperationsImpl.openBucket()");
		
		
		
		logger.trace("Exiting BucketOperationsImpl.openBucket()");
	}
	
	public void upsertDocument(AbstractCouchbaseDocument cbDoc, ConnectionManager cm) {
		logger.trace("Entering BucketOperationsImpl.upsertDocument()");
		
		if (cbDoc == null) {
			return;
		}
		
		if (cbDoc.getId() == null) {
			cbDoc.setId(UUID.randomUUID().toString());
		}
		
		Gson gson = new Gson();
		gson.toJson(cbDoc);
		
		logger.trace("Exiting BucketOperationsImpl.upsertDocument");
	}
}
