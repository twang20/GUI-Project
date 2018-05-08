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



public class Withdraw extends JPanel {

	private static ArrayList<BankAccount> user = new ArrayList<BankAccount>();



	public void setUp() {


		JPanel myPanel = new JPanel(new GridBagLayout());

		myPanel.setPreferredSize(new Dimension(500, 500));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;

		gbc.gridy = 0;

		JLabel lblName = new JLabel("Name: ");

		add(myPanel);

		myPanel.add(lblName, gbc);

		gbc.gridx = 1;

		gbc.gridy = 0;

		JTextField txtName = new JTextField("");

		txtName.setPreferredSize(new Dimension(70, 20));

		myPanel.add(txtName, gbc);

		gbc.gridx = 0;

		gbc.gridy = 1;

		JLabel lblDeposit = new JLabel("Amount Withdrawal: ");

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

		JLabel lblAccount = new JLabel("Account Type: ");

		myPanel.add(lblAccount, gbc);

		gbc.gridx = 1;

		gbc.gridy = 3;

		JTextField txtAccount = new JTextField("");

		txtAccount.setSize(70, 30);

		String[] arr = { "Checking", "Savings" };

		JList<String> options = new JList<>(arr);

		JScrollPane scrOptions = new JScrollPane(options);

		scrOptions.setPreferredSize(new Dimension(70, 20));

		scrOptions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		myPanel.add(scrOptions, gbc);

		JButton myButton = new JButton("submit");

		gbc.gridx = 0;

		gbc.gridy = 4;

		myPanel.add(myButton, gbc);

		myButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				double balance = Double.parseDouble(txtDeposit.getText());
				boolean isChecking = false;
				if (options.getSelectedValue().equals("Checking")) {
					isChecking = true;
				} else if (options.getSelectedValue().equals("Savings")) {
					isChecking = false;
				}

				for (int i = 0; i < MainScreen.allAccounts.size(); i++) {
					if (!isChecking && MainScreen.allAccounts.get(i) instanceof CheckingAccount)
					{
						continue;
					}
					if (isChecking && MainScreen.allAccounts.get(i) instanceof SavingsAccount)
					{
						continue;
					}
					if (MainScreen.allAccounts.get(i).getName().equals(txtName.getText())) {
						MainScreen.allAccounts.get(i).withdraw(Double.parseDouble(txtDeposit.getText()));
					}
				}
			}

		});



	}



}
