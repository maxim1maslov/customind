package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Add extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, mitwelchem ein neuer Kunde angelegt werden kann.
	 * @author Maxim
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
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Add dialog = new Add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Add() {
		Kundenverwaltung k = new Kundenverwaltung();
		Gruppenverwaltung g = new Gruppenverwaltung();
		setBounds(100, 100, 996, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(97, 11, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(97, 37, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(97, 64, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(97, 89, 86, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(97, 113, 86, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(97, 141, 86, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(97, 172, 86, 20);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(97, 198, 86, 20);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel = new JLabel("Vorname");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Stra\u00DFe");
		lblNewLabel_2.setBounds(10, 67, 46, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Hausnummer");
		lblNewLabel_3.setBounds(10, 92, 77, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ort");
		lblNewLabel_4.setBounds(10, 116, 46, 14);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("PLZ");
		lblNewLabel_5.setBounds(10, 144, 57, 14);
		contentPanel.add(lblNewLabel_5);

		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(10, 198, 77, 14);
		contentPanel.add(lblGeburtsdatum);

		JLabel lblMailadresse = new JLabel("Mailadresse");
		lblMailadresse.setBounds(10, 175, 77, 14);
		contentPanel.add(lblMailadresse);

		textField_8 = new JTextField();
		textField_8.setBounds(97, 229, 86, 20);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(10, 232, 57, 14);
		contentPanel.add(lblTelefon);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 11, 704, 238);
		contentPanel.add(scrollPane);

		DefaultTableModel test = new DefaultTableModel(g.getGruppen(),
				g.getTableTitle()) {
			public Class<?> getColumnClass(int colIndex) {
				if (colIndex == 3) {
					return Boolean.class;
				} else {
					return Object.class;
				}

			}
		};
		test.addColumn("");
		table = new JTable(test);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (textField_5.getText().length() > 10) {
							JOptionPane.showMessageDialog(null, "Fehler",
									"Fehler", JOptionPane.ERROR_MESSAGE);
						} else if (textField.getText().length() > 50
								|| textField_1.getText().length() > 50
								|| textField_1.getText().length() > 50
								|| textField_2.getText().length() > 50
								|| textField_3.getText().length() > 50
								|| textField_4.getText().length() > 50
								||textField_5.getText().length() > 50
								||textField_6.getText().length() > 50
								||textField_7.getText().length() > 50
								||textField_8.getText().length() > 50) {

						} else {
							Kunde kunde = new Kunde(textField.getText(),
									textField_1.getText(), textField_2
											.getText(), textField_3.getText(),
									textField_4.getText(), textField_5
											.getText(), textField_6.getText(),
									textField_7.getText(), textField_8
											.getText());
							k.kundehinzufuegen(kunde);
							k.kundezugruppehinzufuegen(table);
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
