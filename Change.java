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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Change extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, mitwelchem ein bestehender Kunde verändert werden kann.
	 * @author Yannik
	 * @version 2.0.0
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int id) {
		try {
			Change dialog = new Change(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Change(int id) {
		Kundenverwaltung k = new Kundenverwaltung();
		Gruppenverwaltung g = new Gruppenverwaltung();
		setBounds(100, 100, 271, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ResultSet res = k.getResultSet(id);

		try {
			res.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(97, 11, 148, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		try {
			textField.setText(res.getString(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_1 = new JTextField();
		textField_1.setBounds(97, 37, 148, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		try {
			textField_1.setText(res.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_2 = new JTextField();
		textField_2.setBounds(97, 64, 148, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		try {
			textField_2.setText(res.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_3 = new JTextField();
		textField_3.setBounds(97, 89, 148, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		try {
			textField_3.setText(res.getString(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_4 = new JTextField();
		textField_4.setBounds(97, 113, 148, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		try {
			textField_4.setText(res.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_5 = new JTextField();
		textField_5.setBounds(97, 141, 148, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		try {
			textField_5.setText(res.getString(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_6 = new JTextField();
		textField_6.setBounds(97, 172, 148, 20);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		try {
			textField_6.setText(res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_7 = new JTextField();
		textField_7.setBounds(97, 198, 148, 20);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		try {
			textField_7.setText(res.getString(8));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textField_8 = new JTextField();
		textField_8.setBounds(97, 229, 148, 20);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);

		try {
			textField_8.setText(res.getString(9));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(97, 260, 148, 20);
		contentPanel.add(textField_9);

		try {
			textField_9.setText(res.getString(10));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("Kundennummer");
		lblNewLabel.setBounds(10, 14, 77, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Vorname");
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 67, 46, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Stra\u00DFe");
		lblNewLabel_3.setBounds(10, 92, 77, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Hausnummer");
		lblNewLabel_4.setBounds(10, 116, 77, 14);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ort");
		lblNewLabel_5.setBounds(10, 144, 57, 14);
		contentPanel.add(lblNewLabel_5);

		JLabel lblGeburtsdatum = new JLabel("Mailadresse");
		lblGeburtsdatum.setBounds(10, 198, 77, 14);
		contentPanel.add(lblGeburtsdatum);

		JLabel lblMailadresse = new JLabel("PLZ");
		lblMailadresse.setBounds(10, 175, 77, 14);
		contentPanel.add(lblMailadresse);

		JLabel lblTelefon = new JLabel("Geburtsdatum");
		lblTelefon.setBounds(10, 232, 77, 14);
		contentPanel.add(lblTelefon);

		JLabel lblTelefon_1 = new JLabel("Telefon");
		lblTelefon_1.setBounds(10, 263, 57, 14);
		contentPanel.add(lblTelefon_1);
		
		
		
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		

		


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (textField_6.getText().length() > 10) {
							JOptionPane.showMessageDialog(null, "Fehler",
									"Fehler", JOptionPane.ERROR_MESSAGE);
						} else if (textField_1.getText().length() > 50
								|| textField_1.getText().length() > 50
								|| textField_2.getText().length() > 50
								|| textField_3.getText().length() > 50
								|| textField_4.getText().length() > 50
								||textField_5.getText().length() > 50
								||textField_6.getText().length() > 50
								||textField_7.getText().length() > 50
								||textField_8.getText().length() > 50
								||textField_9.getText().length() > 50) {

						} else {
						Kunde kunde = new Kunde(textField_1.getText(),
								textField_2.getText(), textField_3.getText(),
								textField_4.getText(), textField_5.getText(),
								textField_6.getText(),
								textField_7.getText(), textField_8.getText(),
								textField_9.getText());
						kunde.setKundennummer(id);
						k.kundeaendern(kunde);
						dispose();
						}
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
