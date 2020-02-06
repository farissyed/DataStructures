import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A class that performs tests on methods of MyLinkedList
 *
 * @author Faris Syed
 * @version 10/23/18
 */
public class MyLinkedListTest {

    private MyLinkedList<String> nullList;
    private MyLinkedList<String> numbers;

    /**
     * Test
     */
    @Before
    public void setUp() {
        nullList = new MyLinkedList<String>();

        numbers = new MyLinkedList<>();
        numbers.add( "One" );
        numbers.add( "Two" );
        numbers.add( "Three" );
        numbers.add( "Four" );

    }

    /**
     * Test
     */
    @After
    public void tearDown() {
        nullList.clear();
    }

    /**
     * Test
     */
    @Test
    public void testConstructorCollection() {
        Collection<String> collect = new ArrayList<>();
        collect.add( "abc" );
        collect.add( "def" );
        collect.add( "ghi" );
        collect.add( "jkl" );
        collect.add( "mno" );
        collect.add( "pqr" );
        collect.add( "stu" );
        collect.add( "vwx" );
        collect.add( "yz" );
        nullList = new MyLinkedList( collect );

        assertEquals( 9, nullList.size() );

    }

    /**
     * Test
     */
    @Test
    public void testAddTrue() {
        assertTrue(numbers.add( "Five" ));
    }

