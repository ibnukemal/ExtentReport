package com.demo.testing.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${myusername}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Value("${displayname}")
	private String displayName;
	
	@Value("${dashboard}")
	private String dashboard;
	
	@Value("${mytitle}")
	private String postTitle;

	public String getBrowser() {
		return browser;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public String getDashboard() {
		return dashboard;
	}
	
	public String getPostTitle() {
		return postTitle;
	}
	
}
