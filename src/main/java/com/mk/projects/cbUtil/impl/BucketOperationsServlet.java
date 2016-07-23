package com.mk.projects.cbUtil.impl;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.mk.projects.cbUtil.impl.AbstractCouchbaseDocument;
import com.mk.projects.cbUtil.impl.BucketOperations;
import com.mk.projects.cbUtil.ConnectionManager;

public class BucketOperationsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(BucketOperationsServlet.class);
	
	@Inject
    ConnectionManager cm;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.trace("Entering CBServlet.doGet()");
		cm.getCluster();
		BucketOperations bo = new BucketOperationsImpl();
		if (request.getParameter("action").equalsIgnoreCase("upsert")) {
			Gson gson = new Gson();
			gson.fromJson(request.getParameter("doc").toString(), AbstractCouchbaseDocument.class);
			
		}
		logger.trace("Exiting CBServlet.doGet()");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.trace("Entering CBServlet.doPost()");
		cm.getCluster();
		logger.trace("Exiting CBServlet.doPost()");
	}
}
