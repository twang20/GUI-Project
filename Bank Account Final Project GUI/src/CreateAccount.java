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



public class CreateAccount extends JPanel {

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

		gbc.gridwidth = 1;

		gbc.gridx = 1;

		gbc.gridy = 1;

		gbc.gridx = 0;

		gbc.gridy = 3;

		JLabel lblAccount = new JLabel("Account Type: ");

		myPanel.add(lblAccount, gbc);

		JTextField txtAccount = new JTextField("");
		
		JLabel amount = new JLabel("Amount: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		myPanel.add(amount, gbc);
		
		JTextField amtInput = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 4;
		amtInput.setPreferredSize(new Dimension(70, 20));
		myPanel.add(amtInput,gbc);
		String[] arr = { "Checking", "Savings" };

		JList<String> options = new JList<>(arr);

		JScrollPane scrOptions = new JScrollPane(options);

		scrOptions.setPreferredSize(new Dimension(70, 20));

		scrOptions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		gbc.gridx = 1;
		gbc.gridy = 3;
		myPanel.add(scrOptions, gbc);

		JButton myButton = new JButton("submit");

		gbc.gridx = 0;

		gbc.gridy = 5;

		myPanel.add(myButton, gbc);

		myButton.addActionListener(new ActionListener() {



			@Override

			public void actionPerformed(ActionEvent e) {
				double balance = Double.parseDouble(amtInput.getText());
		
				if (options.getSelectedValue().equals("Checking")) {

					MainScreen.allAccounts.add(new CheckingAccount(txtName.getText(), balance, 1.0, 1.0, 1));

				} else if (options.getSelectedValue().equals("Savings")) {

					MainScreen.allAccounts.add(new SavingsAccount(txtName.getText(), balance, 1.0, 1.0, 1.0));

				}



			}



		});



	}



}