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
public class LoginForm {

	private JFrame frame;
	public static User user;
	ValueNeeded object = new ValueNeeded();
	private TextField[] tab_textField = new TextField[1];
	// We first create lists with the names, coordinates, sizes of the Labels
	private static final String[] tab_stringLabel = { "iconeLabel","Log In", "Don't have an account ?", "lock", "user",
			"background" };
	private static final int[] lCoordX = { 115,115,40,0,0,0 };
	private static final int[] lCoordY = { 36,149,417,0,0,0};
	private static final int[] lLength = { 80,80,123,16,16,310 };
	private static final int[] lWidth = { 112,27,13,27,27,510 };
	// We then create a table of objects label
	private Label[] tab_label = new Label[tab_stringLabel.length];
	
	// Same with buttons
		private static final String[] tab_stringButton = { "-", "X", "Login", "Forgot Password ?", "Register Here !" };
		private static final int[] bCoordX = { 210,260,115,179,193 };
		private static final int[] bCoordY = { 1,1,344,295,413 };
		private static final int[] bLength = { 42,42,85,102,85 };
		private static final int[] bWidth = { 27,27,21,21,21 };
		private Button[] tab_button = new Button[tab_stringButton.length];
	
		private PasswordField[] tab_password = new PasswordField[1];
	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 310, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		DragFrameListener dragListener= new DragFrameListener(frame);
		frame.addMouseListener(dragListener);
		frame.addMouseMotionListener(dragListener);
		
		object.setFrame(frame);

		JPanel signInPanel = new JPanel();
		frame.getContentPane().add(signInPanel, BorderLayout.CENTER);
		signInPanel.setBounds(0, 0, 310, 510);
		signInPanel.setLayout(null);
		signInPanel.setFocusable(true);
		JPanel userPanel = new JPanel();
		userPanel.setBackground(Color.WHITE);
		userPanel.setBounds(35, 207, 243, 27);
		signInPanel.add(userPanel);
		userPanel.setLayout(null);
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(Color.WHITE);
		passwordPanel.setBounds(35, 258, 243, 27);
		signInPanel.add(passwordPanel);
		passwordPanel.setLayout(null);

		TextField usernameTextField = new TextField("Username", 17, 0);
		usernameTextField.setBorder(null);
		usernameTextField.setFont(new Font("Rockwell Nova", Font.PLAIN, 15));
		tab_textField[0]=usernameTextField;
		userPanel.add(usernameTextField);
		
		object.setTextfield(tab_textField);

		PasswordField passwordField = new PasswordField("PasswordField",17,0,object);
		passwordPanel.add(passwordField);
		passwordField.setFont(new Font("Rockwell Nova", Font.PLAIN, 15));
		passwordField.setBorder(null);
		tab_password[0]=passwordField;
		
		object.setPasswordField(tab_password);

		// We create all the buttons
		for (int k = 0; k < tab_button.length; k++) {
			tab_button[k] = new Button(tab_stringButton[k], bCoordX[k], bCoordY[k], bLength[k], bWidth[k], object);
			signInPanel.add(tab_button[k]);
		}
		
		object.setButton(tab_button);

		// We create all the labels
		for (int i = 0; i < tab_label.length; i++) {
			tab_label[i] = new Label(tab_stringLabel[i], lCoordX[i], lCoordY[i], lLength[i], lWidth[i],object);
			
			if (i==3) {
				passwordPanel.add(tab_label[i]);
			} else if (i==4) {
				userPanel.add(tab_label[i]);
			} else {
				signInPanel.add(tab_label[i]);
			}
		}
		
		object.setLabel(tab_label);
	}
}
