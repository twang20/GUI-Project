/**
 * 
 * @author Tony Wang
 *a subclass: SavingsAccount that inherits fields and methods from the superclass
 */
public class SavingsAccount extends BankAccount
{
	// fields 
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	// constructor that initializes the fields
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n,b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		this(n,0,r,mb,mbf);
	}
	/*
	 * 
	 * method that withdraws money (amt) if the balance minus the amount is more than or equal to the minimum balance
	 * if the balance minus the amount is less than the minimum balance, charge a minimum balance fee
	 * if requirements are not met, throw an illegal argument exception
	 */
	public void withdraw(double amt) 
	{
        if(getBalance() < 0||amt < 0)
        {
            throw new IllegalArgumentException();
        }
        if(getBalance()-amt >= MIN_BAL) 
        {
            super.withdraw(amt);
        }
        else if (getBalance()-amt < MIN_BAL)
        {
            super.withdraw(amt + MIN_BAL_FEE);
        }
	}
	/**
	 * a method that transfers money into the other account if the names of the two match, and all requirements are matched based on the method in the CheckingAccount 
	 * except there is no transaction fee
	 */
	public void transfer (BankAccount other, double amt)
	{
		if (other.getName().equals(this.getName()))
			{
				if(this.getBalance()-amt < 0 || amt < 0 || !other.getName().equals(this.getName())) 
					throw new IllegalArgumentException();
				else {
					this.withdraw(amt);
					other.deposit(amt);
			   }
			}
	}
	/**
	 * adds intrest to the account
	 */
	public void addInterest()
	{
		super.deposit(getBalance() * intRate);
	}
	/**
	 * uses the addInterest method
	 */
	public void endOfMonthUpdate()
	{
		addInterest();
	}
	
}
