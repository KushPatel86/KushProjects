/**
 * A generic collection of elements stored as a list
 * 
 * @author "Kush Patel"
 *
 * @param <T> elements to store in list
 */
public interface ListInterface<T> {

	final int DEFAULT_CAPACITY = 5;

	/**
	 * Adds an element to the list, keeping the order of the list in tact Enlarge
	 * array when full
	 * 
	 * @param t element to add
	 */
	public void add(T t);

	/**
	 * Gets element at position
	 * 
	 * @param pos in list to get element
	 * @return element at position
	 * @throws MyIndexOutOfBoundsException    - if attempt to get an element outside
	 *                                        of the current elements in the array.
	 *                                        For example, if there are 2 elements
	 *                                        in the array and attempt to get(3).
	 * @throws ArrayIndexOutOfBoundsException - if attempt to get element at a
	 *                                        position larger than the array size.
	 */
	public T get(int pos) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException;

	/**
	 * Finds and removes the first occurrence of the element from list, keeping the
	 * order of the list in tact
	 * 
	 * @param t element to remove
	 * @return true if item is successfully removed, otherwise return false
	 */
	public boolean remove(T t);

	/**
	 * Removes element at given position, keeping the order of the list in tact
	 * 
	 * @param pos
	 * @throws MyIndexOutOfBoundsException    - if attempt to remove an element
	 *                                        outside of the current elements in the
	 *                                        array. For example, if there are 2
	 *                                        elements in the array and attempt to
	 *                                        remove(3).
	 * @throws ArrayIndexOutOfBoundsException - if attempt to remove element at at
	 *                                        position larger than the array size.
	 */
	public void remove(int pos) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException;

	/**
	 * Inserts element at given position, keeping the order of the list in tact
	 * 
	 * @param pos position in list to add element
	 * @param t   element to add
	 * @throws MyIndexOutOfBoundsException    - if the index is out of range (index
	 *                                        < 0 || index > size())
	 * @throws ArrayIndexOutOfBoundsException - if attempt to add element at at
	 *                                        position larger than the array size.
	 */
	public void add(int pos, T t) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException;

	/**
	 * Replaces element at given position in the list with the given element
	 * 
	 * @param pos position in list to replace element
	 * @param t   element to set
	 * @throws MyIndexOutOfBoundsException    - if the index is out of range (index
	 *                                        < 0 || index > size())
	 * @throws ArrayIndexOutOfBoundsException - if attempt to set element at at
	 *                                        position larger than the array size.
	 */
	public void set(int pos, T t) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException;

	/**
	 * Checks if element is in list
	 * 
	 * @param t element to search for
	 * @return true if it is, otherwise returns false
	 */
	public boolean contains(T t);

	/**
	 * Size of the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size();

	/**
	 * Remove all elements from list
	 */
	public void clear();

	/**
	 * Check if list is empty
	 * 
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();
}
