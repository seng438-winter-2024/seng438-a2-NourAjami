package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import org.jfree.data.DataUtilities;
import org.junit.*;

public class CreateNumberArray2DTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    /**
     * Test with valid double array input.
     * Expects: Corresponding Number[][] array with identical values.
     */
    @Test
    public void createNumberArray2DWithValidInput() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
        Number[][] expected = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};

        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertArrayEquals("The Number[][] array should match the double[][] input.", expected, result);
    }

    /**
     * Test with null input.
     * Expects: InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void createNumberArray2DWithNullInput() {
        DataUtilities.createNumberArray2D(null);
    }

    /**
     * Test with empty double array input.
     * Expects: An empty Number[][] array.
     */
    @Test
    public void createNumberArray2DWithEmptyInput() {
        double[][] data = {};
        Number[][] expected = {};

        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertArrayEquals("The Number[][] array should be empty.", expected, result);
    }

    /**
     * Test with double array containing negative values.
     * Expects: Corresponding Number[][] array including negative values.
     */
    @Test
    public void createNumberArray2DWithNegativeValues() {
        double[][] data = {{-1.0, -2.0}, {-3.0, -4.0}};
        Number[][] expected = {{-1.0, -2.0}, {-3.0, -4.0}};

        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertArrayEquals("The Number[][] array should include the negative values.", expected, result);
    }

    /**
     * Test with a double array containing NaN and Infinity values.
     * Expects: Corresponding Number[][] array containing NaN and Infinity values.
     */
    @Test
    public void createNumberArray2DWithSpecialValues() {
        double[][] data = {{Double.NaN, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY, Double.MAX_VALUE}};
        Number[][] expected = {{Double.NaN, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY, Double.MAX_VALUE}};

        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertArrayEquals("The Number[][] array should handle NaN and Infinity.", expected, result);
    }

    @After
    public void tearDown() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}
}

