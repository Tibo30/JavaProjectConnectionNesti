package projetFilRouge;

import junit.framework.TestCase;

public class CheckTest extends TestCase {
	private Check check;

	public void testValidPassword() {
		assertEquals(true, check.isValidPassword("testE30!deztez"));

	}

	public void testValidEmail() {
		assertEquals(true, check.isValidEmail("test@hotmail.com"));

	}
	
	public void testValidUsername() {
		assertEquals(true, check.isValidUsername("test30!"));

	}

}
