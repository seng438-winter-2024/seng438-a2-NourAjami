package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.jmock.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.junit.Test;

public class GetCumulativePercentagesTest {

	private KeyedValues values;

	@Before
	public void setUp() throws Exception {
		Mockery context1 = new Mockery();
		values = context1.mock(KeyedValues.class);
		
		List<Integer> keys = new ArrayList<>();
		Collections.addAll(keys, 0, 1, 2);
		
		context1.checking(new Expectations() {
	        {
	        	//getItemCount
	        	allowing(values).getItemCount();
	        	will(returnValue(keys));
	        	
	        	//getKeys
	        	allowing(values).getKeys();
	        	will(returnValue(keys));
	        	
	        	//getIndex
	        	allowing(values).getIndex(0);
	        	will(returnValue(0));
	        	allowing(values).getIndex(1);
	        	will(returnValue(1));
	        	allowing(values).getIndex(2);
	        	will(returnValue(2));
	        	
	        	//getKey
	        	allowing(values).getKey(0);
	        	will(returnValue(0));
	        	allowing(values).getKey(1);
	        	will(returnValue(1));
	        	allowing(values).getKey(2);
	        	will(returnValue(2));
	        	
	        	//getValue
	        	allowing(values).getValue(0);
	        	will(returnValue(5));
	        	allowing(values).getValue(1);
	        	will(returnValue(9));
	        	allowing(values).getValue(2);
	        	will(returnValue(2));
	        	
	        }
	    });
    }


	/*
	 * Test if null parameter will through InvalidParameterException
	*/
	@Test (expected = IllegalArgumentException.class)
	public void nullCumlativePercentageTest() {
		DataUtilities.getCumulativePercentages(null);
	}
	
	//This test is verifying that the cumulative average object has the same keys as the one that is being passed in
	@Test
	public void getCumulativePercentagesKeysTest() {
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		assertEquals("The resulting keys are ", results.getKeys(), values.getKeys());
	}
	
	//This test is verifying that the cumulative average that is found is between 0-1 for the first value, which is expected to be 0.3125
	@Test
	public void getCumalativePercentagesFirstValue() {
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		Number firstElement = results.getValue(0);
		assertEquals("The cumalative percentage for the first key is 0.3125 ", firstElement);
	}
	
	//This test is verifying that the cumulative average that is found is between 0-1 for the last value, which is expected to be 1
	@Test
	public void getCumulativePercentagesLastValue() {
		KeyedValues results = DataUtilities.getCumulativePercentages(values);
		Number lastElement = results.getValue(2);
		assertEquals("The cumalative percentage for the last key is 1.0 ", lastElement);
	}
	
	/*
	 * Test to see if the correct cumulative percentage of KeyedValues pair with both positive and negative values is returned
	 */
	@Test
	public void getMixedCumulativePercentagesTest() {
		Mockery mockingContext1 = new Mockery(); 
		KeyedValues results1 = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() { 
			{
				atLeast(1).of(results1).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(results1).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(results1).getKey(1);
				will(returnValue(4));
				
				atLeast(1).of(results1).getKey(2);
				will(returnValue(3));
				
				atLeast(1).of(results1).getValue(0);
				will(returnValue(-5));
				
				atLeast(1).of(results1).getValue(1);
				will(returnValue(2));
				
				atLeast(1).of(results1).getValue(2);
				will(returnValue(2));
				
			} 
		});
		
		Mockery mockingContext2 = new Mockery();
		KeyedValues results2 = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				atLeast(1).of(results2).getItemCount(); 
				will(returnValue(3));
			
				atLeast(1).of(results2).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(results2).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(results2).getKey(2);
				will(returnValue(2));
						
				atLeast(1).of(results2).getValue(0);
				will(returnValue(-0.40));
				
				atLeast(1).of(results2).getValue(1);
				will(returnValue(0.42));
				
				atLeast(1).of(results2).getValue(2);
				will(returnValue(1.0));
			} 
		});
		
		assertTrue("The objects are not equal", DataUtilities.getCumulativePercentages(results1).equals(results2));
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
