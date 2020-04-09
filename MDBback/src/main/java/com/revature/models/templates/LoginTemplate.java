package com.revature.models.templates;

import java.util.Objects;

/**
 * This is a class for passing emails and passwords in the authentication
 * process
 * 
 * @author Jonathan Conner	<jonathan.g.conner@gmail.com>
 */
public class LoginTemplate {

	private String email;
	private String password;

	public LoginTemplate() {
		super();
	}
	
	/**
	 * @param email
	 * @param password
	 */
	public LoginTemplate(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LoginTemplate)) {
			return false;
		}
		LoginTemplate other = (LoginTemplate) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "LoginTemplate [email=" + email + ", password=" + password + "]";
	}

}
