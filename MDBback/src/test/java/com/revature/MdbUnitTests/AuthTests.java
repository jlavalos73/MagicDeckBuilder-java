package com.revature.MdbUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.services.SecurityService;

public class AuthTests {
	
	private static SecurityService s;

	/*
	 * This method will be invoked before the test class is instantiated.
	 * This is primarily used in order to set up the global test environment.
	 */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s = new SecurityService();
	}

	/*
	 * This method will be invoked after the entire test class has finished
	 * running its tests.
	 * This is primarily used to clean up the global test environment.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		s = null;
	}

	/*
	 * This method will be invoked before each individual test case.
	 * This is primarily used to set up specific test environments, or perhaps to rest
	 * the test environment.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/*
	 * This method will be invoked after each individual test case.
	 * This is primarily used to reset the test environment.
	 */
	@After
	public void tearDown() throws Exception {

	}

	
	@Test
	public void testpassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String testPass = "password";
		String hashedTestPass = s.hashPassword(testPass);
		String hashedTestPassAgain = s.hashPassword(testPass);
		
		System.out.println(hashedTestPass + " vs. " + hashedTestPassAgain);
		
		assertNotEquals(testPass, hashedTestPass);
		
		
		assertFalse(s.checkPassword(hashedTestPass, hashedTestPassAgain));
		assertTrue(s.checkPassword(testPass, hashedTestPassAgain));
		
		
	}
	
	
	
	
	
}
