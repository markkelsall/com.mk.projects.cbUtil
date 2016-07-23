package com.mk.projects.cbUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.couchbase.client.java.CouchbaseCluster;

public class ConnectionManager {
	
	private static final Logger logger = LogManager.getLogger(ConnectionManager.class);
	
	private CouchbaseCluster cluster;
	
	@PostConstruct
	public void init() {
		logger.trace("Entering ConnectionManager.init()");
		
		try {
			cluster = CouchbaseCluster.create();
		} catch (Exception e) {
			cluster = null;
			logger.error("Couldn't connect to Cluster");
			logger.error(e.getLocalizedMessage());
		}
		
		logger.trace("Exiting ConnectionManager.init()");
	}
	
	@PreDestroy
    public void destroy() {
		logger.trace("Entering ConnectionManager.destroy()");
		if (cluster != null) {
			cluster.disconnect();
			cluster = null;
		}
		logger.trace("Exiting ConnectionManager.destroy()");
	}
	
	public CouchbaseCluster getCluster() {
        return cluster;
    }
}
