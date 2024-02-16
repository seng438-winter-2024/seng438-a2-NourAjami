package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeGetLengthTest {

	Range rangeInTest;

	// Beginning of Tests
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// calls the setUpBefore and does nothing
	}

	//Test to verify that the length between 2 equal ranges is 0
	@Test
	public void getLengthZeroTest() {
		rangeInTest = new Range(10.0, 10.0);
		assertEquals("The length of this range should be 0.0", 0, rangeInTest.getLength(), .000000001d);

	}

	//Test to verify that the length between 2 different positive ranges is positive
	@Test
	public void getPositiveLengthTest() {
		rangeInTest = new Range(5.0, 20.0);
		assertEquals("The length of this range should be ", 15, rangeInTest.getLength(), .000000001d);
	}

	//Test to verify that the length between 2 different negative ranges is negative
	@Test
	public void getNegativeLengthTest() {
		rangeInTest = new Range(-50.0, -10);
		assertEquals("The length of this range should be ", 40, rangeInTest.getLength(), .000000001d);
	}

	//Test to verify that the length between 2 different non decimal ranges (positive and negative) is a non decimal
	@Test
	public void getRangeLengthNonDecimal() {
		rangeInTest = new Range(-60, 100);
		assertEquals("The length of this range should be ", 160, rangeInTest.getLength(), .000000001d);

	}

	//Test to verify that the length between 2 different decimal ranges (positive and negative) is a decimal length
	@Test
	public void getRangeLengthDecimal() {
		rangeInTest = new Range(-70.5, 10.2);
		assertEquals("The length of this range should be ", 80.7, rangeInTest.getLength(), .000000001d);
	}

}
