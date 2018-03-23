package uwstout.cs145.labs.lab01;

import java.text.DecimalFormat;

/**
 * Represents a complex number
 * 
 * 
 * @author Carolyn Mennecke
 * @version 2018.1.23
 * 
 */
public class ComplexNumber {

	// Data
	// Class variables should be private
	private double real;
	private double imaginary;

	/**
	 * Constructs complex numbers, setting the imaginary portion to 0
	 * 
	 * 
	 * @param nReal
	 *            the user's input for the real portion
	 */
	public ComplexNumber(double nReal) {
		imaginary = 0;
		real = nReal;
	}

	/**
	 * Constructs complex numbers, allowing the user to set both the real and
	 * imaginary portions.
	 * 
	 * @param nReal
	 *            the user's input for the real portion
	 * @param nImaginary
	 *            the user's input for the imaginary portion
	 */
	public ComplexNumber(double nReal, double nImaginary) {
		real = nReal;
		imaginary = nImaginary;
	}

	/**
	 * Copy constructor
	 * 
	 * @param complex
	 *            a class value that stores the real and imaginary portions into one
	 *            complex number
	 */
	public ComplexNumber(ComplexNumber complex) {
		real = complex.real;
		imaginary = complex.getImaginary();
	}

	/**
	 * Default constructor
	 */
	public ComplexNumber() {
		real = 0;
		imaginary = 0;
	}

	/**
	 * Getter for the real portion
	 * 
	 * @return the real portion
	 */
	public double getReal() {
		return real;
	}

	/**
	 * Getter for the imaginary portion
	 * 
	 * @return the imaginary portion
	 */
	public double getImaginary() {
		return imaginary;
	}

	/**
	 * Setter for the real portion
	 * 
	 * @param nReal
	 *            the user's input for the real portion
	 */
	public void setReal(double nReal) {
		real = nReal;
	}

	/**
	 * Setter for the imaginary portion
	 * 
	 * @param nImaginary
	 *            the user's input for the imaginary portion
	 */
	public void setImaginary(double nImaginary) {
		imaginary = nImaginary;
	}

	/**
	 * Converts the real and imaginary portions to a string value
	 * 
	 * @return Formatted string value
	 */
	public String toString() {
		String str;
		DecimalFormat fmt = new DecimalFormat("#.###");
		str = fmt.format(real) + " + " + fmt.format(imaginary) + "i";
		return str;
	}

	/**
	 * Returns the conjugate of a complex number
	 * 
	 * @return conjugate
	 */
	public ComplexNumber conjugate() {
		double pReal = real;
		double pImaginary = imaginary * (-1);
		ComplexNumber conj = new ComplexNumber(pReal, pImaginary);

		return conj;
	}

	/**
	 * Adds two complex numbers
	 * 
	 * @param op
	 *            a second complex number
	 * @return the sum
	 */
	public ComplexNumber add(ComplexNumber op) {
		double pReal = real + op.getReal();
		double pImaginary = imaginary + op.getImaginary();
		ComplexNumber sum = new ComplexNumber(pReal, pImaginary);

		return sum;
	}

	/**
	 * Subtracts two complex numbers
	 * 
	 * @param op
	 *            a second complex number
	 * @return the difference
	 */
	public ComplexNumber subtract(ComplexNumber op) {
		double pReal = real - op.getReal();
		double pImaginary = imaginary - op.getImaginary();
		ComplexNumber diff = new ComplexNumber(pReal, pImaginary);

		return diff;
	}

	/**
	 * Multiplies two complex numbers
	 * 
	 * @param op
	 *            a second complex number
	 * @return the product
	 */
	public ComplexNumber multiply(ComplexNumber op) {
		double pReal = (real * op.getReal()) - (imaginary * op.getImaginary());
		double pImaginary = (imaginary * op.getReal()) + (real * op.getImaginary());
		ComplexNumber prod = new ComplexNumber(pReal, pImaginary);

		return prod;
	}

	/**
	 * Divides two complex numbers
	 * 
	 * @param op
	 *            a second complex number
	 * @return the quotient
	 */
	public ComplexNumber divide(ComplexNumber op) {
		double a1 = real;
		double b1 = imaginary;

		double a2 = op.getReal();
		double b2 = op.getImaginary();
		double pReal = ((a1 * a2) + (b1 * b2)) / ((a2 * a2) + (b2 * b2));

		double pImaginary = ((b1 * a2) - (a1 * b2)) / ((a2 * a2) + (b2 * b2));

		ComplexNumber div = new ComplexNumber(pReal, pImaginary);

		return div;
	}

}