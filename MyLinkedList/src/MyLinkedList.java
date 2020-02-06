import java.util.Collection;

/**
 * A class that stores a list of objects
 *
 * @author Faris Syed
 * @version 10/23/18
 * @param <E>
 *            Any object of type E
 */
public class MyLinkedList<E> {

    private int size;
    private Node<E> head;

    /**
     * A class that stores data and a next variable
     * @author Faris Syed
     *
     * @param <E>
     */
    class Node<E> {

        private Object data;
        private Node<E> next;

        /**
         * Default Constructor
         */
        Node() {
            this( null, null );
        }

        /**
         * Constructor that takes in data and next variables
         * @param data data to be stored in node
         * @param next the link to the next node
         */
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
        head = new Node();
    }

    /**
     * Constructor taking in a collection of items to store in MyLinkedList
     *
     * @param c Collection of items
     */
    public MyLinkedList(Collection<E> c) {
        addAll( c );
    }

    /**
     * Adds obj to end of MyLinkedList
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
     * Adds obj to index in MyLinkedList
     *
     * @param index
     *            position of item to be added
     * @param obj
     *            item to be added
     */
    public void add( int index, E obj ) {
        if ( index < 0 || index > size  ) {
            throw new IndexOutOfBoundsException();
        }
        if ( index == 0 ) {
            head = new Node( obj, head );
        }
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node( obj, temp.next );
        }
        size++;
    }

    /**
     * Removes obj from MyArrayList
     * @param obj item to be removed
     * @return true if object is removed, false if IndexOutOfBounds is thrown
     */
    public boolean remove( Object obj ) {
        //return obj.equals( remove( indexOf( obj ) ) );
        try {
            remove(indexOf(obj));
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    /**
     * Removes object from an index
     *
     * @param index index of the item to be removed
     * @return object that was removed
     */
    public E remove( int index ) {
        Node<E> temp = head;
        Object removed = null;
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        else if ( index == 0 ) {
            removed = head.data;
            head = head.next;
        }
        else {
            for ( int i = 0; i < index - 1; i++ ) {
                temp = temp.next;
            }
            removed = temp.next.data;
            temp.next = temp.next.next;
        }

        size--;
        return (E)removed;
    }

    /**
     * Returns the object at index
     *
     * @param index index of desired object
     * @return object at index
     */
    public E get( int index ) {

        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for ( int i = 0; i < index; i++ ) {
            temp = temp.next;
        }
        return (E)temp.data;
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
    @SuppressWarnings( "unchecked" )
    public E set( int index, E obj ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }

        Object removed = remove( index );
        add( index, obj );
        return (E)removed;
    }

    /**
     * Size of MyLinkedList
     *
     * @return size of MyLinkedList
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
        Node temp = head;
        for ( int i = 0; i < size; i++ ) {
            if ( temp.data.equals( obj ) ) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Returns true if the size of MyLinkedList is 0
     *
     * @return true when size of MyLinkedList is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Converts MyLinkedList to a String
     *
     * @return MyLinkedList as a String
     */
    public String toString() {
        if ( isEmpty() ) {
            return "[]";
        }
        String result = "[" + head.data.toString();
        Node temp = head.next;
        for ( int i = 1; i < size; i++ ) {
            result += ", " + temp.data.toString();
            temp = temp.next;
        }
        return result + "]";
    }

    /**
     * Adds a collection to MyLinkedList
     *
     * @param c
     *            Collection of objects
     */
    public void addAll( Collection<E> c ) {
        for ( Object o : c ) {
            add( (E) o );
        }
    }

    /**
     * Clears all objects in a MyLinkedList
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns first index where obj is found
     *
     * @param obj
     *            the object being searched for
     * @return the first index of obj, -1 if obj is not found
     */
    public int indexOf( Object obj ) {
        Node temp = head;
        for ( int i = 0; i < size; i++ ) {
            if ( temp.data.equals( obj ) ) {
                return i;
            }
            temp = temp.next;
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
        Node temp = head;
        int ans = -1;
        for ( int i = 0; i < size; i++ ) {
            if ( temp.data.equals( obj ) ) {
                ans = i;
            }
            temp = temp.next;
        }
        return ans;
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
        if ( fromIndex < 0 || fromIndex > toIndex || toIndex > size) {
            throw new IndexOutOfBoundsException();
        }
        for ( int i = toIndex - 1; i >= fromIndex; i-- ) {
            remove(i);
        }

    }

    /**
     * Converts MyLinkedList to Array type
     *
     * @return Object[]
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node temp = head;
        for ( int i = 0; i < size; i++ ) {
            result[i] = temp.data;
            temp = temp.next;
        }
        return result;
    }

    /**
     * Returns true if MyLinkedList is equal to LinkedList o
     *
     * @param o
     *            object being compared to
     * @return true if MyLinkedList is equal to LinkedList o, false otherwise
     */
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( !( o instanceof MyLinkedList ) ) {
            return false;
        }
        MyLinkedList check = ( MyLinkedList ) o;
        return check.size() == size &&
                check.toString().equals( this.toString() );
    }

}
