/**
 * 
 * @author Tony Wang the class CheckingAccount is a subclass of the superclass,
 *         BankAccount
 */
public class CheckingAccount extends BankAccount {
	/**
	 * instance variables (fields)
	 */
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	private int numTransactions;

	// constructors that initialize the fields
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans) {
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		
	}

	public CheckingAccount(String n, double odf, double tf, int freeTrans) {
		this(n, 0, odf, tf, freeTrans);
	}

	/**
	 * method that deposits money(amt) into the bank account, only if the money
	 * deposited is positive or 0. If not, an exception is thrown. If the number of
	 * transactions goes over the number of free transactions, a transaction fee is
	 * deducted from the deposited amount increases the number of transactions by 1
	 * every time
	 */
	public void deposit(double amt) {
		if (amt < 0) {
			throw new IllegalArgumentException();
		}
		if (numTransactions > FREE_TRANS) {
			super.deposit(amt - TRANSACTION_FEE);
		} else if (amt >= 0) {
			super.deposit(amt);
		}
		numTransactions++;
	}

	/**
	 * essentially does the same thing as the deposit method, but withdraws money
	 * (amt) from the account if it is more than 0, if not, throws exception if the
	 * number of transactions is more than the number of free transactions
	 * available, user withdraws the amount plus the transaction fee
	 */
	public void withdraw(double amt) {
		if (amt < 0) {
			throw new IllegalArgumentException();
		}
		if (numTransactions > FREE_TRANS) {
			super.withdraw(amt + TRANSACTION_FEE);
		} else if (amt >= 0) {
			super.withdraw(amt);
		}
	}

	/**
	 * method that essentially transfers money into the other account if the name of both accounts match and balance minus amount is more or equal to zero
	 * if not, throws exception
	 * if the number of transactions is more than the number of free transactions, withdraw transaction fee from account
	 */
	public void transfer (BankAccount other, double amt)
	{
				if(this.getBalance()-amt<0 || amt < 0 || other.getName().equals(this.getName())) 
					throw new IllegalArgumentException();
				else {
					this.withdraw(amt);
					other.deposit(amt);
			   }
			if(numTransactions>FREE_TRANS)

	{
		super.withdraw(TRANSACTION_FEE);
	}
	}

	/**
	 * resets the number of transactions to zero
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
}