    /**
     * Test
     */
    @Test
    public void testAddToIndex() {
        numbers.add( 3, "Five" );
        assertEquals( "Five", numbers.get( 3 ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddToIndexError() {
        numbers.add( 5, "Five" );
        assertEquals( "Five", numbers.get( 3 ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddToIndexErrorNeg() {
        numbers.add( -1, "Five" );
        assertEquals( "Five", numbers.get( 3 ));
    }

    /**
     * Test
     */
    @Test
    public void testRemoveObjectTrue() {
        numbers.add( "Five" );
        assertTrue(numbers.remove( "Four" ));
    }

    /**
     * Test
     */
    @Test
    public void testRemoveObjectFalse() {
        numbers.add( "Five" );
        assertFalse(numbers.remove( "Random" ));
    }

    /**
     * Test
     */
    @Test
    public void testRemoveIndex() {
        numbers.add( "Five" );
        assertEquals("Four", numbers.remove( 3 ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBounds() {
        numbers.add( "Five" );
        assertEquals("Four", numbers.remove( 5 ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexOutOfBoundsNegative() {
        numbers.add( "Five" );
        assertEquals("Four", numbers.remove( -1 ));
    }

    /**
     * Test
     */
    @Test
    public void testGet() {
        numbers.add( "Five" );
        assertEquals("Four", numbers.get( 3 ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsGreater() {
        numbers.add( "Five" );
        assertEquals(null, numbers.get( 5 ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBoundsNegative() {
        numbers.add( "Five" );
        assertEquals(null, numbers.get( -1 ));
    }

    /**
     * Test
     */
    @Test
    public void testSet() {
        numbers.add( "Five" );
        assertEquals( "Four", numbers.set( 3, "Set Three" ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBoundsNegative() {
        numbers.add( "Five" );
        assertEquals( "One", numbers.set( -1, "Set Three" ));
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetIndexOutOfBoundsGreater() {
        numbers.add( "Five" );
        assertEquals( "Five", numbers.set( 5, "Set Greater" ));
    }

    /**
     * Test
     */
    @Test
    public void testSize() {
        assertEquals( 4, numbers.size() );
    }

    /**
     * Test
     */
    @Test
    public void testContainsTrue() {
        assertTrue( numbers.contains("Four") );
    }

    /**
     * Test
     */
    @Test
    public void testContainsFalse() {
        assertFalse( numbers.contains( "Five" ) );
    }

    /**
     * Test
     */
    @Test
    public void testIsEmptyTrue() {
        assertTrue( nullList.isEmpty() );
    }

    /**
     * Test
     */
    @Test
    public void testIsEmptyFalse() {
        assertFalse( numbers.isEmpty() );
    }

    /**
     * Test
     */
    @Test
    public void testToString() {
        assertEquals( "[One, Two, Three, Four]", numbers.toString());
    }

    /**
     * Test
     */
    @Test
    public void testToStringEmpty() {
        assertEquals( "[]", nullList.toString() );
    }

    /**
     * Test
     */
    @Test
    public void testToStringSingleObj() {
        nullList.add( "Hundred" );
        assertEquals( "[Hundred]", nullList.toString() );
    }

    /**
     * Test
     */
    @Test
    public void testAddAll() {
        Collection<String> collect = new ArrayList<>();
        collect.add( "Five" );
        collect.add( "Six" );
        collect.add( "Seven" );
        collect.add( "Eight" );
        collect.add( "Nine" );
        numbers.addAll( collect );
        assertEquals( "[One, Two, Three, Four, Five,"
                + " Six, Seven, Eight, Nine]", numbers.toString() );
    }

    /**
     * Test
     */
    @Test
    public void testClear() {
        numbers.clear();
        assertEquals( 0, numbers.size() );
    }

    /**
     * Test
     */
    @Test
    public void testIndexOfObjExists() {
        assertEquals( 3, numbers.indexOf( "Four" ) );
    }

    /**
     * Test
     */
    @Test
    public void testIndexOfObjDNE() {
        assertEquals( -1, numbers.indexOf( "Seven" ) );
    }


    /**
     * Test
     */
    @Test
    public void testLastIndexOfObjExists() {
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        nullList.add( "Ice Cream" );
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        assertEquals( 6, nullList.lastIndexOf( "Pizza" ) );
    }

    /**
     * Test
     */
    @Test
    public void testLastIndexOfObjDNE() {
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        nullList.add( "Ice Cream" );
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        assertEquals( -1, nullList.lastIndexOf( "Carrot" ) );
    }

    /**
     * Test
     */
    @Test
    public void testRemoveRange() {
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        nullList.add( "Ice Cream" );
        nullList.removeRange( 0, 1 );
        assertEquals( "[Chips, Pizza, Ice Cream]", nullList.toString() );
    }


    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveRangeBadFromIndex() {
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        nullList.add( "Ice Cream" );
        nullList.removeRange( -1, 3 );
        assertEquals( "[Chips, Pizza, Ice Cream]", nullList.toString() );
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveRangeBadToIndex() {
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        nullList.add( "Ice Cream" );
        nullList.removeRange( 3, 5 );
        assertEquals( "[Chips, Pizza, Ice Cream]", nullList.toString() );
    }

    /**
     * Test
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveRangeFromGreaterThanTo() {
        nullList.add( "Cookie" );
        nullList.add( "Chips" );
        nullList.add( "Pizza" );
        nullList.add( "Ice Cream" );
        nullList.removeRange( 3, 2 );
        assertEquals( "[Chips, Pizza, Ice Cream]", nullList.toString() );
    }

    /**
     * Test
     */
    @Test
    public void testToArray() {
        Object[] expected = new Object[numbers.size()];
        for ( int i = 0; i < expected.length; i++ ) {
            expected[i] = numbers.get( i );
        }
        assertArrayEquals( expected, numbers.toArray() );
    }

    /**
     * Test
     */
    @Test
    public void testEqualsTrue() {
        Collection<String> equalNumbers = new ArrayList<>();
        equalNumbers.add( "One" );
        equalNumbers.add( "Two" );
        equalNumbers.add( "Three" );
        equalNumbers.add( "Four" );
        nullList = new MyLinkedList<String>( equalNumbers );
        assertTrue(numbers.equals( nullList ));
    }

    /**
     * Test
     */
    @Test
    public void testEqualFalse() {
        Collection<String> equalNumbers = new ArrayList<>();
        equalNumbers.add( "One" );
        equalNumbers.add( "Two" );
        equalNumbers.add( "Three" );
        nullList = new MyLinkedList<String>( equalNumbers );
        assertFalse(numbers.equals( nullList ));
    }

    /**
     * Test
     */
    @Test
    public void testEqualFalseData() {
        Collection<String> equalNumbers = new ArrayList<>();
        equalNumbers.add( "One" );
        equalNumbers.add( "Two" );
        equalNumbers.add( "Three" );
        nullList = new MyLinkedList<String>( equalNumbers );
        assertFalse(numbers.equals( "Numbers" ));
    }
}
