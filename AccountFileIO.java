package uwstout.cs145.labs.lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Opens a file and reads from it
 * 
 * @author Carolyn
 * @version 2.20.2018
 *
 */
public class AccountFileIO {

	/**
	 * Reads from a file
	 * 
	 * @param fileName
	 *            the name of the file
	 * @return a list of all the items found in the file
	 */
	public AccountList parseFile(String fileName) {
		// Create history
		AccountList hist = new AccountList();
		// Create Scanner
		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			// handle errors

			// read file
			while (input.hasNext()) {
				// read item
				String line = input.nextLine();
				Scanner lineInput = new Scanner(line);

				// too much info
				try {
					String accNum = lineInput.next();
					double bal = lineInput.nextDouble();

					// add to history
					hist.add(accNum, bal);
				} catch (Exception e) {
					// do nothing
				}
				lineInput.close();
			}

			// close file
			input.close();

		} catch (FileNotFoundException e) {
			return null;
		}

		// return history
		return hist;
	}
}
