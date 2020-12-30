package projetFilRouge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Tjlvt
 *
 */
public class UserInfoForm {

	private JFrame frame;

	// We first create lists with the names, coordinates, sizes of the Labels
	private static final String[] tab_stringLabel = { "USER INFORMATION", "iconeLabel", "Lastname", "Firstname", "City",
			"Username", "Email", "Password", "New Password", "Confirm New", "Password",
			"Please write a valid username : 6 to 15 alphanumeric characters and underscores",
			"The username has to start with a uppercase or lowercase alphabet", "Strong",
			"Medium", "Weak",
			"Please enter a password with at least 8 characters, at least one number, a mixture of both uppercase and",
			"lowercase letters, and inclusion of at least one special character, e.g., ! @ # ? ] (do no use < or >)",
			"The two passwords don't match", "background" };
	private static final int[] lCoordX = { 140, 198, 48, 48, 59, 45, 59, 45, 28, 30, 45, 80, 50, 393, 393, 393, 10,
			20, 150, 0 };
	private static final int[] lCoordY = { 126, 10, 170, 220, 270, 320, 370, 420, 470, 510, 535, 340, 349, 470,
			470, 470, 490, 500, 540, 0 };
	private static final int[] lLength = { 208, 80, 80, 80, 55, 94, 69, 94, 120, 120, 94, 358, 358, 50, 60, 50,
			458, 417, 150, 478 };
	private static final int[] lWidth = { 13, 112, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
			13, 553 };
	// We then create a table of labels
	private Label[] tab_label = new Label[tab_stringLabel.length];

	// We first create a list with the names of the textfields
	private static final String[] tab_stringText = { "Lastname", "Firstname", "City", "Username", "Email" };
	// We create a table of object textField from the TextField class
	private TextField[] tab_textField = new TextField[tab_stringText.length];

	// Same with buttons
	private static final String[] tab_stringButton = { "-", "X", "Modify Datas", "Modify Password", "Save Datas",
			"Save Password" };
	private static final int[] bCoordX = { 383, 430, 50, 280, 50, 280 };
	private static final int[] bCoordY = { 1, 1, 490, 490, 490, 490 };
	private static final int[] bLength = { 42, 42, 150, 150, 150, 150 };
	private static final int[] bWidth = { 27, 27, 21, 21, 21, 21 };
	private Button[] tab_button = new Button[tab_stringButton.length];

	// We create a table of object passwords from the PasswordField class
	private static final String[] tab_stringPassword = { "Password", "NewPassword", "ConfirmNewPassword" };
	private PasswordField[] tab_password = new PasswordField[tab_stringPassword.length];

	ValueNeeded object = new ValueNeeded();

	/**
	 * Create the application.
	 */
	public UserInfoForm() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		DragFrameListener dragListener= new DragFrameListener(frame);
		frame.addMouseListener(dragListener);
		frame.addMouseMotionListener(dragListener);

		object.setFrame(frame);

		JPanel forgotPanel = new JPanel();
		forgotPanel.setBounds(521, 0, 478, 553);
		frame.getContentPane().add(forgotPanel, BorderLayout.CENTER);
		forgotPanel.setLayout(null);
		forgotPanel.setFocusable(true);

		object.setPanel(forgotPanel);

		// We create all the textFields
		for (int j = 0; j < tab_textField.length; j++) {
			int y = 164 + j * 50;
			tab_textField[j] = new TextField(tab_stringText[j], 161, y);
			tab_textField[j].setEditable(false);
			tab_textField[j].setEnabled(false);
			forgotPanel.add(tab_textField[j]);
			switch (j) {
			case 4:
				tab_textField[4].setText(LoginForm.user.getEmail());
				break;
			case 3:
				tab_textField[3].setText(LoginForm.user.getUsername());
				break;
			case 2:
				tab_textField[2].setText(LoginForm.user.getCity());
				break;
			case 1:
				tab_textField[1].setText(LoginForm.user.getFirstName());
				break;
			case 0:
				tab_textField[0].setText(LoginForm.user.getLastName());
				break;
			}
		}

		object.setTextfield(tab_textField);

		// We create all the passwordfields
		for (int k = 0; k < tab_password.length; k++) {
			int y = 414 + k * 50;
			tab_password[k] = new PasswordField(tab_stringPassword[k], 161, y, object);
			tab_password[k].setEditable(false);
			tab_password[k].setEnabled(false);
			forgotPanel.add(tab_password[k]);
		}

		object.setPasswordField(tab_password);
		tab_password[1].addCaretListener(new PasswordCaret(object,13,14,15,1));

		// We create all the buttons
		for (int k = 0; k < tab_button.length; k++) {
			tab_button[k] = new Button(tab_stringButton[k], bCoordX[k], bCoordY[k], bLength[k], bWidth[k], object);
			if (k == 4 || k == 5) {
				tab_button[k].hide();
			}
			forgotPanel.add(tab_button[k]);
		}

		object.setButton(tab_button);

		// We create all the labels
		for (int i = 0; i < tab_label.length; i++) {
			tab_label[i] = new Label(tab_stringLabel[i], lCoordX[i], lCoordY[i], lLength[i], lWidth[i], object);
			if (i == 8 || i == 9 || i == 10) {
				tab_label[i].hide();
			} else if (i >= 11 && i <= 18) {
				tab_label[i].setFont(new Font("Rockwell Nova", Font.PLAIN, 8));
				tab_label[i].hide();
				if (i==16||i==17) {
					tab_label[i].setForeground(Color.DARK_GRAY);
				} else if (i==13) {
					tab_label[i].setForeground(Color.GREEN);
					tab_label[i].setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
				} else if (i==14) {
					tab_label[i].setForeground(Color.ORANGE);
					tab_label[i].setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
				} else if (i==15) {
					tab_label[i].setForeground(Color.RED);
					tab_label[i].setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
				} else {
					tab_label[i].setForeground(Color.RED);
				}
				
			}
			forgotPanel.add(tab_label[i]);
		}

		object.setLabel(tab_label);

	}
}
