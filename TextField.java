package projetFilRouge;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
/**
 * 
 * @author Tjlvt
 *
 */
public class TextField extends JTextField {
	private String nameField;
	/**
	 * This is the constructor of the TextField class
	 * @param name
	 * @param x
	 * @param y
	 */
	public TextField(String name, int x, int y) {
		// TODO Auto-generated constructor stub
		this.nameField=name;
		this.setBounds(x, y,226,27);
		this.setText(nameField);
		this.setColumns(10);
		this.setForeground(new Color(192, 192, 192));
		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
			
		// We add a focus listener for all the textfields
		this.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (getText().equals(nameField)) {
					setText("");
					setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (getText().equals("")) {
					setText(nameField);
					setForeground(new Color(192, 192, 192));
				}
			}
		});
		
	}

}
