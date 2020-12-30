package projetFilRouge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Tjlvt
 *
 */
public class Check {


	/**
	 * This method check if the password is a valid password according to some terms
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		// Regex to check valid password.
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[!?-@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);
		// If the password is empty
		// return false
		if (password == null) {
			return false;
		}
		// Pattern class contains matcher() method
		// to find matching between given password
		// and regular expression.
		Matcher m = p.matcher(password);
		// Return if the password
		// matched the ReGex
		return m.matches();
	}

	/**
	 * This method check if the email is a valid email according to some terms
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		// Regex to check valid email.
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		// Compile the ReGex
		Pattern pattern = Pattern.compile(regex);
		// If the email is empty
		// return false
		if (email == null) {
			return false;
		}
		// Pattern class contains matcher() method
		// to find matching between given email
		// and regular expression.
		Matcher m = pattern.matcher(email);
		// Return if the email
		// matched the ReGex
		return m.matches();
	}
	
	/**
	 * This method check if the username is a valid username according to some terms
	 * @param username
	 * @return
	 */
	public static boolean isValidUsername(String username) {
		// Regex to check valid username.
		String regex = "^[A-Za-z]\\w{5,14}$";
		// Compile the ReGex
		Pattern pattern = Pattern.compile(regex);
		// If the email is empty
		// return false
		if (username == null) {
			return false;
		}
		// Pattern class contains matcher() method
		// to find matching between given username
		// and regular expression.
		Matcher m = pattern.matcher(username);
		// Return if the username
		// matched the ReGex
		return m.matches();
	}
	
	/**
	 * Check the strength of the password
	 * @param password
	 * @return
	 */
	public static double strengthPassword(String password) {
		int N=0;
		double strength=0;
		if (password.matches("(?=.*[0-9]).*")) {
			N+=10;
		}
		if (password.matches("(?=.*[a-z]).*")) {
			N+=26;
		}
		if (password.matches("(?=.*[A-Z]).*")) {
			N+=26;
		}
		if (password.matches("(?=.*[!?-@#$%^&+=]).*")) {
			N+=11;
		}
		strength=Math.round(password.length()*Math.log(N)/Math.log(2));
		return strength;
	}
	
}
