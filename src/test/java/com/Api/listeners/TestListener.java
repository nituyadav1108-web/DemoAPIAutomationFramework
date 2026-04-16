package com.Api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static final Logger logger= LogManager.getLogger(TestListener.class);
	
	public void onStart(ITestContext context) {
		    logger.info("Test Suite Start");
		  }
	 public void onFinish(ITestContext context) {
		 logger.info("Test Suite Finish");
		  }
	
	public void onTestStart(ITestResult result) {
		logger.info("Started"+result.getMethod().getMethodName());
		logger.info("Description"+result.getMethod().getDescription());
		  }
	public void onTestSuccess(ITestResult result) {
		logger.info("passed"+result.getMethod().getMethodName());
		logger.info("Description"+result.getMethod().getDescription());
		  }
	public void onTestFailure(ITestResult result) {
		logger.error("fail"+result.getName());
		  }
	 
	public void onTestSkipped(ITestResult result) {
		logger.info("Skipped"+result.getMethod().getMethodName());
		  }

}
