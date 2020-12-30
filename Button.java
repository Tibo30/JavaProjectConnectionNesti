package projetFilRouge;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Tjlvt
 *
 */
public class Button extends JButton {
	private String nameField;
/**
 * This is the constructor for the Button class
 * @param name
 * @param x
 * @param y
 * @param L
 * @param l
 * @param object
 */
	public Button(String name, int x, int y, int L, int l, ValueNeeded object) {
		this.nameField = name;
		this.setBounds(x, y, L, l);
		this.setText(nameField);
		if (name.equals("-") || name.equals("X") || name.equals("<") || name.equals("Forgot Password ?")
				|| name.equals("Register Here !")) {
			this.setContentAreaFilled(false);
			this.setOpaque(false);
			this.setBorder(new LineBorder(Color.DARK_GRAY));
			if (name.equals("X")) {
				this.setFont(new Font("Rockwell Nova", Font.BOLD, 17));
			} else if (name.equals("Forgot Password ?") || name.equals("Register Here !")) {
				this.setBorderPainted(false);
				this.setForeground(Color.DARK_GRAY);
				if (name.equals("Forgot Password ?")) {
					this.setFont(new Font("Rockwell Nova", Font.PLAIN, 10));
				} else {
					this.setFont(new Font("Rockwell Nova", Font.BOLD, 10));
				}
			} else {
				this.setFont(new Font("Rockwell Nova", Font.BOLD, 30));
			}
		} else if (name.equals("Login") || name.equals("Register") || name.equals("Send Password")
				|| name.equals("Login Page") || name.equals("Modify Datas") || name.equals("Modify Password")
				|| name.equals("Save Datas")|| name.equals("Save Password")) {
			this.setBorder(BorderFactory.createBevelBorder(0));
			this.setFont(new Font("Rockwell Nova", Font.PLAIN, 15));
			this.setForeground(new Color(255, 255, 255));
			this.setBackground(new Color(72, 209, 204));
		}
		this.addActionListener(new ButtonListener(name, object)); // We add actionListener to all the buttons
	}

}
