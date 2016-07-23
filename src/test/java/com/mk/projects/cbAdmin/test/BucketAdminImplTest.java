package com.mk.projects.cbAdmin.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mk.projects.cbUtil.impl.BucketAdmin;
import com.mk.projects.cbUtil.impl.BucketAdminImpl;
import com.mk.projects.cbUtil.CBOperationResponse;

public class BucketAdminImplTest {
	public static final Logger logger = LogManager.getLogger(BucketAdminImplTest.class);
	
	public static void main(String[] args) {
		logger.debug("entering");
		BucketAdmin admin = new BucketAdminImpl();
		CBOperationResponse response = null;
		
		response = admin.insertBucket("");
		if (!response.isSuccessful()) {
			logger.debug("Rejected create empty bucket name");
		} else {
			logger.error("Accepted empty bucket name");
		}
		
		response = admin.insertBucket("test");
		if (response.isSuccessful()) {
			logger.debug("Bucket created successfully - test");
		} else {
			logger.error("Bucket wasn't created - test");
		}
		
		response = admin.insertBucket("test");
		if (response.isSuccessful()) {
			logger.error("Bucket created again somehow - test");
		} else {
			logger.debug("Bucket wasn't created again - test");
		}
		
		response = admin.deleteBucket("");
		if (!response.isSuccessful()) {
			logger.debug("Rejected deleting bucket with no name");
		} else {
			logger.error("Removed a bucket with no name");
		}
		
		response = admin.deleteBucket("test");
		if (response.isSuccessful()) {
			logger.debug("Deleted bucket successfully - test");
		} else {
			logger.error("Didn't delete bucket");
		}
		
        logger.debug("exiting");
	}
}
