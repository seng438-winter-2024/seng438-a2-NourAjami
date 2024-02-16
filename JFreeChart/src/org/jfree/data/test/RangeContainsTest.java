package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeContainsTest {

	private Range usedRange;

	@Before
	public void setUp() throws Exception {
		usedRange = new Range(0.0, 20.0);
	}

	//Test to verify if range contains a number that is less than the lower bound
	@Test
	public void numberLessThanLowerBoundTest() {
		boolean result = usedRange.contains(-10);
		assertEquals("This number is outside the lower bound", false, result);
	}

	//Test to verify if range contains a number that is greater than the upper bound
	@Test
	public void numberGreaterThanUpperBoundTest() {
		boolean result = usedRange.contains(24.0);
		assertEquals("This number is outside the upperbound", false, result);
	}

	//Test to verify if range contains a number that is on the lower bound
	@Test
	public void numberOnLowerBoundTest() {
		boolean result = usedRange.contains(0.0);
		assertEquals("This number is on the lower bound and therefore contained in the range", true, result);
	}

	//Test to verify if range contains a number that is on the upper bound
	@Test
	public void numberOnUpperBoundTest() {
		boolean result = usedRange.contains(20.0);
		assertEquals("The number is on the upper bound and therefore contained in the range", true, result);
	}

	//Test to verify if range contains a number that is in the nominal range (between lower and upper bounds)
	@Test
	public void numberInNominalRangeTest() {
		boolean result = usedRange.contains(10.0);
		assertEquals("This number should be in the middle of the range", true, result);
	}

	//Test to verify if range contains a number that is below the upper bound
	@Test
	public void numberBelowUpperBoundTest() {
		boolean result = usedRange.contains(19.0);
		assertEquals("This number is just below the upper bound and contained in the range", true, result);
	}

	//Test to verify if range contains a number that is above the lower bound
	@Test
	public void numberAboveLowerBoundTest() {
		boolean result = usedRange.contains(1.0);
		assertEquals("This number is just above the lower bound and contained in the range", true, result);
	}

	// End of Tests
	@After
	public void tearDown() throws Exception {
	}

}
