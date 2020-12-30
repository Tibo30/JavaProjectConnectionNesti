package projetFilRouge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import TP12.MyConnexion;

public class MyConnexionNesti {
	
	static Connection accessDataBase = null;
	private String url;
	private String login;
	private String mdp;
	private String bdd;

	/**
	 * Testons la connexion
	 * 
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		openConnection();
		testConnection();
		closeConnection();
	}
	*/
	
	public MyConnexionNesti(String url, String login, String mdp, String bdd) {
		setUrl("jdbc:mysql://"+url+"/"+bdd);
		setLogin(login);
		setMdp(mdp);
	}

	/**
	 * Connection to database NESTI
	 * @throws Exception 
	 * 
	 * @throws SQLException
	 */
	public void openConnection() throws Exception {
		try {
			System.out.println("try to connect");
			// we add the parameters
			accessDataBase = DriverManager.getConnection(getUrl(), getLogin(), getMdp());
		} catch (SQLException ex) {
			throw new Exception("Erreur connexion");
		}
	}

	/**
	 * True if connection is successful
	 *
	 * @return
	 * @throws Exception 
	 */
	public boolean testConnection() throws Exception {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			throw new Exception("Erreur test");
		}
		return flag;
	}

	public void closeConnection() throws Exception {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				throw new Exception("Erreur fermeture");
			}
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getBdd() {
		return bdd;
	}

	public void setBdd(String bdd) {
		this.bdd = bdd;
	}
}
