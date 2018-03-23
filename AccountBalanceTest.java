package uwstout.cs145.labs.lab02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests all methods in class AccountBalance
 * 
 * @author Carolyn
 * @version 2.20.2018
 *
 */
public class AccountBalanceTest {

	private final static double DELTA = 0.001;

	/**
	 * tests method accountBalance()
	 */
	@Test
	public void testAccountBalance() {
		AccountBalance accBal = new AccountBalance("ABC-1234", 12345);

		assertEquals(12345, accBal.getAmount(), DELTA);
		assertEquals("ABC-1234", accBal.getAccountNumber());
	}

	/**
	 * tests a bad value for AccountNumber
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		AccountBalance bad = new AccountBalance("Nope", 12);
		assertEquals(12, bad.getAmount(), DELTA);
	}

	/**
	 * tests method needsRefund()
	 */
	@Test
	public void testNeedsRefund() {
		AccountBalance accBal = new AccountBalance("ABC-1235", -50);
		assertEquals(true, accBal.needsRefund());

		AccountBalance accBal1 = new AccountBalance("ABC-1435", -2);
		assertEquals(false, accBal1.needsRefund());
	}

}
