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
	
	public Validate(JTextField ppsField, JTextField surnameField, JTextField firstNameField, JComboBox genderCombo, JComboBox departmentCombo, JTextField salaryField,
			  JComboBox fullTimeCombo) {
		super();
		this.ppsField = ppsField;
		this.surnameField = surnameField;
		this.firstNameField = firstNameField;
		this.salaryField = salaryField;
		this.genderCombo = genderCombo;
		this.departmentCombo = departmentCombo;
		this.fullTimeCombo = fullTimeCombo;
	}

	String generatedFileName;
	
	public static boolean checkInput(Validate validation ) {
		boolean valid = true;
		if (validation.getPpsField().isEditable() && validation.getPpsField().getText().trim().isEmpty()) {
			validation.getPpsField().setBackground(Colours.red);
			valid = false;
		}
		if (validation.getSurnameField().isEditable() && validation.getSurnameField().getText().trim().isEmpty()) {
			validation.getSurnameField().setBackground(Colours.red);
			valid = false;
		} 
		if (validation.getFirstNameField().isEditable() && validation.getFirstNameField().getText().trim().isEmpty()) {
			validation.getFirstNameField().setBackground(Colours.red);
			valid = false;
		} 
		if (validation.getGenderCombo().getSelectedIndex() == 0 && validation.getGenderCombo().isEnabled()) {
			validation.getGenderCombo().setBackground(Colours.red);
			valid = false;
		}
		if (validation.getDepartmentCombo().getSelectedIndex() == 0 && validation.getDepartmentCombo().isEnabled()) {
			validation.getDepartmentCombo().setBackground(Colours.red);
			valid = false;
		} 
		try {
			Double.parseDouble(validation.getSalaryField().getText());
			if (Double.parseDouble(validation.getSalaryField().getText()) < 0) {
				validation.getSalaryField().setBackground(Colours.red);
				valid = false;
			}
		}
		catch (NumberFormatException num) {
			if (validation.getSalaryField().isEditable()) {
				validation.getSalaryField().setBackground(Colours.red);
				valid = false;
			} 
		} 
		if (validation.getFullTimeCombo().getSelectedIndex() == 0 && validation.getFullTimeCombo().isEnabled()) {
			validation.getFullTimeCombo().setBackground(Colours.red);
			valid = false;
		} 
		if (!valid){
			JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
		}

		return valid;
	}

	public JTextField getPpsField() {
		return ppsField;
	}

	public void setPpsField(JTextField ppsField) {
		this.ppsField = ppsField;
	}

	public JTextField getSurnameField() {
		return surnameField;
	}

	public void setSurnameField(JTextField surnameField) {
		this.surnameField = surnameField;
	}

	public JTextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(JTextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public JTextField getSalaryField() {
		return salaryField;
	}

	public void setSalaryField(JTextField salaryField) {
		this.salaryField = salaryField;
	}

	public JComboBox<String> getGenderCombo() {
		return genderCombo;
	}

	public void setGenderCombo(JComboBox<String> genderCombo) {
		this.genderCombo = genderCombo;
	}

	public JComboBox<String> getDepartmentCombo() {
		return departmentCombo;
	}

	public void setDepartmentCombo(JComboBox<String> departmentCombo) {
		this.departmentCombo = departmentCombo;
	}

	public JComboBox<String> getFullTimeCombo() {
		return fullTimeCombo;
	}

	public void setFullTimeCombo(JComboBox<String> fullTimeCombo) {
		this.fullTimeCombo = fullTimeCombo;
	}
	
	
}

