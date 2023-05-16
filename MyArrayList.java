/**
 * A generic collection of elements stored as a list
 * 
 * @author "Kush Patel"
 *
 * @param <T> elements to store in list
 */
public class MyArrayList<T> implements ListInterface<T> {
	protected T[] myArrayList;
	final int DEFAULT_CAPACITY = 5;

	public MyArrayList() {
		myArrayList = (T[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int wtv) {
		myArrayList = (T[]) new Object[wtv];
	}

	/**
	 * Adds an element to the list, keeping the order of the list in tact Enlarge
	 * array when full
	 * 
	 * @param t element to add
	 */
	public void add(T t) {
		int e = 0;
		for (int x = 0; x < myArrayList.length; x++) {
			if (myArrayList[x] == null) {
				e = x;
				break;
			}
		}
		T[] newArray = (T[]) new Object[myArrayList.length + 2];
		for (int i = 0; i < myArrayList.length; i++) {
			newArray[i] = myArrayList[i];
		}
		newArray[e] = t;
		myArrayList = newArray;
	}

	/**
	 * @Override Gets element at position
	 * @param pos in list to get element
	 * @return element at position
	 * @throws MyIndexOutOfBoundsException    - if attempt to get an element outside
	 *                                        of the current elements in the array.
	 *                                        For example, if there are 2 elements
	 *                                        in the array and attempt to get(3).
	 * @throws ArrayIndexOutOfBoundsException - if attempt to get element at a
	 *                                        position larger than the array size.
	 */
	public T get(int pos) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		int holda = 0;
		for (int x = 0; x < myArrayList.length; x++) {
			if (myArrayList[x] == null) {
				holda = x;
				break;
			}
		}
		if (myArrayList[pos] == null) {
			throw new MyIndexOutOfBoundsException("There is nothing in the given position.");
		} else if (pos > holda - 1 || pos < 0) {
			throw new ArrayIndexOutOfBoundsException("The given position is out of the range of the array.");
		} else {
			return (T) myArrayList[pos];
		}
	}

	/**
	 * @Override Finds and removes the first occurrence of the element from list,
	 *           keeping the order of the list in tact
	 * @param t element to remove
	 * @return true if item is successfully removed, otherwise return false
	 */
	public boolean remove(T t) {
		boolean found = false;
		int counta = 0;
		T[] newList = (T[]) new Object[myArrayList.length - 1];
		for (int i = 0; i < myArrayList.length; i++) {
			if (myArrayList[i] == t) {
				found = true;
				remove(i);
				break;
			}
		}

		if (found) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Override Removes element at given position, keeping the order of the list in
	 *           tact
	 * @param pos
	 * @throws MyIndexOutOfBoundsException    - if attempt to remove an element
	 *                                        outside of the current elements in the
	 *                                        array. For example, if there are 2
	 *                                        elements in the array and attempt to
	 *                                        remove(3).
	 * @throws ArrayIndexOutOfBoundsException - if attempt to remove element at at
	 *                                        position larger than the array size.
	 */
	public void remove(int pos) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		if (pos >= myArrayList.length || pos < 0) {
			throw new ArrayIndexOutOfBoundsException("The element you want to remove is outside the range.");
		} else if (myArrayList[pos] == null) {
			throw new MyIndexOutOfBoundsException("There is not a removable element at the requested index.");
		} else {
			T[] newList = (T[]) new Object[myArrayList.length - 1];
			for (int x = 0; x < pos; x++) {
				newList[x] = myArrayList[x];
			}
			for (int x = pos + 1; x < myArrayList.length; x++) {
				newList[x - 1] = myArrayList[x];
			}
			myArrayList = newList;
		}

	}

	/**
	 * @Override Inserts element at given position, keeping the order of the list in
	 *           tact
	 * @param pos position in list to add element
	 * @param t   element to add
	 * @throws MyIndexOutOfBoundsException    - if the index is out of range (index
	 *                                        < 0 || index > size())
	 * @throws ArrayIndexOutOfBoundsException - if attempt to add element at at
	 *                                        position larger than the array size.
	 */
	public void add(int pos, T t) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		T[] newList = (T[]) new Object[myArrayList.length + 1];
		int holda = 0;
		for (int x = 0; x < myArrayList.length; x++) {
			if (myArrayList[x] == null) {
				holda = x;
				break;
			}
		}
		if (pos > holda - 1 || pos < 0) {
			throw new ArrayIndexOutOfBoundsException("The element you want to remove is outside the range.");
		} else if (myArrayList[pos] == null) {
			throw new MyIndexOutOfBoundsException("There is not a removeable element at the requested index.");
		} else {
			for (int x = 0; x < pos; x++) {
				newList[x] = myArrayList[x];
			}
			newList[pos] = t;
			for (int x = pos + 1; x < newList.length; x++) {
				newList[x] = myArrayList[x - 1];
			}
			myArrayList = newList;
		}
	}

	/**
	 * @Override Replaces element at given position in the list with the given
	 *           element
	 * @param pos position in list to replace element
	 * @param t   element to set
	 * @throws MyIndexOutOfBoundsException    - if the index is out of range (index
	 *                                        < 0 || index > size())
	 * @throws ArrayIndexOutOfBoundsException - if attempt to set element at at
	 *                                        position larger than the array size.
	 */
	public void set(int pos, T t) throws MyIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		int holda = 0;
		for (int x = 0; x < myArrayList.length; x++) {
			if (myArrayList[x] == null) {
				holda = x;
				break;
			}
		}
		if (pos > holda || pos < 0) {
			throw new ArrayIndexOutOfBoundsException("The element you want to remove is outside the range.");
		} else if (myArrayList == null) {
			throw new MyIndexOutOfBoundsException("There is not a removeable element at the requested index.");
		} else {
			myArrayList[pos] = t;
		}
	}

	/**
	 * @Override Checks if element is in list
	 * @param t element to search for
	 * @return true if it is, otherwise returns false
	 */
	public boolean contains(T t) {
		for (int i = 0; i < myArrayList.length; i++) {
			if (t.equals(myArrayList[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @Override Size of the list
	 * @return the number of elements in the list
	 */
	public int size() {
		int holda = 0;
		for (int x = 0; x < myArrayList.length; x++) {
			if (myArrayList[x] == null) {
				holda = x;
				break;
			}
		}
		return holda;
	}

	/**
	 * @Override Remove all elements from list
	 */
	public void clear() {
		T[] holdarray = (T[]) new Object[myArrayList.length];
		myArrayList = holdarray;
	}

	/**
	 * @Override Check if list is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		boolean isEmpty = true;
		for (int x = 0; x < myArrayList.length; x++) {
			if (myArrayList[x] != null) {
				isEmpty = false;
				break;
			}
		}
		return isEmpty;
	}

}
