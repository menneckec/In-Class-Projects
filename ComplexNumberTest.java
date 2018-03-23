package uwstout.cs145.labs.lab01;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexNumberTest {

	private final static double DELTA = 0.001;

	@Test
	public void testComplexNumberDouble() {
		ComplexNumber comp = new ComplexNumber(1.234);

		assertEquals(1.234, comp.getReal(), DELTA);
		assertEquals(0, comp.getImaginary(), DELTA);

		ComplexNumber comp1 = new ComplexNumber(-1);
		assertEquals(-1, comp1.getReal(), DELTA);
		assertEquals(0, comp1.getImaginary(), DELTA);

		ComplexNumber comp2 = new ComplexNumber(0);
		assertEquals(0, comp2.getReal(), DELTA);
		assertEquals(0, comp2.getImaginary(), DELTA);
	}

	@Test
	public void testComplexNumberDoubleDouble() {
		ComplexNumber comp = new ComplexNumber(1, 2);

		assertEquals(1, comp.getReal(), DELTA);
		assertEquals(2, comp.getImaginary(), DELTA);

		ComplexNumber comp1 = new ComplexNumber(0, 0);
		assertEquals(0, comp1.getReal(), DELTA);
		assertEquals(0, comp1.getImaginary(), DELTA);

		ComplexNumber comp2 = new ComplexNumber(-2, -3);
		assertEquals(-2, comp2.getReal(), DELTA);
		assertEquals(-3, comp2.getImaginary(), DELTA);

		ComplexNumber comp3 = new ComplexNumber(-1, 1.23456);
		assertEquals(-1, comp3.getReal(), DELTA);
		assertEquals(1.23456, comp3.getImaginary(), DELTA);
	}

	@Test
	public void testComplexNumberComplexNumber() {
		ComplexNumber compL = new ComplexNumber(1, 2);
		ComplexNumber comp = new ComplexNumber(compL);

		assertEquals(1, comp.getReal(), DELTA);
		assertEquals(2, comp.getImaginary(), DELTA);

		ComplexNumber comp1 = new ComplexNumber(0, 0);
		assertEquals(0, comp1.getReal(), DELTA);
		assertEquals(0, comp1.getImaginary(), DELTA);

		ComplexNumber comp2 = new ComplexNumber(-2, -3);
		assertEquals(-2, comp2.getReal(), DELTA);
		assertEquals(-3, comp2.getImaginary(), DELTA);

		ComplexNumber comp3 = new ComplexNumber(-1, 1.23456);
		assertEquals(-1, comp3.getReal(), DELTA);
		assertEquals(1.23456, comp3.getImaginary(), DELTA);
	}

	@Test
	public void testComplexNumber() {
		ComplexNumber comp = new ComplexNumber();
		assertEquals(0, comp.getReal(), DELTA);
		assertEquals(0, comp.getImaginary(), DELTA);
	}

	@Test
	public void testSetters() {
		ComplexNumber comp = new ComplexNumber();
		comp.setReal(1);
		comp.setImaginary(2);

		assertEquals(1, comp.getReal(), DELTA);
		assertEquals(2, comp.getImaginary(), DELTA);
	}

	@Test
	public void testToString() {
		ComplexNumber comp = new ComplexNumber(1, 1);
		assertEquals("1 + 1i", comp.toString());

		ComplexNumber comp1 = new ComplexNumber(1.23456, -1);
		assertEquals("1.235 + -1i", comp1.toString());
	}

	@Test
	public void testConjugate() {
		ComplexNumber comp = new ComplexNumber(1, -2);
		ComplexNumber conj = comp.conjugate();
		assertEquals(1, conj.getReal(), DELTA);
		assertEquals(2, conj.getImaginary(), DELTA);

		ComplexNumber comp1 = new ComplexNumber(-3, 2.4);
		ComplexNumber conj1 = comp1.conjugate();
		assertEquals(-3, conj1.getReal(), DELTA);
		assertEquals(-2.4, conj1.getImaginary(), DELTA);

	}

	@Test
	public void testAdd() {
		ComplexNumber comp1 = new ComplexNumber(1, 1);
		ComplexNumber comp2 = new ComplexNumber(2, 2);
		ComplexNumber sum = comp1.add(comp2);
		assertEquals(3, sum.getReal(), DELTA);
		assertEquals(3, sum.getImaginary(), DELTA);

		ComplexNumber comp3 = new ComplexNumber(-1, 3);
		ComplexNumber comp4 = new ComplexNumber(1, -4);
		ComplexNumber sum1 = comp3.add(comp4);
		assertEquals(0, sum1.getReal(), DELTA);
		assertEquals(-1, sum1.getImaginary(), DELTA);
	}

	@Test
	public void testSubtract() {
		ComplexNumber comp1 = new ComplexNumber(5, 5);
		ComplexNumber comp2 = new ComplexNumber(2, 2);
		ComplexNumber diff = comp1.subtract(comp2);
		assertEquals(3, diff.getReal(), DELTA);
		assertEquals(3, diff.getImaginary(), DELTA);

		ComplexNumber comp3 = new ComplexNumber(0, 0);
		ComplexNumber comp4 = new ComplexNumber(1, -2);
		ComplexNumber diff1 = comp3.subtract(comp4);
		assertEquals(-1, diff1.getReal(), DELTA);
		assertEquals(2, diff1.getImaginary(), DELTA);
	}

	@Test
	public void testMultiply() {
		ComplexNumber comp1 = new ComplexNumber(1, 2);
		ComplexNumber comp2 = new ComplexNumber(3, 4);
		ComplexNumber prod = comp1.multiply(comp2);
		assertEquals(-5, prod.getReal(), DELTA);
		assertEquals(10, prod.getImaginary(), DELTA);

		ComplexNumber comp3 = new ComplexNumber(0, 1);
		ComplexNumber comp4 = new ComplexNumber(1, -2);
		ComplexNumber prod1 = comp3.multiply(comp4);
		assertEquals(2, prod1.getReal(), DELTA);
		assertEquals(1, prod1.getImaginary(), DELTA);
	}

	@Test
	public void testDivide() {
		ComplexNumber comp1 = new ComplexNumber(0.5, 1.5);
		ComplexNumber comp2 = new ComplexNumber(2, -4.5);
		ComplexNumber quot = comp1.divide(comp2);
		assertEquals(-0.237, quot.getReal(), DELTA);
		assertEquals(0.216, quot.getImaginary(), DELTA);
	}

}
