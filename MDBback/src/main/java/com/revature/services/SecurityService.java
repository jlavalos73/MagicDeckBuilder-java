/**
 * 
 */
package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.security.PBKDF2Hasher;

/**
 * @author Jonathan Conner <jonathan.g.conner@gmail.com>
 *
 */
@Service
public class SecurityService {

	/**
	 * SecurityService constructor
	 * 
	 * @param hasher
	 */
	public SecurityService() {
		super();
	}

	public static String hashPassword(String raw) {
		PBKDF2Hasher hasher = new PBKDF2Hasher(20);
		char[] ch = raw.toCharArray();
		System.out.println(ch.length);
		System.out.println("the char array" + ch);
		System.out.println("the char array [0]" + ch[0]);

		return hasher.hash(ch); // the hashed password
	}

	public boolean checkPassword(String raw, String hashed) {

		PBKDF2Hasher hasher = new PBKDF2Hasher();
		return hasher.checkPassword(raw.toCharArray(), hashed);// should be true

	}

}
