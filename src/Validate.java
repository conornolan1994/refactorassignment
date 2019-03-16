import java.awt.Color;
import java.io.File;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Validate {
	
	private JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	private static long currentByteStart = 0;
	private JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	private static RandomFile application = new RandomFile();
	EmployeeDetails ed = new EmployeeDetails();
	File file;
	String generatedFileName;
	
	public static boolean checkInput(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JComboBox<String> genderCombo, JComboBox departmentCombo, JTextField salaryField, JComboBox fullTimeCombo ) {
		boolean valid = true;
		if (ppsField.isEditable() && ppsField.getText().trim().isEmpty()) {
			ppsField.setBackground(new Color(255, 150, 150));
			valid = false;
		}
//		if (ppsField.isEditable() && correctPps(ppsField.getText().trim(), currentByteStart)) {
//			ppsField.setBackground(new Color(255, 150, 150));
//			valid = false;
//		} 
		if (surnameField.isEditable() && surnameField.getText().trim().isEmpty()) {
			surnameField.setBackground(new Color(255, 150, 150));
			valid = false;
		} 
		if (firstNameField.isEditable() && firstNameField.getText().trim().isEmpty()) {
			firstNameField.setBackground(new Color(255, 150, 150));
			valid = false;
		} 
		if (genderCombo.getSelectedIndex() == 0 && genderCombo.isEnabled()) {
			genderCombo.setBackground(new Color(255, 150, 150));
			valid = false;
		}
		if (departmentCombo.getSelectedIndex() == 0 && departmentCombo.isEnabled()) {
			departmentCombo.setBackground(new Color(255, 150, 150));
			valid = false;
		} 
		try {
			Double.parseDouble(salaryField.getText());
			if (Double.parseDouble(salaryField.getText()) < 0) {
				salaryField.setBackground(new Color(255, 150, 150));
				valid = false;
			}
		}
		catch (NumberFormatException num) {
			if (salaryField.isEditable()) {
				salaryField.setBackground(new Color(255, 150, 150));
				valid = false;
			} 
		} 
		if (fullTimeCombo.getSelectedIndex() == 0 && fullTimeCombo.isEnabled()) {
			fullTimeCombo.setBackground(new Color(255, 150, 150));
			valid = false;
		} 
		if (!valid){
			JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
		}
		//if (ppsField.isEditable())

		return valid;
	}
	
	
}

