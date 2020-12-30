package projetFilRouge;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * 
 * @author Tjlvt
 *
 */
public class ButtonListener implements ActionListener {
	String text;
	ValueNeeded object;
	private QueryUser queryLogin = new QueryUser("127.0.0.1", "root", "", "nesti");

	/**
	 * This is the constructor for the ButtonListener class
	 * 
	 * @param name
	 * @param object
	 */
	public ButtonListener(String name, ValueNeeded object) {
		this.text = name;
		this.object = object;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {

		switch (text) {
		case "X":
			System.exit(1);
			break;
		case "-":
			object.getFrame().setState(object.getFrame().ICONIFIED);
			break;
		case "<":
			LoginForm login = new LoginForm(); // Change frame to Login frame
			object.getFrame().setVisible(false);
			break;
		case "Register Here !":
			RegisterForm register = new RegisterForm(); // Change frame to Register frame
			object.getFrame().setVisible(false);
			break;
		case "Forgot Password ?":
			ForgotForm forgot = new ForgotForm(); // Change frame to ForgotPassword frame
			object.getFrame().setVisible(false);
			break;
		case "Login":

			// check if the password match the username/email
			try {
				if (queryLogin.checkPassword(object.getTextfield()[0].getText(),
						String.valueOf(object.getPasswordField()[0].getPassword()))) {
					JOptionPane.showMessageDialog(null, "Connection successful");
					LoginForm.user = queryLogin.createUserInfo(object.getTextfield()[0].getText());
					UserInfoForm info = new UserInfoForm(); // Change frame to UserInfo frame
					object.getFrame().setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Login Page":
			LoginForm forgotLogin = new LoginForm(); // Change frame to Login frame
			object.getFrame().setVisible(false);
			break;
		case "Send Password":

			// Check if the email is in the database
			try {
				if (queryLogin.checkEmail(object.getTextfield()[0].getText())) {
					JOptionPane.showMessageDialog(null,
							"An Email has been sent to your email adress with your password");
				} else {
					JOptionPane.showMessageDialog(null, "There is no account with this email");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Modify Datas":
			// this loop is used to be able to edit the textFields when click on modify
			// datas button
			for (int i = 0; i < object.getTextfield().length - 1; i++) {
				object.getTextfield()[i].setEditable(true);
				object.getTextfield()[i].setEnabled(true);
				object.getTextfield()[i].setForeground(Color.black);
			}
			object.getButton()[4].show(); // show the Save Datas button
			object.getButton()[2].hide(); // hide the Modify Datas button
			object.getButton()[3].setEnabled(false); // set false enable for the modify password button
			break;
		case "Modify Password":
			object.getPasswordField()[0].setEditable(true); // used to edit the passwordFields
			object.getPasswordField()[0].setEnabled(true);
			object.getPasswordField()[1].setEditable(true);
			object.getPasswordField()[1].setEnabled(true);
			object.getPasswordField()[2].setEditable(true);
			object.getPasswordField()[2].setEnabled(true);
			object.getPasswordField()[0].setForeground(Color.black);
			object.getButton()[5].show(); // show the Save Password button
			object.getButton()[3].hide(); // hide the Modify Password button
			object.getFrame().setBounds(100, 100, 478, 710);
			object.getPanel().setBounds(521, 0, 478, 710);
			object.getLabel()[19].setBounds(0, 0, 478, 710);
			object.getButton()[2].setBounds(50, 622, 150, 21);
			object.getButton()[3].setBounds(280, 622, 150, 21);
			object.getButton()[4].setBounds(50, 622, 150, 21);
			object.getButton()[5].setBounds(280, 622, 150, 21);
			object.getPasswordField()[1].show(); // show the newPassword Field
			object.getPasswordField()[2].show(); // show the confirmNewPassword Field
			object.getLabel()[8].show(); // show the labels about new password
			object.getLabel()[9].show();
			object.getLabel()[10].show();
			object.getLabel()[16].show();
			object.getLabel()[17].show();
			object.getButton()[2].setEnabled(false); // set false enable for the modify datas button
			break;
		case "Save Datas":
			object.getButton()[2].show();
			object.getButton()[4].hide();
			object.getButton()[3].setEnabled(true);
			object.getLabel()[11].hide(); // infoUsernameLabel
			object.getLabel()[12].hide(); // infoUsername2Label
			// if the user changes the LastName
			if (!LoginForm.user.getLastName().equals(object.getTextfield()[0].getText())) {
				try {
					queryLogin.updatePrepared("Lastname", object.getTextfield()[0].getText(),
							object.getTextfield()[4].getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// if the user changes the FirstName
			if (!LoginForm.user.getFirstName().equals(object.getTextfield()[1].getText())) {
				try {
					queryLogin.updatePrepared("Firstname", object.getTextfield()[1].getText(),
							object.getTextfield()[4].getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// if the user changes the City
			if (!LoginForm.user.getCity().equals(object.getTextfield()[2].getText())) {
				try {
					queryLogin.updatePrepared("City", object.getTextfield()[2].getText(),
							object.getTextfield()[4].getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// loop to set non-editable and non-enable textFields
			for (int i = 0; i < object.getTextfield().length - 1; i++) {
				object.getTextfield()[i].setEditable(false);
				object.getTextfield()[i].setEnabled(false);
				object.getTextfield()[i].setForeground(Color.DARK_GRAY);
			}
			// if the user changes the Username
			if (!LoginForm.user.getUsername().equals(object.getTextfield()[3].getText())) {
				// if the Username is valid
				if (Check.isValidUsername(object.getTextfield()[3].getText())) {
					// if the Username is not already taken
					try {
						if (queryLogin.checkUsername(object.getTextfield()[3].getText()) == false) {
							queryLogin.updatePrepared("Username", object.getTextfield()[3].getText(),
									object.getTextfield()[4].getText());
							LoginForm.user.setUsername(object.getTextfield()[3].getText());
						} else {
							JOptionPane.showMessageDialog(null, "This Username is already taken");
							object.getButton()[3].setEnabled(false);
							object.getButton()[2].hide();
							object.getButton()[4].show();
							// object.getTextfield()[3].setText(LoginForm.user.getUsername());
							object.getTextfield()[3].setEditable(true);
							object.getTextfield()[3].setEnabled(true);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					object.getLabel()[11].show();
					object.getLabel()[12].show();
					object.getButton()[3].setEnabled(false);
					object.getButton()[2].hide();
					object.getButton()[4].show();
					object.getTextfield()[3].setEditable(true);
					object.getTextfield()[3].setEnabled(true);
				}
			}
			LoginForm.user.setLastName(object.getTextfield()[0].getText());
			LoginForm.user.setFirstName(object.getTextfield()[1].getText());
			LoginForm.user.setCity(object.getTextfield()[2].getText());

			break;
		case "Save Password":

			// check if the user change something or not
			if (String.valueOf(object.getPasswordField()[0].getPassword()).equals("Password")
					|| ((String.valueOf(object.getPasswordField()[1].getPassword()).equals(""))
							&& String.valueOf(object.getPasswordField()[2].getPassword()).equals(""))) {
				if (!String.valueOf(object.getPasswordField()[1].getPassword()).equals("")
						&& !String.valueOf(object.getPasswordField()[2].getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Your former password is incorrect ");
					object.getPasswordField()[1].setText("");
					object.getPasswordField()[2].setText("");
				} else {
					object.getPasswordField()[0].setText("Password");
					object.getPasswordField()[0].setEditable(false);
					object.getPasswordField()[0].setEnabled(false);
					object.getPasswordField()[1].setEditable(false);
					object.getPasswordField()[1].setEnabled(false);
					object.getPasswordField()[2].setEditable(false);
					object.getPasswordField()[2].setEnabled(false);
					object.getButton()[2].setBounds(50, 490, 150, 21);
					object.getButton()[3].setBounds(280, 490, 150, 21);
					object.getButton()[4].setBounds(50, 490, 150, 21);
					object.getButton()[5].setBounds(280, 490, 150, 21);
					object.getButton()[3].show();
					object.getButton()[5].hide();
					object.getFrame().setBounds(100, 100, 478, 553);
					object.getPanel().setBounds(521, 0, 478, 553);
					object.getLabel()[19].setBounds(0, 0, 478, 553);
					object.getPasswordField()[1].hide();
					object.getPasswordField()[2].hide();
					object.getLabel()[8].hide(); // hide New password
					object.getLabel()[9].hide(); // hide confirm the password
					object.getLabel()[10].hide(); // same
					object.getLabel()[13].hide(); // hide Strong label
					object.getLabel()[14].hide(); // hide medium label
					object.getLabel()[15].hide(); // hide weak label
					object.getButton()[2].setEnabled(true);
					object.getLabel()[18].hide(); // infoConfirmPasswordLabel
					object.getLabel()[16].setForeground(Color.DARK_GRAY); // infoPasswordLabel
					object.getLabel()[17].setForeground(Color.DARK_GRAY); // infoPassword2Label
					object.getLabel()[16].hide();
					object.getLabel()[17].hide();
				}
			} else
				try {
					if (queryLogin.checkPassword(object.getTextfield()[4].getText(),
							String.valueOf(object.getPasswordField()[0].getPassword()))) {
						// check if the password is valid (regex)
						if (Check.isValidPassword(String.valueOf(object.getPasswordField()[1].getPassword()))) {
							// check if the newpassword and confirmpassword match
							if (String.valueOf(object.getPasswordField()[2].getPassword())
									.equals(String.valueOf(object.getPasswordField()[1].getPassword()))) {
								// Check the strength of the password
								if (Check.strengthPassword(
										String.valueOf(object.getPasswordField()[1].getPassword())) >= 80) {
									// Check if the new password is not the same as the former
									if (!LoginForm.user.getPassword()
											.equals(String.valueOf(object.getPasswordField()[1].getPassword()))) {
										queryLogin.updatePrepared("Password",
												String.valueOf(object.getPasswordField()[1].getPassword()),
												object.getTextfield()[4].getText());
										object.getPasswordField()[0].setEditable(false);
										object.getPasswordField()[0].setEnabled(false);
										object.getPasswordField()[1].setEditable(false);
										object.getPasswordField()[1].setEnabled(false);
										object.getPasswordField()[2].setEditable(false);
										object.getPasswordField()[2].setEnabled(false);
										object.getButton()[2].setBounds(50, 490, 150, 21);
										object.getButton()[3].setBounds(280, 490, 150, 21);
										object.getButton()[4].setBounds(50, 490, 150, 21);
										object.getButton()[5].setBounds(280, 490, 150, 21);
										object.getButton()[3].show();
										object.getButton()[5].hide();
										object.getFrame().setBounds(100, 100, 478, 553);
										object.getPanel().setBounds(521, 0, 478, 553);
										object.getLabel()[19].setBounds(0, 0, 478, 553);
										object.getPasswordField()[1].hide();
										object.getPasswordField()[2].hide();
										object.getLabel()[8].hide(); // hide New password
										object.getLabel()[9].hide(); // hide confirm the password
										object.getLabel()[10].hide(); // same
										object.getLabel()[13].hide(); // hide Strong label
										object.getLabel()[14].hide(); // hide medium label
										object.getLabel()[15].hide(); // hide weak label
										object.getButton()[2].setEnabled(true);
										object.getLabel()[18].hide(); // infoConfirmPasswordLabel
										object.getLabel()[16].setForeground(Color.DARK_GRAY); // infoPasswordLabel
										object.getLabel()[17].setForeground(Color.DARK_GRAY); // infoPassword2Label
										object.getLabel()[16].hide();
										object.getLabel()[17].hide();
										object.getPasswordField()[1].setText("");
										object.getPasswordField()[2].setText("");
										object.getPasswordField()[0].setText("Password");
										JOptionPane.showMessageDialog(null, "Password changed ");
									} else {
										JOptionPane.showMessageDialog(null,
												"You can't use your former password as a new password ! ");
									}
								}
							} else {
								object.getLabel()[18].show();
							}
						} else {
							object.getLabel()[16].setForeground(Color.RED);
							object.getLabel()[17].setForeground(Color.RED);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Your former password is incorrect ");

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		case "Register":
			// hide all when click a second time on register to check again
			object.getLabel()[5].hide(); // infoUsernameLabel
			object.getLabel()[6].hide(); // infoUsername2Label
			object.getLabel()[16].hide(); // infoConfirmPasswordLabel
			object.getLabel()[8].hide();// infoEmailLabel
			object.getLabel()[13].setForeground(Color.DARK_GRAY); // infoPasswordLabel
			object.getLabel()[14].setForeground(Color.DARK_GRAY); // infoPassword2Label
			// Check if the email is valid (regex)
			if (Check.isValidEmail(object.getTextfield()[4].getText())) {
				// Check if the password is valid (regex)
				if (Check.isValidPassword(String.valueOf(object.getPasswordField()[0].getPassword()))) {
					// Check if the two passwords match
					if (String.valueOf(object.getPasswordField()[1].getPassword())
							.equals(String.valueOf(object.getPasswordField()[0].getPassword()))) {
						// Check if the username is valid (regex)
						if (Check.isValidUsername(object.getTextfield()[3].getText())) {
							// Check if the Email doesn't exist already
							try {
								if (queryLogin.checkEmail(object.getTextfield()[4].getText()) == false) {
									// Check if the Username doesn't exist already
									if (queryLogin.checkUsername(object.getTextfield()[3].getText()) == false) {
										// Check the strength of the password
										if (Check.strengthPassword(
												String.valueOf(object.getPasswordField()[0].getPassword())) >= 80) {
											LoginForm.user = new User(object.getTextfield()[0].getText(),
													object.getTextfield()[1].getText(),
													object.getTextfield()[2].getText(),
													object.getTextfield()[3].getText(),
													object.getTextfield()[4].getText(),
													String.valueOf(object.getPasswordField()[0].getPassword()));
											// System.out.println(user.toString());
											queryLogin.createPrepared(LoginForm.user);
											UserInfoForm infoForm = new UserInfoForm();
											object.getFrame().setVisible(false);
										}
									} else {
										JOptionPane.showMessageDialog(null, "This Username is already taken");
									}
								} else {
									JOptionPane.showMessageDialog(null, "This Email adress already exist");
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							object.getLabel()[5].show();
							object.getLabel()[6].show();
						}
					} else {
						object.getLabel()[16].show();
					}
				} else {
					object.getLabel()[13].setForeground(Color.RED);
					object.getLabel()[14].setForeground(Color.RED);
				}
			} else {
				object.getLabel()[8].show();
			}
			break;
		}

	}

}
