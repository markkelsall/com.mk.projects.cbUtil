package com.mk.projects.cbUtil.impl;

import com.mk.projects.cbUtil.CBOperationResponse;

public interface BucketAdmin {
	public CBOperationResponse insertBucket (String bucketName);
	
	public CBOperationResponse deleteBucket (String bucketName);
	
	public void connectToCluster();
}
