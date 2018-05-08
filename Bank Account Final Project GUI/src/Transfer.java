
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

public class Transfer extends JPanel {

	private static ArrayList<BankAccount> user = new ArrayList<BankAccount>();

	public void setUp() {


		JPanel myPanel = new JPanel(new GridBagLayout());

		myPanel.setPreferredSize(new Dimension(500, 500));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;

		gbc.gridy = 0;

		JLabel lblName = new JLabel("Name of From Account: ");

		add(myPanel);

		myPanel.add(lblName, gbc);

		gbc.gridx = 1;

		gbc.gridy = 0;

		JTextField txtName = new JTextField("");

		txtName.setPreferredSize(new Dimension(70, 20));

		myPanel.add(txtName, gbc);

		gbc.gridx = 0;

		gbc.gridy = 1;

		JLabel lblDeposit = new JLabel("Name of To Account: ");

		myPanel.add(lblDeposit, gbc);

		gbc.gridx = 0;

		gbc.gridy = 0;

		JTextField txtDeposit = new JTextField("");

		txtDeposit.setSize(70, 30);

		txtDeposit.setPreferredSize(new Dimension(70, 20));

		gbc.gridwidth = 1;

		gbc.gridx = 1;

		gbc.gridy = 1;

		myPanel.add(txtDeposit, gbc);

		gbc.gridx = 0;

		gbc.gridy = 3;

		JLabel lblAccount = new JLabel("Amount: ");
		gbc.gridx = 0;

		gbc.gridy = 3;


		myPanel.add(lblAccount, gbc);

		JTextField txtAccount = new JTextField("");

		txtAccount.setPreferredSize(new Dimension (70, 30) );
		gbc.gridx = 1;

		gbc.gridy = 3;
		myPanel.add(txtAccount, gbc);

		JButton myButton = new JButton("submit");

		gbc.gridx = 0;

		gbc.gridy = 4;

		myPanel.add(myButton, gbc);

		myButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				BankAccount accountFrom = null;
				BankAccount accountTo = null;
				double balance = Double.parseDouble(txtAccount.getText());
				for (int i = 0; i < MainScreen.allAccounts.size(); i++) {
					if (MainScreen.allAccounts.get(i).getName().equals(txtName.getText())) {
						accountFrom = MainScreen.allAccounts.get(i);
						System.out.println("hi");
					}
				}

				for (int i = 0; i < MainScreen.allAccounts.size(); i++) {
					if (MainScreen.allAccounts.get(i).getName().equals(txtDeposit.getText())) {
						accountTo = MainScreen.allAccounts.get(i);
						System.out.println("hi2");
					}
				}
				if (accountTo != null && accountFrom != null) {
				accountTo.transfer(accountFrom, balance);
				System.out.println("hi3");
			}
			}
		});



		}



}
