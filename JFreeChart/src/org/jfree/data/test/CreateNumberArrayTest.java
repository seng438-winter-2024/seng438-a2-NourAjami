package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities; 
import org.junit.*;
import org.junit.Test;


public class CreateNumberArrayTest extends DataUtilities {
		
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {}
	
	
	/**
	 * This test will pass a null double[] array to createNumberArray()
	 * 
	 * Expects: IllegalArgumentException to be thrown
	 */
	@Test (expected = IllegalArgumentException.class)
	public void createNumberArrayWithNullArray() {
		double[] inputArray = null;
		DataUtilities.createNumberArray(inputArray);
	}
	
	/**
	 * This test will pass a empty double[] array to createNumberArray()
	 * 
	 * Expects: Returns a empty Number array
	 */
	@Test
	public void createNumberArrayEmpty() {
		Number[] expectedArray = {};		
		double[] inputArray = {};		
		Number[] createdArray = DataUtilities.createNumberArray(inputArray);
		assertArrayEquals(expectedArray, createdArray);
	}
	
	/**
	 * This test will pass a double[] array with positive values to createNumberArray()
	 * 
	 * Expects: Returns a Number array with the correct values
	 */
	@Test
	public void createNumberArrayPositiveValues() {
		Number[] expectedArray = {10.0}; 	
		double[] inputArray = {10.0};
		Number[] createdArray = DataUtilities.createNumberArray(inputArray);

		assertArrayEquals(expectedArray,createdArray);
	}
	
	/**
	 * This test will pass a double[] array with negative values to createNumberArray()
	 * 
	 * Expects: Returns a Number array with the correct values
	 */
	@Test
	public void createNumberArrayNegativeValues() {
		Number[] expectedArray = {-20.0}; 	
		double[] inputArray = {-20.0};
		Number[] createdArray = DataUtilities.createNumberArray(inputArray);

		assertArrayEquals(expectedArray,createdArray);
	}
	
	 @After
	 public void tearDown() throws Exception {}

     @AfterClass
     public static void tearDownAfterClass() throws Exception {}	
}