package com.CustomerManagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.logging.Logger;

@Aspect
@Component
public class CustomerManagementLoggingAspect {
	
	//set up the logger
	private Logger myLogger = Logger.getLogger(getClass());
	
	//setup the pointcut declaration for the controller package
	@Pointcut("execution (* com.CustomerManagement.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//setup the pointcut declaration for the Service package
	@Pointcut("execution (* com.CustomerManagement.service.*.*(..))")
	private void forServicePackage() {}
	
	
	//setup the pointcut declaration for the DAO package
	@Pointcut("execution (* com.CustomerManagement.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		//display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("----->> @Before: calling method: "+theMethod);
		
		//display the arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArgs : args) 
		{
			myLogger.info("----->> @Before: argument: "+tempArgs);
		}
	}
	
	
	//add @After advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
	
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);
				
		// display data returned
		myLogger.info("=====>> result: " + theResult);
	
	}

}
