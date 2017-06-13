package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddContact extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, mitwelchem ein neuer Kontakt angelegt werden kann.
	 * @author Yannik
	 * @version 2.0.0
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int id) {
		try {
			AddContact dialog = new AddContact(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddContact(Integer id) {
		Kontaktverwaltung kt = new Kontaktverwaltung();

		setBounds(100, 100, 498, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setText(id.toString());
		textField.setBounds(97, 11, 116, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(97, 37, 116, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(97, 89, 116, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(97, 113, 375, 87);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel = new JLabel("Kundennummer");
		lblNewLabel.setBounds(10, 14, 77, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datum");
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Kontaktart");
		lblNewLabel_2.setBounds(10, 67, 77, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Kurznotiz");
		lblNewLabel_3.setBounds(10, 92, 77, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Beschreibung");
		lblNewLabel_4.setBounds(10, 116, 64, 14);
		contentPanel.add(lblNewLabel_4);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Telefon");
		comboBox.addItem("E-Mail");
		comboBox.addItem("Brief");
		comboBox.setBounds(97, 64, 116, 20);
		contentPanel.add(comboBox);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String[] dates = textField_1.getText().split("-");
						int year = Integer.parseInt(dates[0]) - 1900;
						int month = Integer.parseInt(dates[1]) - 1;
						int day = Integer.parseInt(dates[2]);
						java.sql.Date d = new java.sql.Date(year, month, day);
						Kontakt contact = new Kontakt(Integer
								.parseInt(textField.getText()), d, comboBox
								.getSelectedItem().toString(), textField_3
								.getText(), textField_4.getText());
						kt.kontakthinzufuegen(contact);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

			}
		}
	}
}
