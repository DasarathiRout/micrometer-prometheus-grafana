package org.drout.spring.web.model;

public class AuthenticateResponse {
	private String jwtToken;

	public AuthenticateResponse() {
		// FOR JAVA SERIALIZATION USES
	}

	public AuthenticateResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String toString() {
		return String.format("Authenticate Response Model [JWT= %s]", this.jwtToken);
	}

}
