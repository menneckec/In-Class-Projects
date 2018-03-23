package uwstout.cs145.labs.lab02;

/**
 * Associates account number and balance, and determines whether a refund is
 * needed
 * 
 * @author Carolyn
 * @version 2.20.2018
 *
 */
public class AccountBalance {
	private double balance;
	private String accountNumber;

	/**
	 * Constructor
	 * 
	 * @param nBalance
	 *            the balance of the account
	 * @param nAccNum
	 *            the account number
	 */
	public AccountBalance(String nAccNum, double nBalance) 
			throws IllegalArgumentException {
		if (nAccNum == null || nAccNum.length() != 8) {
			throw new IllegalArgumentException("Account number needs to be 8 characters");
		} else {
			balance = nBalance;
			accountNumber = nAccNum;
		}
	}

	/**
	 * Gets the account number
	 * 
	 * @return account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Gets the balance
	 * 
	 * @return balance
	 */
	public double getAmount() {
		return balance;
	}

	/**
	 * Determines whether a refund is needed
	 * 
	 * @return a boolean that indicates whether a refund is needed
	 */
	public boolean needsRefund() {
		return (balance <= -25);

	}
}
