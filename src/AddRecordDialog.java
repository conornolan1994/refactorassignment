/*
 * 
 * This is a dialog for adding new Employees and saving records to file
 * 
 * */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

public class AddRecordDialog extends JDialog implements ActionListener {
	JTextField idField, ppsField, surnameField, firstNameField, salaryField;
	JComboBox<String> genderCombo, departmentCombo, fullTimeCombo;
	JButton save, cancel;
	EmployeeDetails parent;
	// constructor for add record dialog
	public AddRecordDialog(EmployeeDetails parent) {
		setTitle("Add Record");
		setModal(true);
		this.parent = parent;
		this.parent.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane(dialogPane());
		setContentPane(scrollPane);
		
		getRootPane().setDefaultButton(save);
		
		setSize(500, 370);
		setLocation(350, 250);
		setVisible(true);
	}// end AddRecordDialog

	// initialize dialog container
	public Container dialogPane() {
		JPanel empDetails, buttonPanel;
		empDetails = new JPanel(new MigLayout());
		buttonPanel = new JPanel();
		JTextField field;

		empDetails.setBorder(BorderFactory.createTitledBorder("Employee Details"));

		empDetails.add(new JLabel("ID:"), MigLayoutVariables.migLayout2);
		empDetails.add(idField = new JTextField(20),MigLayoutVariables.migLayout1);
		idField.setEditable(false);
		

		empDetails.add(new JLabel("PPS Number:"),MigLayoutVariables.migLayout2);
		empDetails.add(ppsField = new JTextField(20), MigLayoutVariables.migLayout1);

		empDetails.add(new JLabel("Surname:"), MigLayoutVariables.migLayout2);
		empDetails.add(surnameField = new JTextField(20), MigLayoutVariables.migLayout1);

		empDetails.add(new JLabel("First Name:"), MigLayoutVariables.migLayout2);
		empDetails.add(firstNameField = new JTextField(20), MigLayoutVariables.migLayout1);

		empDetails.add(new JLabel("Gender:"), MigLayoutVariables.migLayout2);
		empDetails.add(genderCombo = new JComboBox<String>(this.parent.gender), MigLayoutVariables.migLayout1);

		empDetails.add(new JLabel("Department:"), MigLayoutVariables.migLayout2);
		empDetails.add(departmentCombo = new JComboBox<String>(this.parent.department), MigLayoutVariables.migLayout1);

		empDetails.add(new JLabel("Salary:"), MigLayoutVariables.migLayout2);
		empDetails.add(salaryField = new JTextField(20), MigLayoutVariables.migLayout1);

		empDetails.add(new JLabel("Full Time:"), MigLayoutVariables.migLayout2);
		empDetails.add(fullTimeCombo = new JComboBox<String>(this.parent.fullTime), MigLayoutVariables.migLayout1);

		buttonPanel.add(save = new JButton("Save"));
		save.addActionListener(this);
		save.requestFocus();
		buttonPanel.add(cancel = new JButton("Cancel"));
		cancel.addActionListener(this);

		empDetails.add(buttonPanel, MigLayoutVariables.migLayout3);
		for (int i = 0; i < empDetails.getComponentCount(); i++) {
			empDetails.getComponent(i).setFont(this.parent.font1);
			if (empDetails.getComponent(i) instanceof JComboBox) {
				empDetails.getComponent(i).setBackground(Colours.white);
			}
			else if(empDetails.getComponent(i) instanceof JTextField){
				field = (JTextField) empDetails.getComponent(i);
				if(field == ppsField)
					field.setDocument(new JTextFieldLimit(7));
				else
				field.setDocument(new JTextFieldLimit(20));
			}
		}
		idField.setText(Integer.toString(this.parent.getNextFreeId()));
		return empDetails;
	}

	// add record to file
	public void addRecord() {
		boolean fullTime = false;
		Employee theEmployee;

		if (((String) fullTimeCombo.getSelectedItem()).equalsIgnoreCase("Yes"))
			fullTime = true;
		theEmployee = new Employee(Integer.parseInt(idField.getText()), ppsField.getText().toUpperCase(), surnameField.getText().toUpperCase(),
				firstNameField.getText().toUpperCase(), genderCombo.getSelectedItem().toString().charAt(0),
				departmentCombo.getSelectedItem().toString(), Double.parseDouble(salaryField.getText()), fullTime);
		this.parent.currentEmployee = theEmployee;
		this.parent.addRecord(theEmployee);
		this.parent.displayRecords(theEmployee);
	}
	public boolean checkInput() {
		Validate validation = new Validate(ppsField, surnameField, firstNameField,genderCombo, departmentCombo,  salaryField, fullTimeCombo);

		boolean valid = true;
		Validate.checkInput(validation);
		if (this.parent.correctPps(this.ppsField.getText().trim(), -1)) {
			ppsField.setBackground(Colours.red);
			valid = false;
		}
		return valid;
	}// end checkInput


	// action performed
	public void actionPerformed(ActionEvent e) {
		Validate validation = new Validate(ppsField, surnameField, firstNameField,genderCombo, departmentCombo,  salaryField, fullTimeCombo);
		// if chosen option save, save record to file
		if (e.getSource() == save) {
			if (checkInput()) {
				addRecord();// add record to file
				dispose();// dispose dialog
				this.parent.changesMade = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong values or format! Please check!");
				Colours.setToWhite(validation);
			}
		}
		else if (e.getSource() == cancel)
			dispose();
	}
}