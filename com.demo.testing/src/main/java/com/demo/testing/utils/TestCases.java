package com.demo.testing.utils;

public enum TestCases {


	T1("Testing login"),
	T2("Testing dashboard"),
	T3("Testing post");
	
	private String testName;
	
	TestCases(String value) {
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
