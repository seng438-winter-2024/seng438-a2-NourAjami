package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeLowerBoundTest {
    private Range posRange;
    private Range negRange;
    private Range sameRange;
    
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	//exampleRange = new Range(-1, 1);
    	posRange = new Range(2,4);
    	negRange = new Range(-4,-2);
    	sameRange = new Range(2,2);
    }

    @Test
    public void testLowerBoundPositive() {
        assertEquals("The lower bound of the range [2,4] should be 2",
        2, posRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void testLowerBoundNegative() {
        assertEquals("The lower bound of the range [-4,-2] should be -4",
        -4, negRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void testLowerBoundSame() {
        assertEquals("The lower bound of the range [2,2] should be 2",
        2, sameRange.getLowerBound(), .000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
