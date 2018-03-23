package uwstout.cs145.labs.lab02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests all methods in class AccountList
 * 
 * @author Carolyn
 * @version 2.20.2018
 */
public class AccountListTest {

	private static final AccountBalance[] VALUES = { 
		new AccountBalance("ABC-1234", 56.70),
		new AccountBalance("BRS-3777", 10.10), 
		new AccountBalance("MLI-6484", 69.55),
		new AccountBalance("UTC-7515", -25.00), 
		new AccountBalance("TEF-3548", 451.65),
		new AccountBalance("POG-7557", -50.15) };

	private final static double DELTA = 0.001;

	/**
	 * Tests method add()
	 */
	@Test
	public void testAdd() {
		AccountList list = new AccountList();
		// fill list with data
		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}

		// check if the list was built correctly
		assertEquals(VALUES.length, list.getSize());
		for (int i = 0; i < list.getSize(); i++) {
			assertEquals(VALUES[i].getAccountNumber(),
					list.getAccount(i).getAccountNumber());
			assertEquals(VALUES[i].getAmount(),
					list.getAccount(i).getAmount(), DELTA);
		}
	}

	/**
	 * Tests method getTotal()
	 */
	@Test
	public void testGetTotal() {
		AccountList list = new AccountList();
		// fill list with data
		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}

		assertEquals(512.85, list.getTotal(), DELTA);
	}

	/**
	 * Tests method getRefundTotal()
	 */
	@Test
	public void testGetRefundTotal() {
		AccountList list = new AccountList();
		// fill list with data
		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}

		assertEquals(-75.15, list.getRefundTotal(), DELTA);
	}

	/**
	 * Tests method findBalance()
	 */
	@Test
	public void testFindBalance() {
		AccountList list = new AccountList();
		// fill list with data
		for (int i = 0; i < VALUES.length; i++) {
			list.add(VALUES[i].getAccountNumber(), VALUES[i].getAmount());
		}

		assertEquals(VALUES[0].getAccountNumber(), 
				list.findBalance("ABC-1234").getAccountNumber());
		assertEquals(56.70, list.findBalance("ABC-1234").getAmount(), DELTA);
	}

}
