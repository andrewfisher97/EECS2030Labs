package eecs2030.lab5;

import java.util.NoSuchElementException;

/**
 * A linked list of int values. Students should use the eecs2030.lab5.Node class
 * to represent nodes of this list.
 * 
 * <p>
 * This implementation keeps track of the first (head) and last (tail) node
 * of the linked list. All methods that add or remove nodes from the list
 * may have to update the fields this.head, this.tail, and this.size
 */
public class LinkedIntList {

	private int size;
	private Node head;
	private Node tail;

	/**
	 * Initializes this linked list to an empty list.
	 */
	public LinkedIntList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/**
	 * Returns a reference to the first node of the list (the head node).
	 * 
	 * <p>
	 * NOTE: This method causes a privacy leak and would not normally be
	 * part of the public API; however, it is useful for testing purposes.
	 * 
	 * @return a reference to the first node of the list
	 */
	public Node head() {
		return this.head;
	}

	/**
	 * Returns a reference to the last node of the list (the tail node).
	 * 
	 * <p>
	 * NOTE: This method causes a privacy leak and would not normally be
	 * part of the public API; however, it is useful for testing purposes.
	 * 
	 * @return a reference to the last node of the list
	 */
	public Node tail() {
		return this.tail;
	}

	/**
	 * Throws an IndexOutOfBoundsException exception if idx is less
	 * than zero or greater than (this.size - 1)
	 * 
	 * @param idx an index to check
	 * @throws IndexOutOfBoundsException exception if idx is less
	 * than zero or greater than (this.size - 1)
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx > this.size - 1) {
			throw new IndexOutOfBoundsException(String.format("index: %d, size: %d", idx, this.size));
		}
	}

	/**
	 * Throws a NoSuchElementException if the list is empty.
	 * 
	 * @throws NoSuchElementException if the list is empty
	 */
	private void checkNotEmpty() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
	}

	
	/**
	 * Returns a string representation of this list similar to the string
	 * returned by java.util.List.toString.
	 * 
	 * @return a string representation of this list
	 */
	public String toString() {
		StringBuilder b = new StringBuilder("[");
		if (this.size > 0) {
			Node n = this.head;
			b.append(n.getData());
			n = n.getNext();
			while (n != null) {
				b.append(", ");
				b.append(n.getData());
				n = n.getNext();
			}
		}
		else {
			b.append("empty");
		}
		b.append("]");
		return b.toString();
	}


	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * Returns true if the size of this list is zero, and false otherwise.
	 * 
	 * @return true if the size of this list is zero, and false otherwise
	 */
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	

	
	/**
	 * Add an element to the end of this linked list.
	 * 
	 * @param elem
	 *            the element to add to the end of this linked list
	 * @return true (to be consistent with java.util.Collection)
	 */
	public boolean add(int elem) {
		Node newNode = new Node(); 
		newNode.setData(elem);
		if (size() == 0) {
			head = newNode;
		} else if (size() == 1) {
			head.setNext(newNode);
		} else if (size() > 1) {
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
		return true;
	}
	
	
	/**
	 * Returns the node at the given index.
	 * 
	 * <p>
	 * NOTE: This method is extremely useful for implementing many of the methods
	 * of this class, but students should try to use this method only once in each
	 * method.
	 * 
	 * <p>
	 * NOTE: This method causes a privacy leak and would not normally be
	 * part of the public API; however, it is useful for testing purposes.
	 * 
	 * @param index
	 *            the index of the node
	 * @return the node at the given index
	 * @throws IndexOutOfBoundsException
	 *             if index is less than 0 or greater than or equal the size of this
	 *             list
	 */
	public Node getNode(int index) {
		checkIndex(index);
		if (index == 0)
			return head;
		else {
			Node travellor = new Node();
			travellor.setNext(head.getNext());
			for (int i = 0; i < index; i++) {
				travellor = travellor.getNext();
			}
			return travellor;
		}
	}


	/**
	 * Get the element stored at the given index in this linked list.
	 * 
	 * @param index
	 *            the index of the element to get
	 * @return the element stored at the given index in this linked list
	 * @throws IndexOutOfBoundsException
	 *             if (index &lt; 0) || (index &gt; size - 1)
	 */
	public int get(int index) {
		checkIndex(index);
		return getNode(index).getData();
	}

	/**
	 * Sets the element stored at the given index in this linked list. Returns the
	 * old element that was stored at the given index.
	 * 
	 * @param index
	 *            the index of the element to set
	 * @param elem
	 *            the element to store in this linked list
	 * @return the old element that was stored at the given index
	 * @throws IndexOutOfBoundsException
	 *             if (index &lt; 0) || (index &gt; size - 1)
	 */
	public int set(int index, int elem) {
		checkIndex(index);
		int oldElem = get(index);
		getNode(index).setData(elem);
		return oldElem;
	}

	/**
	 * Insert an element to the front of this list.
	 * 
	 * @param elem
	 *            the element to insert at the front of this list
	 */
	public void addFirst(int elem) {
		Node newHead = new Node(elem, head);
		head = newHead;
		if (size() == 0)
			tail = head;
		size++;
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 * 
	 * <p>
	 * <code>t.add(0, elem)</code> is equivalent to <code>t.addFront(elem)</code>.
	 * 
	 * <p>
	 * <code>t.add(t.size(), elem)</code> is equivalent to <code>t.add(elem)</code>.
	 * 
	 * @param index
	 *            index at which the specified element is to be inserted
	 * @param elem
	 *            the element to be inserted
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index &lt; 0 || index &gt; size())
	 */
	public void add(int index, int elem) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (index == 0)
			addFirst(elem);
		else if (index == size())
			add(elem);
		else {
			Node newNode = new Node(elem, getNode(index));
			getNode(index - 1).setNext(newNode);
			size++;
		}
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws NoSuchElementException
	 *             if this list is empty
	 */
	public int removeFirst() {
		checkNotEmpty();
		int firstElem = head.getData();
		head = head.getNext();
		if (size() == 1)
			tail = null;
		size--;
		return firstElem;
	}

	/**
	 * Removes and returns the last element from this list.
	 * 
	 * @return the last element from this list
	 * @throws NoSuchElementException
	 *             if this list is empty
	 */
	public int removeLast() {
		checkNotEmpty();
		int lastElem = tail.getData();
		if (size() == 1) {
			 tail = null;
			 head = null;
			 size = 0;
			 return lastElem;
		}
		tail = getNode(size - 2);
		tail.setNext(null);
		size--;
		return lastElem;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 * 
	 * <p>
	 * <code>t.remove(0)</code> is equivalent to <code>t.removeFirst()</code>
	 * except that a different exception might be thrown.
	 * 
	 * <p>
	 * <code>t.remove(t.size() - 1)</code> is equivalent to <code>t.removeLast()</code>
	 * except that a different exception might be thrown.
	 * 
	 * @param index the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException
	 *          if the index is out of range (index &lt; 0 || index &gt;= size())
	 */
	public int remove(int index) {
		checkIndex(index);
		int result = get(index);
		if (index == 0) {
			removeFirst();
			return result;
		}
		if (index == size() - 1) {
			removeLast();
			return result;
		}
		getNode(index - 1).setNext(getNode(index).getNext());
		size--;
		return result;
	}

	
	/**
	 * Circularly shifts the elements of this list to the right by n positions
	 * causing the n elements at the end of the original list to appear at
	 * the front of the resulting list. For example, if <code>t</code> is the list:
	 * 
	 * <pre>
	 * [0, 1, 2, 3, 4, 5]
	 * </pre>
	 * 
	 * <p>
	 * then <code>t.shiftRight(2)</code> results in <code>t</code> being equal to:
	 * 
	 * <pre>
	 * [4, 5, 0, 1, 2, 3]
	 * </pre>
	 * 
	 * <p>
	 * <code>t.shiftRight(0)</code> and <code>t.shiftRight(t.size())</code> both
	 * leave <code>t</code> unchanged.
	 * 
	 * @param n the number of positions to shift the elements
	 * @throws IllegalArgumentException
	 *          if n is out of range (n &lt; 0 || n &gt; size())
	 */
	public void shiftRight(int n) {
		if (n < 0 || n > size()) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < n; i++) {
			int r = removeLast();
			addFirst(r);
		}
	}
}
