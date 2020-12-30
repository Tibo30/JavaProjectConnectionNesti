package projetFilRouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryUser extends MyConnexionNesti {
	

	public QueryUser(String url, String login, String mdp, String bdd) {
		super(url, login, mdp, bdd);
	}

	/**
	 * This method is used to create the object User when the user click on Login by
	 * taking all the information from the dataBase
	 * 
	 * @param username
	 * @return
	 * @throws Exception 
	 */
	public User createUserInfo(String username) throws Exception {
		openConnection();
		User us = null;
		ResultSet rs;
		try {
			String query = "SELECT Lastname, Firstname, City, Username, Email, Password FROM user WHERE (Email=? OR Username=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, username);
			declaration.setString(2, username);
			rs = declaration.executeQuery();
			/* Récupération des données */
			if (rs.next()) {
				us = new User(rs.getString("Lastname"), rs.getString("Firstname"), rs.getString("City"),
						rs.getString("Username"), rs.getString("Email"), rs.getString("Password"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return us;
	}

	/**
	 * This method is used to create a new User in the database, during the register
	 * process
	 * 
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	public boolean createPrepared(User user) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `user`(`LastName`,`FirstName`,`City`,`Username`,`Email`,`Password`) VALUES (?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()); // this is used to encrypt the password
			declaration.setString(1, user.getLastName());
			declaration.setString(2, user.getFirstName());
			declaration.setString(3, user.getCity());
			declaration.setString(4, user.getUsername());
			declaration.setString(5, user.getEmail());
			declaration.setString(6, pw_hash);
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	/**
	 * This method is used to update a value in the database
	 * @param valueChanged
	 * @param newValue
	 * @param email
	 * @return
	 * @throws Exception 
	 */
	public boolean updatePrepared(String valueChanged, String newValue, String email) throws Exception {
		openConnection();
		boolean flag = false;
		String pw_hash = BCrypt.hashpw(newValue, BCrypt.gensalt());
		try {
			String query = "";
			switch (valueChanged) {
			case "Lastname":
				query = "UPDATE user SET Lastname=? WHERE Email=?";
				break;
			case "Firstname":
				query = "UPDATE user SET Firstname=? WHERE Email=?";
				break;
			case "City":
				query = "UPDATE user SET City=? WHERE Email=?";
				break;
			case "Username":
				query = "UPDATE user SET Username=? WHERE Email=?";
				break;
			case "Password":

				query = "UPDATE user SET Password=? WHERE Email=?";
				break;
			}
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, newValue);
			declaration.setString(2, email);
			if (valueChanged.equals("Password")) {
				declaration.setString(1, pw_hash);
			}
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	/**
	 * This method check if the username is already taken
	 * 
	 * @param username
	 * @return
	 * @throws Exception 
	 */
	public boolean checkUsername(String username) throws Exception {
		openConnection();
		PreparedStatement declaration;
		ResultSet rs;
		boolean checkUser = false;
		String query = "SELECT * FROM `user` WHERE `Username` =?";

		try {
			declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, username);

			rs = declaration.executeQuery();

			if (rs.next()) { // check if there is a row in the query result
				checkUser = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
		}
		closeConnection();
		return checkUser;
	}

	/**
	 * This method check if the email is already taken
	 * 
	 * @param email
	 * @return
	 * @throws Exception 
	 */
	public boolean checkEmail(String email) throws Exception {
		openConnection();
		PreparedStatement declaration;
		ResultSet rs;
		boolean checkEmail = false;
		String query = "SELECT * FROM `user` WHERE `Email` =?";

		try {
			declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, email);

			rs = declaration.executeQuery();

			if (rs.next()) { // check if there is a row in the query result
				checkEmail = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
		}
		closeConnection();
		return checkEmail;
	}

	/**
	 * This method check if the username/email and password match
	 * 
	 * @param emailUsername
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public boolean checkPassword(String emailUsername, String password) throws Exception {
		openConnection();
		PreparedStatement declaration;
		ResultSet rs;
		boolean checkPassword = false;
		String query = "SELECT `Password` FROM `user` WHERE (`Email` =? OR `Username` =?)";

		try {
			declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, emailUsername);
			declaration.setString(2, emailUsername);

			rs = declaration.executeQuery();

			if (rs.next()) { // check if there is a row in the query result
				if (BCrypt.checkpw(password, rs.getString("Password"))) {
					checkPassword = true;

				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
		}
		closeConnection();
		return checkPassword;
	}

}
