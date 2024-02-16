package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.jfree.data.DataUtilities; 
import org.junit.*;
import org.junit.Test;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;


public class CalculateRowTotalTest extends DataUtilities {
		
	public Mockery mockingContext;
	private Values2D values;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {}
	
    @Before
    public void setUp() {
    	
    	// setup
	     mockingContext = new Mockery();
	     
	     values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() 
	     {
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             
	             one(values).getColumnCount();
	             will(returnValue(3));
	             
	             // [ 2, -3 , -6]
	             // [ 3, 2 , -9]
	             // [ 4, 9 , -12]
	             
	             one(values).getValue(0, 0);
	             will(returnValue(2.0));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(-3.0));
	             
	             one(values).getValue(0, 2);
	             will(returnValue(-6.0));

	             one(values).getValue(1, 0);
	             will(returnValue(3.0));
	             
	             one(values).getValue(1, 1);
	             will(returnValue(2.0));
	             
	             one(values).getValue(1, 2);
	             will(returnValue(-9.0));
	             
	             one(values).getValue(2, 0);
	             will(returnValue(4.0));
	             
	             one(values).getValue(2, 1);
	             will(returnValue(9.0));
	             
	             one(values).getValue(2, 2);
	             will(returnValue(-12.0));

	         }
	     }
	     );  	
    }
    
	
	 /**
		 * This test will pass a null object to calculateRowTotal() with a row number of 1.
		 * 
		 * Expects: An IllegalArgumentException is thrown.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void calculateRowTotalWithNullDataObject() {
		DataUtilities.calculateRowTotal(null, 1);
	}
	
	/**
	 * This test will pass a valid data table object to calculateRowTotal() with a
	 * row number of 5, which is greater then number of rows in the data table.
	 * 
	 * Expects: An IllegalArgumentException is thrown.
	 */
	@Test (expected = InvalidParameterException.class)
	public void calculateRowTotalForOutOfRangeRowIndex() {	
		
		double result = DataUtilities.calculateRowTotal(values, 5);		
		assertEquals("Sum of a out of bounds row index should be 0", 0.0 , result, .000000001d);
	}
	
	/**
	 * This test will pass a valid data table object to calculateRowTotal() with a row number of -1.
	 * 
	 * Expects: An IllegalArgumentException is thrown.
	 */
	@Test (expected = InvalidParameterException.class)
	public void calculateRowTotalForNegativeRowIndex() {
		
		double result = DataUtilities.calculateRowTotal(values, -1);	
		assertEquals("Sum of a negative row index should be 0", 0.0 , result, .000000001d);
	}
	
	/**
	 * This test will pass a valid data table object to calculateRowTotal() with the first row index (0).
	 * 
	 * This will test the sum of the row values in the first row.
	 * 
	 * Expects: The correct sum for the given row.
	 */
	@Test 
   	public void calculateRowTotalForFirstRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 0);
    	assertEquals("Sum of the row at the first index is",  -7.0, result, .000000001d);
    }

	/**
	 * This test will pass a valid data table object to calculateRowTotal() with a in between row index (1).
	 * 
	 * This will test the sum of the row values in a middle row.
	 * 
	 * Expects: The correct sum for the given row.
	 */
	@Test 
   	public void calculateRowTotalForMiddleRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 1);
    	assertEquals("Sum of the row at the middle index is",  -5, result, .000000001d);
    }

	/**
	 * This test will pass a valid data table object to calculateRowTotal() with the final row index (2).
	 * 
	 * This will test the sum of the row values for the final row.
	 * 
	 * Expects: The correct sum for the given row.
	 */
	@Test 
   	public void calculateRowTotalForLastRowIndex() {
    	double result= DataUtilities.calculateRowTotal(values, 2);
    	assertEquals("Sum of the row at the last index is",  1, result, .000000001d);
    }	
	
	 @After
	 public void tearDown() throws Exception {}

     @AfterClass
     public static void tearDownAfterClass() throws Exception {}	
}