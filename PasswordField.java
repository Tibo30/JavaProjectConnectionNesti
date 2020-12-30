package projetFilRouge;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
/**
 * 
 * @author Tjlvt
 *
 */
public class PasswordField extends JPasswordField{
	private String nameField;
	/**
	 * This is the constructor for the PasswordFields class
	 * @param name
	 * @param x
	 * @param y
	 * @param object
	 */
	public PasswordField(String name, int x, int y,ValueNeeded object) {
		// TODO Auto-generated constructor stub
		if (name.equals("ConfirmPasswordField")) {
			this.nameField="PasswordField";
		} else if (name.equals("Password")) {
			this.nameField=name;
			this.setEnabled(false);
			this.setEditable(false);
		} else if (name.equals("NewPassword")||name.equals("ConfirmNewPassword")) {
			this.nameField="";
			this.hide();
		}
		
		else {
			this.nameField=name;
		}
		this.setBounds(x, y,226,27);
		this.setText(nameField);
		this.setColumns(10);
		this.setForeground(new Color(192, 192, 192));
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
			
		// We add a focus listener for all the password fields
		this.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (String.valueOf(getPassword()).equals(nameField)) {
					setText("");
					setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (String.valueOf(getPassword()).equals("")) {
					setText(nameField);
					setForeground(new Color(192, 192, 192));
				}
			}
		});
	}
}
