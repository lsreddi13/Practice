package com.test;

import org.testng.annotations.Test;

public class DemoVars {
	
	//global var
	String Toolname = "selenium";
	
	String courseName;
	public void test() {
		
		
		 courseName = "Testing tools";
		
		
		
	}
	
	
	@Test
	public void testCase1() {
		System.out.println(Toolname);
		
		System.out.println(courseName);
	}
	

}


