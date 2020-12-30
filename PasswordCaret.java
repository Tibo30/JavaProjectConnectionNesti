package projetFilRouge;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * 
 * @author Tjlvt
 *
 */
public class PasswordCaret implements CaretListener{
ValueNeeded object;
int a,b,c,d;

/**
 * This is the constructor of PasswordCaret class
 * @param object
 * @param a
 * @param b
 * @param c
 * @param d
 */
public PasswordCaret(ValueNeeded object, int a, int b, int c, int d) {
	this.object=object;
	this.a=a;
	this.b=b;
	this.c=c;
	this.d=d;
}

	@Override
	public void caretUpdate(CaretEvent arg0) {
		
		object.getLabel()[a].hide();
		object.getLabel()[b].hide();
		object.getLabel()[c].hide();
		if (Check.strengthPassword(String.valueOf(object.getPasswordField()[d].getPassword())) < 80
				&& !String.valueOf(object.getPasswordField()[d].getPassword()).equals("")
				&& !String.valueOf(object.getPasswordField()[d].getPassword()).equals("PasswordField")) {
			object.getLabel()[c].show();
		} else if (Check.strengthPassword(String.valueOf(object.getPasswordField()[d].getPassword())) < 100
				&& Check.strengthPassword(String.valueOf(object.getPasswordField()[d].getPassword())) >= 80
				&& !String.valueOf(object.getPasswordField()[d].getPassword()).equals("")) {
			object.getLabel()[b].show();
		} else if (Check.strengthPassword(String.valueOf(object.getPasswordField()[d].getPassword())) >= 100
				&& !String.valueOf(object.getPasswordField()[d].getPassword()).equals("")) {
			object.getLabel()[a].show();
		}
		
	}

}
