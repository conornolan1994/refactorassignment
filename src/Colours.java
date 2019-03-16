import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Colours {
	
	static Color white = Color.WHITE;
	static Color red = new Color(255,150,150);
	static Color foreground = new Color(65,65,65);
	
	public static void setToWhite(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JComboBox<String> genderCombo, JComboBox departmentCombo, JTextField salaryField, JComboBox fullTimeCombo) {
		ppsField.setBackground(Colours.white);
		surnameField.setBackground(Colours.white);
		firstNameField.setBackground(Colours.white);
		salaryField.setBackground(Colours.white);
		genderCombo.setBackground(Colours.white);
		departmentCombo.setBackground(Colours.white);
		fullTimeCombo.setBackground(Colours.white);
	}
	

}
