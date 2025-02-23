package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);
   public void onTestStart(ITestResult result) {
           logger.info("Test Suite has started!!!");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite has completed!!!");
    }
   public void onTestSuccess(ITestResult result) {
       logger.info("Test Passed Method Name '" + result.getMethod().getMethodName() +"'");
       logger.info("Description :: " + result.getMethod().getDescription());
    }


    public void onTestFailure(ITestResult result) {
        logger.error("Failed!!",result.getMethod().getMethodName());
    }

   public void onTestSkipped(ITestResult result) {
       logger.info("Failed!!",result.getMethod().getMethodName());
    }



}
