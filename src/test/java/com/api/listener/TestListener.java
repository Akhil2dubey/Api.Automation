package com.api.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		logger.info("Test suite Started");
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Passed !!" + result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		logger.error("Failed !!" + result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Skiped !!" + result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		logger.info("Test suite Completed");
	}

	public void onTestStart(ITestResult result) {
		logger.info("Started !!" + result.getMethod().getMethodName());
		logger.info("Description" + result.getMethod().getMethodName());
	}
}
