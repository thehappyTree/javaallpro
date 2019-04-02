package com.tutorialspoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
	
	  public Logging() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	  @Pointcut("execution(* com.tutorialspoint.*.*(..))")
	  public void selectAll() {};
	  
	   @Before("selectAll()")
	   public void beforeAdvice(){
	      System.out.println("Going to setup student profile.");
	   }
	   /** 
	    * This is the method which I would like to execute
	    * after a selected method execution.
	    */
	   public void afterAdvice(){
	      System.out.println("Student profile has been setup.");
	   }
	   /** 
	    * This is the method which I would like to execute
	    * when any method returns.
	    */
	   public void afterReturningAdvice(Object retVal){
	      System.out.println("Returning:" + retVal.toString() );
	   }
	   /**
	    * This is the method which I would like to execute
	    * if there is an exception raised.
	    */
	   public void AfterThrowingAdvice(IllegalArgumentException ex){
	      System.out.println("There has been an exception: " + ex.toString());   
	   }  
}
