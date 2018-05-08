/**
 * 
 * @author Tony Wang
 * Super class of BankAccount Program
 */
public abstract class BankAccount { 
	//instance variables
		private static int nextAccNum;
		private String name;
		private int accNum;
		private double balance;
		//constructors - initializes the fields
		public BankAccount(String n)
		{
			this(n, 0);
		}
		public BankAccount(String n, double b)
		{
			name = n;
			nextAccNum ++;
			accNum=nextAccNum;
			balance = b;
		}
		//methods 
		/**
		 * adds money(amt) into the bank account
		 * @param amt
		 */
		public void deposit(double amt)
		{
			balance += amt;
		}
		/**
		 * takes away money(amt) from the bank account
		 * @param amt
		 */
		public void withdraw(double amt)
		{
			balance -= amt;
		}
		/**
		 * 
		 * @returns the name of the user
		 */
		public String getName()
		{
			return name;
		}
		/**
		 * 
		 * @returns the balance the user has
		 */
		public double getBalance()
		{
			return balance;
		}
		public int getAccountNumber()
		{
			return accNum;
		}
		// abstract methods
		/**
		 * abstract method that essentially resets at the end of the month 
		 */
		public abstract void endOfMonthUpdate();
		/**
		 * abstract transferring money method
		 * @param other
		 * @param amt
		 */
		public abstract void transfer(BankAccount other, double amt);
		/**
		 * 
		 * @returns the account number, name and balance that the user has
		 */
		public String toString()
		{
			return "The account number is: " + accNum + " The name is: " + name + " The balance is " + balance;
		}
				

	}
