package projetFilRouge;

import junit.framework.TestCase;

public class MyConnexionNestiTest extends TestCase {
	MyConnexionNesti connexion;
	
	public void testOpenConnexion() throws Exception{
		connexion.openConnection();
	}
	
	public void testTestConnexion() throws Exception{
		connexion.testConnection();
	}
	
	public void testCloseConnexion() throws Exception{
		connexion.closeConnection();;
	}
	
	@Override
	protected void setUp() throws Exception{
		connexion= new MyConnexionNesti("127.0.0.1","root","","nesti");
	}

}
