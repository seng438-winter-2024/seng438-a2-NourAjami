package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeUpperBoundTest {
    private Range posRange;
    private Range negRange;
    private Range sameRange;
    
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	posRange = new Range(2.0,4.0);
    	negRange = new Range(-4.0,-2.0);
    	sameRange = new Range(2.0,2.0);
    }

    @Test
    public void testUpperBoundPositive() {
        assertEquals("The upper bound of the range [2,4] should be 4",
        4.0, posRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void testUpperBoundNegative() {
        assertEquals("The upper bound of the range [-4,-2] should be -2",
        -2.0, negRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void testUpperBoundSame() {
        assertEquals("The upper bound of the range [2,2] should be 2",
        2.0, sameRange.getUpperBound(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
