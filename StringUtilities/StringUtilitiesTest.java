import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A class that performs simple calculates on a given stored String
 * 
 * @author MeermaBR and Faris Syed
 * @version 9/18/18
 */
public class StringUtilitiesTest {

    private StringUtilities nullString;
    private StringUtilities emptyString;

    /**
     * Test
     */
    @Before
    public void setUp() {
        nullString = new StringUtilities();
        emptyString = new StringUtilities( "" );
    }

    /**
     * Test
     */
    @After
    public void tearDown() {
        nullString = null;
        emptyString = null;
    }

    /**
     * Test
     */
    @Test
    public void testReverseSimpleInput() {
        nullString.setString( "meow" );
        assertEquals( "woem", nullString.reverse() );
    }

    /**
     * Test
     */
    @Test
    public void testReversePalindrome() {
        nullString.setString( "racecar" );
        assertEquals( "racecar", nullString.reverse() );
    }

    /**
     * Test
     */
    @Test
    public void testReverseEmptyString() {
        assertEquals( "", emptyString.reverse() );
    }

    /**
     * Test
     */
    @Test(expected = NullPointerException.class)
    public void testReverseOnNull() {
        assertNull( nullString.reverse() );
    }

    /**
     * Test
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReverseIllegalArg() {
        nullString.setString( "Illegal" );
        assertEquals( "agel", nullString.reverse( 4, 2 ) );
    }

    /**
     * Test
     */
    @Test
    public void testReverseIllegalSameFromTo() {
        nullString.setString( "Illegal" );
        assertEquals( "", nullString.reverse( 2, 2 ) );
    }

    /**
     * Test
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReverseNegativeIndex() {
        nullString.setString( "Illegal" );
        assertEquals( "", nullString.reverse( -2, 2 ) );
    }

    /**
     * Test
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReverseToGreaterThanLength() {
        nullString.setString( "Illegal" );
        assertEquals( "legal", nullString.reverse( 2, 15 ) );
    }

    /**
     * Test
     */
    @Test
    public void testSetString() {
        nullString.setString( "Cow" );
        assertEquals( "Cow", nullString.toString() );
    }

    /**
     * Test
     */
    @Test
    public void testToString() {
        nullString.setString( "Hello, world" );
        assertEquals( "Hello, world", nullString.toString() );
    }

    /**
     * Test
     */
    @Test
    public void testReverseFromTo() {
        nullString.setString( "Patrick" );
        assertEquals( "cirt", nullString.reverse( 2, 6 ) );
    }

    /**
     * Test
     */
    @Test
    public void testIsAllUpperTrue() {
        nullString.setString( "AARON" );
        assertTrue( nullString.isAllUpper() );
    }

    /**
     * Test
     */
    @Test
    public void testIsAllUpperFalse() {
        nullString.setString( "Aaron" );
        assertFalse( nullString.isAllUpper() );
    }

    /**
     * Test
     */
    @Test
    public void testIsAllLowerTrue() {
        nullString.setString( "aaron" );
        assertTrue( nullString.isAllLower() );
    }

    /**
     * Test
     */
    @Test
    public void testIsAllLowerFalse() {
        nullString.setString( "Aaron" );
        assertFalse( nullString.isAllLower() );
    }

    /**
     * Test
     */
    @Test
    public void testContainsNumbersTrue() {
        nullString.setString( "478uyjh" );
        assertTrue( nullString.containsNumbers() );
    }

    /**
     * Test
     */
    @Test
    public void testContainsNumbersFalse() {
        nullString.setString( "MaDog" );
        assertFalse( nullString.containsNumbers() );
    }

    /**
     * Test
     */
    @Test
    public void testNumConsecutiveDuplicatesMeow() {
        nullString.setString( "Meow" );
        assertEquals( 0, nullString.numConsecutiveDuplicates() );
    }

    /**
     * Test
     */
    @Test
    public void testNumConsecutiveDuplicatesMoo() {
        nullString.setString( "Moo" );
        assertEquals( 1, nullString.numConsecutiveDuplicates() );
    }

    /**
     * Test
     */
    @Test
    public void testNumConsecutiveDuplicatesShhhh() {
        nullString.setString( "Shhhh!" );
        assertEquals( 3, nullString.numConsecutiveDuplicates() );
    }

    /**
     * Test
     */
    @Test
    public void testNumMatchesChar() {
        nullString.setString( "ababab" );
        assertEquals( 3, nullString.numMatches( 'a' ) );
    }

    /**
     * Test
     */
    @Test
    public void testNumMatchesCharZero() {
        nullString.setString( "ababab" );
        assertEquals( 0, nullString.numMatches( 'c' ) );
    }

    /**
     * Test
     */
    @Test
    public void testNumMatchesString() {
        nullString.setString( "abababab" );
        assertEquals( 4, nullString.numMatches( "ab" ) );
    }

    /**
     * Test
     */
    @Test
    public void testNumMatchesStringZero() {
        nullString.setString( "abababab" );
        assertEquals( 0, nullString.numMatches( "abc" ) );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberIntegerTrue() {
        nullString.setString( "102354" );
        assertTrue( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberDecimalTrue() {
        nullString.setString( "10.2354" );
        assertTrue( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberNegativeIntegerTrue() {
        nullString.setString( "-102354" );
        assertTrue( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberNegativeDecimalTrue() {
        nullString.setString( "-10.2354" );
        assertTrue( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberMultipleNegative() {
        nullString.setString( "-10-2354" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberMisplacedNegative() {
        nullString.setString( "10-2354" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberMultipleDecimal() {
        nullString.setString( "10.23.54" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberLetter() {
        nullString.setString( "-10.v2354" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberIntegerDot() {
        nullString.setString( "102354." );
        assertTrue( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberMinusDot() {
        nullString.setString( "-." );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberDotMinus() {
        nullString.setString( ".-" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberMinus() {
        nullString.setString( "-" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberMinusDotNum() {
        nullString.setString( "-.102354" );
        assertFalse( nullString.isNumber() );
    }

    /**
     * Test
     */
    @Test
    public void testIsNumberDotMinusNum() {
        nullString.setString( ".-102354" );
        assertTrue( nullString.isNumber() );
    }

}
