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
public class RegisterForm {

	private JFrame frame;
	// We first create lists with the names, coordinates, sizes of the Labels
	private static final String[] tab_stringLabel = { "iconeLabel", "Lastname", "Firstname", "City", "Username *",
			"Please write a valid username : 6 to 15 alphanumeric characters and underscores",
			"The username has to start with a uppercase or lowercase alphabet", "Email *", "Please write a valid email",
			"Password *", "Strong", "Medium", "Weak",
			"Please enter a password with at least 8 characters, at least one number, a mixture of both uppercase and",
			"lowercase letters, and inclusion of at least one special character, e.g., ! @ # ? ] (do no use < or >)",
			"Confirm Password *", "The two passwords don't match", "background" };
	private static final int[] lCoordX = { 198,48, 48, 59, 45, 80, 50, 59, 145, 45, 393, 393, 393, 10, 20, 10, 150,0 };
	private static final int[] lCoordY = { 10,138, 188, 238, 288, 309, 319, 338, 361, 388, 389, 389, 389, 408, 420, 438,
			460,0 };
	private static final int[] lLength = { 80,80, 80, 55, 94, 358, 358, 69, 136, 94, 50, 60, 50, 458, 417, 150, 150,478 };
	private static final int[] lWidth = { 112,13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,553 };
	// Then we create a table of objects label
	private Label[] tab_label = new Label[tab_stringLabel.length];
	
	// We create a list with the names of the textfields
	private static final String[] tab_stringText = { "Lastname", "Firstname", "City", "Username", "Email" };
	// We create a table of object textField from the TextField class
	private TextField[] tab_textField = new TextField[tab_stringText.length];
	
	// We create lists with the names, coordinates, sizes of the buttons
	private static final String[] tab_stringButton = { "<","-","X","Register" };
	private static final int[] bCoordX = { 3,383,430,198 };
	private static final int[] bCoordY = { 1,1,1,490 };
	private static final int[] bLength = { 42,42,42,85 };
	private static final int[] bWidth = { 27,27,27,21 };
	// Then we create a table of objects buttons
	private Button[] tab_button = new Button[tab_stringButton.length];
	
	// We create a table of passwords
	private PasswordField[] tab_password = new PasswordField[2];
	ValueNeeded object = new ValueNeeded();

	/**
	 * Create the application.
	 */
	public RegisterForm() {
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

		JPanel registerPanel = new JPanel();
		registerPanel.setBounds(521, 0, 478, 553);
		frame.getContentPane().add(registerPanel, BorderLayout.CENTER);
		registerPanel.setLayout(null);
		registerPanel.setFocusable(true);

		// We create all the TextFields
		for (int i = 0; i < tab_stringText.length; i++) {
			int y = 132 + i * 50;
			tab_textField[i] = new TextField(tab_stringText[i], 161, y);
			registerPanel.add(tab_textField[i]);
		}
		
		// Then we create all the PasswordFields.
		PasswordField passwordField = new PasswordField("PasswordField", 161, 382,object);
		registerPanel.add(passwordField);
		tab_password[0]=passwordField;
		PasswordField confirmPasswordField = new PasswordField("ConfirmPasswordField", 161, 432,object);
		registerPanel.add(confirmPasswordField);
		tab_password[1]=confirmPasswordField;
		
		object.setPasswordField(tab_password);
		
		// We create all the Buttons
		for (int k = 0; k < tab_button.length; k++) {
			tab_button[k]= new Button(tab_stringButton[k],bCoordX[k], bCoordY[k], bLength[k], bWidth[k], object);
			registerPanel.add(tab_button[k]);
		}
		
		object.setTextfield(tab_textField);
		
		// We create all the Labels
				for (int j = 0; j < tab_stringLabel.length; j++) {
					tab_label[j] = new Label(tab_stringLabel[j], lCoordX[j], lCoordY[j], lLength[j], lWidth[j],object);
					tab_label[j].hide();
					if (j == 5 || j == 6 || j == 8 || j == 16) {
						tab_label[j].setForeground(Color.RED);
						tab_label[j].setFont(new Font("Rockwell Nova", Font.PLAIN, 8));
					} else if (j == 10) {
						tab_label[j].setForeground(Color.GREEN);
					} else if (j == 11) {
						tab_label[j].setForeground(Color.ORANGE);
					} else if (j == 12) {
						tab_label[j].setForeground(Color.RED);
					} else if (j == 13 || j == 14) {
						tab_label[j].setFont(new Font("Rockwell Nova", Font.PLAIN, 8));
						tab_label[j].show();
					} else {
						tab_label[j].show();
					}
					registerPanel.add(tab_label[j]);
				}

		object.setLabel(tab_label);

		// We add a CaretListener to the passwordField.
		passwordField.addCaretListener(new PasswordCaret(object,10,11,12,0));
		
	}
}