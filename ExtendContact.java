package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ExtendContact extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, mitwelchem ein bereits bestehender Kontakt angezeigt werden kann.
	 * @author Maxim
	 * @version 2.0.0
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int id) {
		try {
			ExtendContact dialog = new ExtendContact(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExtendContact(int id) {
		Kontaktverwaltung kt = new Kontaktverwaltung();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);		
		
		ResultSet res = kt.getResultSet(id);		
		
		try {
			res.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(104, 11, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		try {
			textField.setText(res.getString(2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(104, 42, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		try {
			textField_1.setText(res.getString(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(104, 73, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		try {
			textField_2.setText(res.getString(4));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(104, 104, 86, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		try {
			textField_3.setText(res.getString(5));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(104, 135, 320, 83);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		try {
			textField_4.setText(res.getString(6));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblKundennummer = new JLabel("Kundennummer:");
		lblKundennummer.setBounds(10, 14, 94, 14);
		contentPanel.add(lblKundennummer);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(10, 45, 46, 14);
		contentPanel.add(lblDatum);
		
		JLabel lblKontaktart = new JLabel("Kontaktart:");
		lblKontaktart.setBounds(10, 76, 84, 14);
		contentPanel.add(lblKontaktart);
		
		JLabel lblKurznotiz = new JLabel("Kurznotiz:");
		lblKurznotiz.setBounds(10, 107, 84, 14);
		contentPanel.add(lblKurznotiz);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setBounds(10, 135, 84, 14);
		contentPanel.add(lblBeschreibung);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
