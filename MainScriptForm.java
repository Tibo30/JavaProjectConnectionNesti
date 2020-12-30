package projetFilRouge;

import java.awt.EventQueue;

public class MainScriptForm {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm login = new LoginForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
