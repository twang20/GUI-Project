import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuListener;

public class MainScreen extends JFrame {
	public static ArrayList<BankAccount> allAccounts = new ArrayList<BankAccount>();
	public static void main(String[] args) {
		CardLayout cl = new CardLayout();
		JPanel mainPanel = new JPanel(cl);
		JMenu accMenu = new JMenu();
		JFrame myFrame = new JFrame();
		myFrame.setBounds(440, 240, 600, 400);
		JPanel myPanel = new JPanel();
		myPanel.setBounds(440, 240, 500, 300);
		myFrame.setLayout(new BorderLayout());
		myFrame.add(BorderLayout.CENTER, myPanel);

		BufferedImage bankjpg = null;
		try{
		    bankjpg = ImageIO.read(new File("bankAccount.jpg"));
		}
		catch(IOException e) {
		    e.printStackTrace();
		}
		JLabel bankImage = new JLabel(new ImageIcon("bankAccount.jpg"));
		bankImage.setSize(100,100);
		bankImage.setLocation(250,150);
		myPanel.add(bankImage);

		
		JLabel welcome = new JLabel("Welcome to Our Bank Account Management System");
		welcome.setBounds(145, 120, 300, 25);
		myPanel.add(welcome);

		JMenuBar mBar = new JMenuBar();
		JMenu acc = new JMenu("Account");
		JMenu trans = new JMenu("Transaction");
		JMenuItem home = new JMenuItem("Home");
		JMenuItem crAcc = new JMenuItem("Create Account");
		JMenuItem remAcc = new JMenuItem("Remove Account");
		JMenuItem findAcc = new JMenuItem("Find Accounts");

		JMenuItem dep = new JMenuItem("Deposit");
		JMenuItem with = new JMenuItem("Withdraw");
		JMenuItem transf = new JMenuItem("Transfer");
		JMenuItem gBal = new JMenuItem("Get Balance");

		mBar.add(acc);
		mBar.add(trans);
		mBar.add(home);
		acc.add(crAcc);
		acc.add(remAcc);
		acc.add(findAcc);

		trans.add(dep);
		trans.add(with);
		trans.add(transf);
		trans.add(gBal);
		
		Deposit depositPanel = new Deposit();
		depositPanel.setUp();
		mainPanel.add(depositPanel, "Deposit");
		mainPanel.add(myPanel, "Home"); 
		cl.show(mainPanel, "Home");
		
		Withdraw withdrawPanel = new Withdraw();
		withdrawPanel.setUp();
		mainPanel.add(withdrawPanel, "Withdraw");
		
		FindAccounts findPanel = new FindAccounts();
		findPanel.setUp();
		mainPanel.add(findPanel, "Find Accounts");
		
		GetBalance balancePanel  = new GetBalance();
		balancePanel.setUp();
		mainPanel.add(balancePanel, "Get Balance");
		
		RemoveAccount removePanel  = new RemoveAccount();
		removePanel.setUp();
		mainPanel.add(removePanel, "Remove Account");
		
		Transfer transferPanel  = new Transfer();
		transferPanel.setUp();
		mainPanel.add(transferPanel, "Transfer Account");
		
		CreateAccount createPanel  = new CreateAccount();
		createPanel.setUp();
		mainPanel.add(createPanel, "Create Account");
		
		dep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 cl.show(mainPanel, "Deposit");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});

		crAcc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 cl.show(mainPanel, "Create Account");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});
		with.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 cl.show(mainPanel, "Withdraw");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});
		findAcc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FindAccounts findPanel = new FindAccounts();
				findPanel.setUp();
				mainPanel.add(findPanel, "Find Accounts");
				 cl.show(mainPanel, "Find Accounts");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});
		gBal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GetBalance balancePanel  = new GetBalance();
				balancePanel.setUp();
				mainPanel.add(balancePanel, "Get Balance");
				 cl.show(mainPanel, "Get Balance");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});
		remAcc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 cl.show(mainPanel, "Remove Account");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});
		transf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 cl.show(mainPanel, "Transfer Account");
				 myFrame.revalidate();
				 myFrame.repaint();

			}});
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 cl.show(mainPanel, "Home");
				 myFrame.revalidate();
				 myFrame.repaint();
			}});
		myFrame.add(mainPanel);
		myFrame.setJMenuBar(mBar);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
	}
}

