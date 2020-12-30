package projetFilRouge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * 
 * @author Tjlvt
 *
 */
public class Label extends JLabel {
	private String nameField;
	ValueNeeded object;
/**
 * This is the constructor of the Label class
 * @param name
 * @param x
 * @param y
 * @param L
 * @param l
 * @param object
 */
	public Label(String name, int x, int y, int L, int l, ValueNeeded object) {
		this.nameField = name;
		this.object = object;
		this.setBounds(x, y, L, l);
		this.setText(nameField);
		this.setForeground(Color.DARK_GRAY);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		this.setBounds(x, y, L, l);
		if (name.equals("USER INFORMATION")||name.equals("Log In")) {
			this.setFont(new Font("Rockwell Nova", Font.PLAIN, 18));
		} else if (name.equals("iconeLabel")) {
			Image img = new ImageIcon(RegisterForm.class.getResource("/projetFilRouge/Logo.png")).getImage();
			Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
			this.setIcon(new ImageIcon(newimg));
			this.setText("");
		} else if (name.equals("background")) {
			this.setIcon(new ImageIcon(RegisterForm.class.getResource("/projetFilRouge/login_background.jpg")));
			this.setText("");
		} else if (name.equals("lock")) {
			this.setText("");
			this.setBackground(Color.WHITE);
			this.setIcon(new ImageIcon(LoginForm.class.getResource("/projetFilRouge/locked-padlock.png")));
		} else if (name.equals("user")) {
			this.setText("");
			this.setBounds(0, 0, 16, 27);
			this.setBackground(Color.WHITE);
			this.setIcon(new ImageIcon(LoginForm.class.getResource("/projetFilRouge/user.png")));
		} else if (name.equals("Don't have an account ?")) {
			this.setFont(new Font("Rockwell Nova", Font.PLAIN, 10));
		} else if (name.equals("Please enter your email adress")||name.equals("so we can send you your password")) {
			this.setFont(new Font("Rockwell Nova", Font.PLAIN, 15));
		}
	}

}
