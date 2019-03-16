import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Colours {
	
	static Color white = Color.WHITE;
	static Color red = new Color(255,150,150);
	static Color foreground = new Color(65,65,65);
	
	public static void setToWhite(Validate validation) {
		validation.getPpsField().setBackground(Colours.white);
		validation.getSurnameField().setBackground(Colours.white);
		validation.getFirstNameField().setBackground(Colours.white);
		validation.getSalaryField().setBackground(Colours.white);
		validation.getGenderCombo().setBackground(Colours.white);
		validation.getDepartmentCombo().setBackground(Colours.white);
		validation.getFullTimeCombo().setBackground(Colours.white);
	}
	

}
