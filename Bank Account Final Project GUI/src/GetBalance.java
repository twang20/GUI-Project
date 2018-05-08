import java.awt.Dimension;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JCheckBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JList;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTextField;

public class GetBalance extends JPanel {

	private static ArrayList<BankAccount> user = new ArrayList<BankAccount>();

	public void setUp() {

		JPanel myPanel = new JPanel(new GridBagLayout());

		myPanel.setPreferredSize(new Dimension(500, 500));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;

		gbc.gridy = 0;

		JLabel lblName = new JLabel("Account Number:");

		add(myPanel);

		myPanel.add(lblName, gbc);

		gbc.gridx = 1;

		gbc.gridy = 0;

		JTextField txtName = new JTextField("");

		txtName.setPreferredSize(new Dimension(70, 20));

		myPanel.add(txtName, gbc);

		gbc.gridx = 0;

		gbc.gridy = 1;

		JLabel lblAccount = new JLabel("Account Type: ");

		myPanel.add(lblAccount, gbc);

		gbc.gridx = 0;

		gbc.gridy = 0;

		gbc.gridx = 0;

		gbc.gridy = 3;

		String[] arr = { "Checking", "Savings" };

		JList<String> options = new JList<>(arr);

		JScrollPane scrOptions = new JScrollPane(options);

		scrOptions.setPreferredSize(new Dimension(70, 20));

		scrOptions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		myPanel.add(scrOptions, gbc);

		JButton myButton = new JButton("Get Balance");

		gbc.gridx = 0;

		gbc.gridy = 4;

		myPanel.add(myButton, gbc);
		
		myButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				 
					for (int i = 0; i < MainScreen.allAccounts.size(); i++) {
						if ( MainScreen.allAccounts.get(i).getName().equalsIgnoreCase(txtName.getText()))
						{
							JLabel info = new JLabel(MainScreen.allAccounts.get(i).getBalance() + "");
							gbc.gridx = 0;
							gbc.gridy = 5+i;
							myPanel.add(info, gbc);
							myPanel.revalidate();
							myPanel.repaint();
						}
					}
				}
		});
	}

}
