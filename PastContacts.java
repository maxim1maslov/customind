package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PastContacts extends JDialog {
	/**
	 * Diese Klasse stellt einen JDialog innerhalb der GUI dar, mitwelchem lange nicht kontaktierte (>3 Monate) Kunden angezeigt werden können.
	 * @author Yannik
	 * @version 2.0.0
	 */
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PastContacts dialog = new PastContacts();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PastContacts() {
		Kundenverwaltung k = new Kundenverwaltung();
		setBounds(100, 100, 871, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 835, 370);
		contentPanel.add(scrollPane);
		
		String[] title = {"KUNDENNUMMER", "VORNAME", "NAME",  "DATUM"};
		DefaultTableModel test = new DefaultTableModel (k.langenichtkontaktiert(), title);
		
		
		table = new JTable(test){
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }        
        };
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
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
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
