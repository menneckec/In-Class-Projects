package uwstout.cs145.labs.lab02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests all methods in class AccountFileIO
 * 
 * @author Carolyn
 *@version 2.20.2018
 */
public class AccountFileIOTest {

	private final static double DELTA = 0.001;

	/**
	 * tests method parseFile()
	 */
	@Test
	public void testRead() {
		AccountFileIO io = new AccountFileIO();
		AccountList hist = io.parseFile("test1.txt");

		assertEquals(4, hist.getSize());
		assertEquals(-258.45, hist.getAccount(0).getAmount(), DELTA);
		assertEquals("TOB-6851", hist.getAccount(0).getAccountNumber());
		assertEquals(375.95, hist.getAccount(1).getAmount(), DELTA);
		assertEquals("JNO-1438", hist.getAccount(1).getAccountNumber());
		assertEquals(834.15, hist.getAccount(2).getAmount(), DELTA);
		assertEquals("IPO-5410", hist.getAccount(2).getAccountNumber());
		assertEquals(793.00, hist.getAccount(3).getAmount(), DELTA);
		assertEquals("PWV-5792", hist.getAccount(3).getAccountNumber());

	}

	/**
	 * tests if parseFile() returns null
	 * if the file cannot be read
	 */
	@Test
	public void testReadNotFound() {
		AccountFileIO io = new AccountFileIO();
		AccountList hist = io.parseFile("badfile.txt");

		assertNull(hist);

	}

}
