package projetFilRouge;
/**
 * 
 * @author Tjlvt
 *
 */
public class User{
	
	String lastName;
	String firstName;
	String city;
	String email;
	String username;
	String password;
	
	/**
	 * Constructor
	 */
	public User(String lastName,String firstName, String city, String username, String email, String password) {
		this.lastName=lastName;
		this.firstName=firstName;
		this.city=city;
		this.username=username;
		this.email=email;
		this.password=password;;
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
