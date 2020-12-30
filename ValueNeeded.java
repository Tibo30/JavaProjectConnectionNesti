package projetFilRouge;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Tjlvt
 *
 */
public class ValueNeeded {
	JFrame frame;
	Label[] label;
	TextField[] textfield;
	PasswordField passwordField[];
	Button[] button;
	JPanel panel;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Label[] getLabel() {
		return label;
	}

	public void setLabel(Label[] label) {
		this.label = label;
	}

	public TextField[] getTextfield() {
		return textfield;
	}

	public void setTextfield(TextField[] textfield) {
		this.textfield = textfield;
	}
	
	public PasswordField[] getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField[] passwordField) {
		this.passwordField = passwordField;
	}

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
