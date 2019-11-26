import java.util.Collection;

/**
 * A class that stores a list of objects
 * 
 * @author Faris Syed
 * @version 10/2/18
 * @param <E>
 *            Any object of type E
 */
public class MyLinkedList<E> {

    private int size;
    private Node<E> head;

    class Node<E> {
        Object data;
        Node<E> next;

        Node(Object data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Default Constructor
     */
    public MyLinkedList() {
        size = 0;
        head = null;
    }

    /**
     * Constructor taking in a collection of items to store in MyArrayList
     * 
     * @param c
     *            Collection of items
     */
    public MyLinkedList(Collection<E> c) {
        values = new Object[c.size()];
        addAll( c );
    }

    /**
     * Checks if index is valid
     * 
     * @param index
     *            index to be checked
     * @throws IndexOutOfBoundsException
     *             if index is greater than size or less than 0
     */
    private void checkIndex( int index ) {
        if ( index > size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Adds obj to end of MyArrayList
     * 
     * @param obj
     *            item to be added
     * @return true
     */
    public boolean add( E obj ) {
        add( size, obj );
        return true;
    }

    /**
     * Adds obj to index in MyArrayList
     * 
     * @param index
     *            position of item to be added
     * @param obj
     *            item to be added
     */
    public void add( int index, E obj ) {
        checkIndex( index );
        if ( values.length == 0 ) {
            values = new Object[1];
        }
        if ( size == values.length ) {
            ensureCapacity( 2 * size );
        }

        for ( int i = size; i > index; i-- ) {
            values[i] = values[i - 1];
        }

        values[index] = obj;
        size++;
    }

    /**
     * Removes obj from MyArrayList
     * 
     * @param obj
     *            item to be removed
     * @return true if object is removed, false if IndexOutOfBounds is thrown
     */
    public boolean remove( Object obj ) {
        // return obj.equals( remove( indexOf( obj ) ) );
        try {
            remove( indexOf( obj ) );
        } catch ( IndexOutOfBoundsException e ) {
            return false;
        }
        return true;
    }

    /**
     * Removes object from an index
     * 
     * @param index
     *            index of the item to be removed
     * @return object that was removed
     */
    public E remove( int index ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        Object x = values[index];
        for ( int i = index; i < size - 1; i++ ) {
            values[i] = values[i + 1];
        }
        size--;
        return ( E ) x;
    }

    /**
     * Returns the object at index
     * 
     * @param index
     *            index of desired object
     * @return object at index
     */
    public E get( int index ) {
        if ( index >= size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        return ( E ) values[index];
    }

    /**
     * Replaces an object at index for obj
     * 
     * @param index
     *            index of object to be changed
     * @param obj
     *            the new object that will replace the old object
     * @return the object that was replaced
     */
    public E set( int index, E obj ) {
        if ( index >= size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        Object x = values[index];
        values[index] = obj;
        return ( E ) x;
    }

    /**
     * Size of MyArrayList
     * 
     * @return size of MyArrayList
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if list contains obj
     * 
     * @param obj
     *            object that is being searched for
     * @return true if contains obj, false if not
     */
    public boolean contains( Object obj ) {
        for ( int i = 0; i < size; i++ ) {
            if ( values[i].equals( obj ) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the size of MyArrayList is 0
     * 
     * @return true when size of MyArrayList is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Converts MyArrayList to a String
     * 
     * @return MyArrayList as a String
     */
    public String toString() {
        if ( isEmpty() ) {
            return "[]";
        }
        String result = "[" + values[0].toString();
        for ( int i = 1; i < size; i++ ) {
            result += ", " + values[i].toString();
        }
        return result + "]";
    }

    /**
     * Adds a collection to MyArrayList
     * 
     * @param c
     *            Collection of objects
     */
    public void addAll( Collection<E> c ) {
        ensureCapacity( size + c.size() );
        for ( E o : c ) {
            add( o );
        }
    }

    /**
     * Clears all objects in a MyArrayList
     */
    public void clear() {
        for ( int i = 0; i < size; i++ ) {
            values[i] = null;
        }
        size = 0;
    }

    /**
     * Ensures capacity so that objects can be added
     * 
     * @param minCapacity
     */
    public void ensureCapacity( int minCapacity ) {
        Object[] temp = new Object[values.length];

        if ( minCapacity > values.length ) {
            temp = new Object[minCapacity];
            for ( int i = 0; i < values.length; i++ ) {
                temp[i] = values[i];
            }
            values = temp;
        }

    }

    /**
     * Returns first index where obj is found
     * 
     * @param obj
     *            the object being searched for
     * @return the first index of obj, -1 if obj is not found
     */
    public int indexOf( Object obj ) {
        for ( int i = 0; i < size; i++ ) {
            if ( values[i].equals( obj ) ) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns last index where obj is found
     * 
     * @param obj
     *            the object being searched for
     * @return the last index of obj, -1 if obj is not found
     */
    public int lastIndexOf( Object obj ) {
        for ( int i = size - 1; i >= 0; i-- ) {
            if ( values[i].equals( obj ) ) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the elements from one index to another
     * 
     * @param fromIndex
     *            starting index of range
     * @param toIndex
     *            end index of range
     */
    public void removeRange( int fromIndex, int toIndex ) {
        if ( fromIndex < 0 || fromIndex > toIndex || toIndex > size ) {
            throw new IndexOutOfBoundsException();
        }
        for ( int i = toIndex - 1; i >= fromIndex; i-- ) {
            remove( values[i] );
        }
    }

    /**
     * Converts MyArrayList to Array type
     * 
     * @return Object[]
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        for ( int i = 0; i < size; i++ ) {
            result[i] = values[i];
        }
        return result;
    }

    /**
     * Deletes excess cells of values background array
     */
    public void trimToSize() {
        values = toArray();
    }

    /**
     * Returns true if MyArrayList is equal to ArrayList o
     * 
     * @param o
     *            object being compared to
     * @return true if MyArrayList is equal to ArrayList o, false otherwise
     */
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( !( o instanceof MyArrayList ) ) {
            return false;
        }
        MyArrayList check = ( MyArrayList ) o;
        return check.size() == size && check.toString().equals( this.toString() );
    }

}
