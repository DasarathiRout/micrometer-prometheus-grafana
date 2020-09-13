package org.drout.spring.web.model;

public class AuthenticateRequest {
	private String userName;
	private String passKey;

	public AuthenticateRequest() {
		// FOR JAVA SERIALIZATION USES
	}

	public AuthenticateRequest(String userName, String passKey) {

		this.userName = userName;
		this.passKey = passKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassKey() {
		return passKey;
	}

	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}

	public String toString() {
		return String.format("Authenticate Request Model [Name=%s , Key=%s]", userName, passKey);
	}

}
