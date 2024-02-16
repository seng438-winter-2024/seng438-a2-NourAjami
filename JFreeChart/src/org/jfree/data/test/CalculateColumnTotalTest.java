package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities; 
import org.junit.*;
import org.junit.Test;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;


public class CalculateColumnTotalTest extends DataUtilities {
	
	
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
	 * This test will pass a null object to calculateColumnTotal() with a column number of 0.
	 * 
	 * Expects: An IllegalArgumentException is thrown.
	 */
    @Test (expected = InvalidParameterException.class)
	public void calculateColumnTotalWithNullDataTable() {   
	    DataUtilities.calculateColumnTotal(null, 0);
    }
     
    /**
	 * This test will pass a valid data table object to calculateColumnTotal() with a
	 * column number of 10, which is greater then number of columns in the data table.
	 * 
	 * Expects: An IllegalArgumentException is thrown.
	 */
	@Test (expected = InvalidParameterException.class)
	public void calculateColumnTotalForOutOfRangeColumnIndex() {	
		
		double result = DataUtilities.calculateColumnTotal(values, 10);		
		assertEquals("Sum of a out of bounds column index should be 0", 0.0 , result, .000000001d);
	}
	
	/**
	 * This test will pass a valid data table object to calculateColumnTotal() with a column number of -2.
	 * 
	 * Expects: An IllegalArgumentException is thrown.
	 */
	@Test (expected = InvalidParameterException.class)
	public void calculateColumnTotalForNegativeColumnIndex() {
		
		double result = DataUtilities.calculateColumnTotal(values, -2);	
		assertEquals("Sum of a negative column index should be 0", 0.0 , result, .000000001d);
	}
	
	/**
	 * This test will pass a valid data table object to calculateColumnTotal() with a column number of 0.
	 * 
	 * This will test the sum of column values, for the first column.
	 * 
	 * Expects: The correct sum for the given column.
	 */
	@Test
	public void calculateColumnTotalForFirstIndex() {
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(9.0, result, .000000001d);
	}
	
	/**
	 * This test will pass a valid data table object to calculateColumnTotal() with a column number of 1.
	 * 
	 * This will test the sum of column values, for a column between the 2 boundary columns.
	 * 
	 * Expects: The correct sum for the given column.
	 */
	@Test
	public void calculateColumnTotalForMiddleIndex() {
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(8.0, result, .000000001d);
	}
	
	
	/**
	 * This test will pass a valid data table object to calculateColumnTotal() with a column number of 2.
	 * 
	 * This will test the sum of column values, for the final column.
	 * 
	 * Expects: The correct sum for the given column.
	 */
	@Test
	public void calculateColumnTotalForFinalIndex() {
		double result = DataUtilities.calculateColumnTotal(values, 2);
		assertEquals(-27.0, result, .000000001d);
	}
	
	 @After
	 public void tearDown() throws Exception {}

     @AfterClass
     public static void tearDownAfterClass() throws Exception {}	
}