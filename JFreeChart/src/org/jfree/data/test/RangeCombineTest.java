package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeCombineTest {

	private Range exampleRange;

	// Beginning of Tests
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// calls the setUpBefore and does nothing
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}

	/* Testing combine method when range1 is null */
	@Test
	public void range1IsNullTest() {
		assertEquals("The combined ranges of [null] and [2,4] should be [2,4] ", new Range(2, 4),
				Range.combine(null, new Range(2, 4)));
	}

	/* Testing combine method when range2 is null */
	@Test
	public void range2IsNullTest() {
		assertEquals("The combined ranges of  [2,4] and [null] should be [2,4]", new Range(2, 4),
				Range.combine(new Range(2, 4), null));
	}

	@Test
	public void bothRangesNullTest() {
		assertEquals("The combined ranges of [null] and [null] should be [null]", null, Range.combine(null, null));
	}

	/*
	 * Testing combine method when range1 and range2 are continuous This method is
	 * not working and failing
	 */

	@Test
	public void continuousRangeTest() {
		assertEquals("The combined overlapping/continuous ranges of [0,3] and [3,4] should be [0,4]", new Range(0, 4),
				Range.combine(new Range(0, 3), new Range(3, 4)));
	}

	/*
	 * Testing combine method when range1 and range2 are discontinuous This method
	 * is not working and failing
	 */
	@Test
	public void discontinuousRangeTest() {
		assertEquals("The combines non-overlapping/discontinuous ranges of [0,5] and [8,15] should be [0,15]",
				new Range(0, 15), Range.combine(new Range(0, 5), new Range(8, 15)));
	}

	// End of Tests
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
