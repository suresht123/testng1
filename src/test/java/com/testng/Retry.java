package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class Retry implements IRetryAnalyzer {
	int a =1;
	int b =2;
	
	public boolean retry(ITestResult result) {
		 if (a<b){
			 a++;
			 System.out.println("failed method:" +result.getName());
			 return true;
		 }
		
		return false;
	}
	
	

}
