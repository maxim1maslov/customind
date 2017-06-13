package project;

import java.awt.BorderLayout;
import java.awt.Desktop;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class Extend extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, mitwelchem ein bereits bestehender Kunde angezeigt werden kann.
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int id) {
		try {
			Extend dialog = new Extend(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Extend(int id) {
		Kundenverwaltung k = new Kundenverwaltung();
		Kontaktverwaltung kt = new Kontaktverwaltung();
		Gruppenverwaltung g = new Gruppenverwaltung();
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				String[] tableTitle = { "KONTAKTNUMMER", "KONTAKTART", "DATUM",
						"KURZNOTIZ" };
				DefaultTableModel test = new DefaultTableModel(kt.sfgetKontakt(
						tableTitle, "KUNDENNUMMER", id), tableTitle) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
				table.setModel(test);
			}

			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setBounds(100, 100, 702, 454);
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
		textField.setEditable(false);
		textField.setBounds(97, 11, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		try {
			textField.setText(res.getString(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(97, 37, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		try {
			textField_1.setText(res.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(97, 64, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		try {
			textField_2.setText(res.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(97, 89, 86, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		try {
			textField_3.setText(res.getString(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(97, 113, 86, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		try {
			textField_4.setText(res.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(97, 141, 86, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		try {
			textField_5.setText(res.getString(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(97, 172, 86, 20);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		try {
			textField_6.setText(res.getString(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(97, 198, 86, 20);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		try {
			textField_7.setText(res.getString(8));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(97, 229, 86, 20);
		contentPanel.add(textField_8);
		textField_8.setColumns(10);

		try {
			textField_8.setText(res.getString(9));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(97, 260, 86, 20);
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

		JLabel lblNewLabel_3 = new JLabel("Strasse");
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

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(261, 10, 415, 303);
		contentPanel.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Aktivitaeten", null, scrollPane, null);

		String[] tableTitle = { "KONTAKTNUMMER", "KONTAKTART", "DATUM",
				"KURZNOTIZ" };
		DefaultTableModel test = new DefaultTableModel(kt.sfgetKontakt(
				tableTitle, "KUNDENNUMMER", id), tableTitle) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(test);
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int iSelectedRow = table.getSelectedRow();
					int yourValue = Integer.parseInt(table.getValueAt(
							iSelectedRow, 0).toString());
					ExtendContact c = new ExtendContact(yourValue);
					c.setVisible(true);
				}
			}
		});

		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Gruppen", null, scrollPane_1, null);

		String[] title1 = { "BEZEICHNUNG", "BESCHREIBUNG" };
		String[] from = { "GRUPPEKUNDE", "GRUPPE" };

		DefaultTableModel dtm1 = new DefaultTableModel(g.sfgetGruppe(title1,
				from, "GRUPPEKUNDE.KUNDENNUMMER", textField.getText()), title1);

		table_1 = new JTable(dtm1);
		table_1.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(table_1);

		JButton btnAdd = new JButton("Aktivit\u00E4t hinzuf\u00FCgen");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddContact c = new AddContact(Integer.parseInt(textField
						.getText()));
				c.setVisible(true);
			}
		});
		btnAdd.setBounds(429, 320, 148, 20);
		contentPanel.add(btnAdd);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

		JButton btnDelete = new JButton("Loeschen");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null,
						"Soll wirklich geloescht werden?", "TITEL",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					int zeile = table.getSelectedRow();
					kt.kontaktloeschen(zeile);

					DefaultTableModel test2 = new DefaultTableModel(
							kt.getKontakte(Integer.parseInt(textField.getText())),
							kt.getTableTitle());
					table.setModel(test2);

				}
			}
		});
		btnDelete.setBounds(587, 320, 89, 20);
		contentPanel.add(btnDelete);

		JButton btnEmailSchreiben = new JButton("E-Mail schreiben");
		btnEmailSchreiben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desktop = Desktop.getDesktop();
				String message = "mailto:" + textField_7.getText();
				URI uri = URI.create(message);
				try {
					desktop.mail(uri);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEmailSchreiben.setBounds(62, 319, 148, 20);
		contentPanel.add(btnEmailSchreiben);
	}
}
