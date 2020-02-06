/**
 * A class that performs simple calculates on a given stored String
 * 
 * @author MeermaBR and Faris Syed
 * @version 9/18/18
 */
public class StringUtilities {
    private String string;

    /**
     * Builds an empty (null) StringUtilities
     */
    public StringUtilities() {
        string = null;
    }

    /**
     * Builds a StringUtilities with the given String value
     * 
     * @param string
     *            The string to be stored for manipulation
     */
    public StringUtilities(String string) {
        this.string = string;
    }

    /**
     * Changes the stored String
     * 
     * @param string
     *            The new value for the String to become
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * Returns the value of the String
     * 
     * @return The value of the String or null if the String is null
     */
    public String toString() {
        return string;
    }

    /**
     * Calculates a reversed value of the stored String
     * 
     * @return A new String with all values reversed
     * @throws NullPointerException
     *             if the original String is null
     */
    public String reverse() {
        // isNull();

        StringBuilder ans = new StringBuilder();

        for ( int i = string.length() - 1; i >= 0; i-- ) {
            ans.append( string.charAt( i ) );
        }

        return ans.toString();
    }

    /**
     * Calculates a reversed value of a subsection of the String
     * 
     * @param from
     *            The index to begin at (inclusive)
     * @param to
     *            The index to stop at (exclusive)
     * @return A new String with all values reversed
     *         between index from (inclusive)
     *         and to (exclusive)
     * @throws NullPointerException
     *             if the original String is null
     * @throws IllegalArgumentException
     *             if the given indices are not valid
     */
    public String reverse(int from, int to) {
        // isNull();
        if ( 0 > from || from > to || to > string.length() ) {
            throw new IllegalArgumentException();
        }
        String sub = string.substring( from, to );
        StringUtilities str = new StringUtilities( sub );
        String ans = str.reverse();
        return ans;
    }

    /**
     * Determines if all the alpha-characters in the string are Uppercase
     * 
     * @return True if all alpha-characters in the string are Uppercase
     * @throws NullPointerException
     *             if the original String is null
     */
    public boolean isAllUpper() {
        // isNull();
        return string.toUpperCase().equals( string );
    }

    /**
     * Determines if all the alpha-characters in the string are Lowercase
     * 
     * @return True if all alpha-characters in the string are Lowercase
     * @throws NullPointerException
     *             if the original String is null
     */
    public boolean isAllLower() {
        // isNull();
        return string.toLowerCase().equals( string );
    }

    /**
     * Determines if any of the characters in the string are numeric (0-9)
     * 
     * @return True if any 0-9 character is in the string
     * @throws NullPointerException
     *             if the original String is null
     */
    public boolean containsNumbers() {
        // isNull();
        for ( int i = 0; i < string.length(); i++ ) {
            if ( Character.isDigit( string.charAt( i ) ) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the String itself is storing a number. 
     * A number can start with a negative sign (-), may 
     * contains one period (.), and otherwise is made only
     * of digits from 0-9.
     * 
     * @return True if the entire string is a number
     * @throws NullPointerException
     *             if the original String is null
     */
    public boolean isNumber() {
        // isNull();
        if ( !containsNumbers() ) {
            return false;
        }
        
        boolean isDecimal = false;

        for ( int i = 0; i < string.length(); i++ ) {
            if ( !Character.isDigit( string.charAt( i ) ) ) {
                if ( string.charAt( i ) == '-' ) {
                    if ( i != 0 ) {
                        return false;
                    }
                }
                else if ( string.charAt( i ) == '.' ) {
                    if ( isDecimal ) {
                        return false;
                    }
                    isDecimal = true;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Counts the number of characters which 
     * have the same value next to them. ie:
     * Meow = 0, Moo = 1, Shhhh! = 3
     * 
     * @return The number of consecutive duplicates found
     * @throws NullPointerException
     *             if the original String is null
     */
    public int numConsecutiveDuplicates() {
        // isNull();
        int numOfDuplicates = 0;
        for ( int i = 0; i < string.length() - 1; i++ ) {
            if ( string.charAt( i ) == string.charAt( i + 1 ) ) {
                numOfDuplicates++;
            }
        }
        return numOfDuplicates;
    }

    /**
     * Counts the number of times a given char is in the String
     * 
     * @param c
     *            The char to be counted
     * @return The number of times the char is in the String
     * @throws NullPointerException
     *             if the original String is null
     */
    public int numMatches(char c) {
        // isNull();
        int count = 0;
        for ( char x : asArray() ) {
            if ( c == x ) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the number of times a given String is found in the original
     * 
     * @param other
     *            The string to be looked for
     * @return The number of times other is in the original String
     * @throws NullPointerException
     *             if either the original or other string are null
     */
    public int numMatches(String other) {
        // isNull();
        int count = 0;
        for ( int i = 0; i < string.length() - other.length() + 1; i++ ) {
            if ( other.equals( string.substring( i, i + other.length() ) ) ) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates an array version of the String, with each slot a char
     * 
     * @return An array conversion of the String
     * @throws NullPointerException
     *             if the String is null.
     */
    public char[] asArray() {
        // isNull();
        return string.toCharArray();
    }

    /*
     * public void isNull() { if ( string == null ) { throw new
     * NullPointerException(); } }
     */

}