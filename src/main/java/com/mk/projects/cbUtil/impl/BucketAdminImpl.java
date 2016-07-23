package com.mk.projects.cbUtil.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.couchbase.client.core.CouchbaseException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.cluster.ClusterManager;
import com.couchbase.client.java.cluster.DefaultBucketSettings;
import com.couchbase.client.java.cluster.DefaultBucketSettings.Builder;
import com.couchbase.client.java.error.BucketAlreadyExistsException;
import com.mk.projects.cbUtil.impl.BucketAdmin;
import com.mk.projects.cbUtil.CBOperationResponse;

public class BucketAdminImpl implements BucketAdmin {

	private static final Logger logger = LogManager.getLogger(BucketAdminImpl.class);
	
	private ClusterManager clusterManager = null;
	private final String ADMIN_USERNAME = "Administrator";
	private final String ADMIN_PASSWORD = "pr0file1";
	
	public CBOperationResponse insertBucket(String bucketName) {
		
		logger.info("Entering BucketAdminImpl.insertBucket()");
		
		CBOperationResponse response = null;
		
		if (bucketName == null || bucketName.length() == 0 || bucketName.equalsIgnoreCase("")) {
			response = new CBOperationResponse("1", "Bucket name provided is empty", "");
			return response;
		}
		
		if (this.clusterManager == null) {
			this.connectToCluster();
		}
		Builder settings = DefaultBucketSettings.builder();
		settings.name(bucketName);
		settings.quota(200);
		
		try {
			this.clusterManager.insertBucket(settings);
			response = new CBOperationResponse();
		} catch (BucketAlreadyExistsException e) {
			response = new CBOperationResponse("2", bucketName + " already exists as a bucket", e.getLocalizedMessage());
		} catch (CouchbaseException e) {
			response = new CBOperationResponse("3", "couldn't create bucket: " + bucketName + ", please see stack trace", e.getLocalizedMessage());
		}
		 
		logger.info("Exiting BucketAdminImpl.insertBucket()");
		
		return response;
	}

	public CBOperationResponse deleteBucket(String bucketName) {
		
		logger.info("Entering BucketAdminImpl.insertBucket()");
		
		CBOperationResponse response = null;
		
		if (bucketName == null || bucketName.length() == 0 || bucketName.equalsIgnoreCase("")) {
			response = new CBOperationResponse("1", "Bucket name provided is empty", "");
			return response;
		}
		
		if (this.clusterManager == null) {
			this.connectToCluster();
		}
		
		try {
			this.clusterManager.removeBucket(bucketName);
			response = new CBOperationResponse();
		} catch (CouchbaseException e) {
			response = new CBOperationResponse("2", "couldn't remove bucket:" + bucketName + ", please see stack trace", e.getLocalizedMessage());
		}
		
		logger.info("Exiting BucketAdminImpl.insertBucket()");
		
		return response;
	}

	public void connectToCluster() {
		logger.info("Entering BucketAdminImpl.connectToCluster()");
		
		Cluster cluster = CouchbaseCluster.create();
		this.clusterManager = cluster.clusterManager(this.ADMIN_USERNAME, this.ADMIN_PASSWORD);
		
		logger.info("Exiting BucketAdminImpl.connectToCluster()");
	}
}
