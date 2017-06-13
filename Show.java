package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Show extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, welcher das Hauptmenü darstellt und in welchem alle Kunden angezeigt werden.
	 * @author Yannik
	 * @version 2.0.0
	 */
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Persistenz p = new Persistenz();
			p.create();
			p.close();
			Show dialog = new Show();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				Persistenz p = new Persistenz();
				p.shutdown();
				p.close();
			}
		}));
	}

	/**
	 * Create the dialog.
	 */
	public Show() {
		Kundenverwaltung k = new Kundenverwaltung();
		Gruppenverwaltung g = new Gruppenverwaltung();
		Kontaktverwaltung kt = new Kontaktverwaltung();

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Show.class.getResource("/project/CustoMind.jpg")));
		setTitle("CustoMind");
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				DefaultTableModel test = new DefaultTableModel(k.getKunden(), k.getTableTitle()) {
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
		setBounds(100, 100, 780, 329);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		String[] title;
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 744, 207);
			contentPanel.add(scrollPane);

			DefaultTableModel test = new DefaultTableModel(k.getKunden(), k.getTableTitle()) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table = new JTable(test);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (arg0.getClickCount() == 2) {
						int iSelectedRow = table.getSelectedRow();
						int yourValue = Integer.parseInt(table.getValueAt(
								iSelectedRow, 0).toString());
						Extend c = new Extend(yourValue);
						c.setVisible(true);
					}
				}
			});

			table.setAutoCreateRowSorter(true);
			table.setEditingColumn(0);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 217, 764, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Kunden hinzufuegen");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Add.main(null);
					}
				});
				{
					{
						JButton agrp = new JButton("Gruppe hinzufuegen");
						agrp.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								AddGroup c = new AddGroup();
								c.setVisible(true);
							}
						});

						JButton btnLangeNichtKontaktiert = new JButton(
								"lange nicht kontaktiert");
						btnLangeNichtKontaktiert
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										PastContacts pc = new PastContacts();
										pc.main(null);

									}
								});
						buttonPane.add(btnLangeNichtKontaktiert);
						buttonPane.add(agrp);
					}
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Aendern");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int iSelectedRow = table.getSelectedRow();
						int yourValue = Integer.parseInt(table.getValueAt(
								iSelectedRow, 0).toString());
						Change c = new Change(yourValue);
						c.setVisible(true);

					}
				});
				cancelButton.setActionCommand("Abbrechen");
				buttonPane.add(cancelButton);
			}
			JButton btnShow = new JButton("Anzeigen");
			btnShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int iSelectedRow = table.getSelectedRow();
					int yourValue = Integer.parseInt(table.getValueAt(
							iSelectedRow, 0).toString());
					Extend c = new Extend(yourValue);
					c.setVisible(true);
				}
			});
			buttonPane.add(btnShow);

			JButton btnDelete = new JButton("Loeschen");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					int result = JOptionPane.showConfirmDialog(null,
							"Soll wirklich geloescht werden?", "Kunde loeschen",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int zeile = table.getSelectedRow();
						k.kundeloeschen(zeile);
						g.gruppeloeschen(zeile);
						kt.kontaktloeschen(zeile);
						
						
						DefaultTableModel test2 = new DefaultTableModel(k.getKunden(), k.getTableTitle());
						table.setModel(test2);

					}
				}
			});
			buttonPane.add(btnDelete);
		}
		JComboBox comboBox = new JComboBox(k.getTableTitle());
		comboBox.setBounds(334, 262, 109, 20);
		contentPanel.add(comboBox);
		JButton btnSuchen = new JButton("Suchen");
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel test;
				if (textField.getText().length() != 0) {
					test = new DefaultTableModel(
							k.getKunden(comboBox.getSelectedItem().toString(),
									textField.getText()), k.getTableTitle()) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
				} else {
					test = new DefaultTableModel(k.getKunden(), k
							.getTableTitle()) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
				}

				table.setModel(test);
			}
		});
		btnSuchen.setBounds(665, 261, 89, 23);
		contentPanel.add(btnSuchen);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(453, 262, 202, 20);
		contentPanel.add(textField);

	}
}
