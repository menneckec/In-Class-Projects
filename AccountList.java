package uwstout.cs145.labs.lab02;

/**
 * Store multiple AccountBalance objects and perform calculations on them
 * 
 * @author Carolyn
 * @version 2.20.2018
 */
public class AccountList {
	private AccountBalance[] accBal;
	private int counter;

	/**
	 * Creates a new array to store all the AccountBalances
	 * 
	 */
	public AccountList() {
		accBal = new AccountBalance[3];
		counter = 0;
	}

	/**
	 * Gets the number of items currently in the array
	 * 
	 * @return number of items in array
	 */
	public int getSize() {
		return counter;
	}

	/**
	 * Gets a specified AccountBalance in the array
	 * 
	 * @param pos
	 *            an integer that determines position
	 * @return specified AccountBalance
	 */
	public AccountBalance getAccount(int pos) 
			throws IllegalArgumentException {
		if (pos >= 0 && pos < counter) {
			return accBal[pos];
		} else {
			throw new IllegalArgumentException("Position not valid.");
		}

	}

	/**
	 * Adds new AccountBalance object to the array 
	 * Expands the array if necessary
	 * 
	 * 
	 * @param accNum
	 *            a string indicating account number
	 * 
	 * @param bal
	 *            a double indicating account balance
	 */
	public void add(String accNum, double bal) {
		if (counter == accBal.length) {
			AccountBalance[] temp = new AccountBalance[accBal.length + 2];

			for (int i = 0; i < accBal.length; i++) {
				temp[i] = accBal[i];
			}
			accBal = temp;
		}

		accBal[counter] = new AccountBalance(accNum, bal);
		counter++;
	}

	/**
	 * Gets the total of all AccountBalance objects in the array
	 * 
	 * @return the sum of all refunds
	 */
	public double getTotal() {
		double sum = 0;

		for (int i = 0; i < counter; i++) {
			sum += accBal[i].getAmount();
			getRefundTotal();
		}

		return sum;
	}

	/**
	 * Determines how much total refund is needed
	 * 
	 * @return the total refund
	 */
	public double getRefundTotal() {
		double refSum = 0;
		for (int i = 0; i < counter; i++) {
			if (accBal[i].needsRefund()) {
				refSum += accBal[i].getAmount();
			}
		}
		return refSum;
	}

	/**
	 * Finds a specific AccountBalance within the array
	 * 
	 * @param accountBal
	 *            An AccountBalance string that should match one in the array
	 * @return Either the matching object or null
	 */
	public AccountBalance findBalance(String accountBal) {
		for (int i = 0; i < counter; i++) {
			if (accBal[i].getAccountNumber().equals(accountBal)) {
				return accBal[i];
			}
		}
		return null;
	}

}
