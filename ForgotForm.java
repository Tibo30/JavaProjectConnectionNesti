package projetFilRouge;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Tjlvt
 *
 */
public class ForgotForm {

	private JFrame frame;
	ValueNeeded object = new ValueNeeded();
	private TextField[] tab_textField = new TextField[1];
	// We create lists of the names, coordinates, size of the labels
	private static final String[] tab_stringLabel = { "iconeLabel", "Please enter your email adress",
			"so we can send you your password", "background" };
	private static final int[] lCoordX = { 115, 40, 32, 0 };
	private static final int[] lCoordY = { 36, 165, 215, 0 };
	private static final int[] lLength = { 80, 254, 270, 310 };
	private static final int[] lWidth = { 112, 35, 35, 495 };
	// Then we create a table of objects label
	private Label[] tab_label = new Label[tab_stringLabel.length];

	// Same with the buttons
	private static final String[] tab_stringButton = { "Send Password", "Login Page", "-", "X" };
	private static final int[] bCoordX = { 97, 166, 210, 260 };
	private static final int[] bCoordY = { 357, 434, 1, 1 };
	private static final int[] bLength = { 134, 134, 42, 42 };
	private static final int[] bWidth = { 21, 21, 27, 27 };
	private Button[] tab_button = new Button[tab_stringButton.length];

	/**
	 * Create the application.
	 */

	public ForgotForm() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 310, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		DragFrameListener dragListener= new DragFrameListener(frame);
		frame.addMouseListener(dragListener);
		frame.addMouseMotionListener(dragListener);
		
		object.setFrame(frame);

		JPanel forgotPanel = new JPanel();
		forgotPanel.setBounds(0, 508, 310, 495);
		frame.getContentPane().add(forgotPanel, BorderLayout.CENTER);
		forgotPanel.setLayout(null);
		forgotPanel.setFocusable(true);		

		TextField emailTextField = new TextField("***********@******.com", 51, 280);
		emailTextField.setFont(new Font("Rockwell Nova", Font.PLAIN, 15));
		tab_textField[0] = emailTextField;
		forgotPanel.add(emailTextField);

		object.setTextfield(tab_textField);

		// We create all the buttons
		for (int i = 0; i < tab_button.length; i++) {
			tab_button[i]=new Button(tab_stringButton[i],bCoordX[i], bCoordY[i], bLength[i], bWidth[i], object);
			forgotPanel.add(tab_button[i]);
		}
		
		object.setButton(tab_button);

		// We create all the labels.
		for (int j = 0; j < tab_label.length; j++) {
			tab_label[j] = new Label(tab_stringLabel[j], lCoordX[j], lCoordY[j], lLength[j], lWidth[j],object);
			forgotPanel.add(tab_label[j]);
		}
		object.setLabel(tab_label);

	}
}
