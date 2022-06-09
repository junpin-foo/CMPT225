package assignment2;

import java.util.NoSuchElementException;

/**
 * Implementation of circular linked list
 *   
 * @author Igor
 *
 */

public class CircularLinkedList<T> {

	class LinkedListNode {

		T data;
		LinkedListNode next;
		LinkedListNode prev;

		LinkedListNode(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private LinkedListNode pointer;
	private LinkedListNode head;
	private LinkedListNode tail;
	private int length = 0;

	public CircularLinkedList() {
		pointer = null;
		length = 0;
	}

	public CircularLinkedList(int initSize, T initValue) {

		for(int i = 0; i < initSize; i++){
			if (initValue == null)
				return;

			LinkedListNode newNode = new LinkedListNode(initValue);

			if (length == 0) {
				pointer = newNode;
				head = pointer;
				tail = pointer;
				pointer.prev = pointer;
				pointer.next = pointer;
			}
			else {
				addAfter(initValue);
				moveForward();
			}
			length++;
		}
		pointer = head;
	}

	public void moveForward() {

		if(pointer.next == pointer)
			return;
		else if (pointer == null)
			throw new NoSuchElementException("Empty list");
		else{
			pointer = pointer.next;
		}
	}

	public void moveBackward() {

		if(pointer.prev == pointer)
			return;
		else if (pointer == null)
			throw new NoSuchElementException("Empty list");
		else{
			pointer = pointer.prev;
		}
	}

	public T getValue() {
		if (length == 0)
			throw new NoSuchElementException("Empty list");

		return pointer.data;

		//return null;
	}

	public T setValue(T element) {
		if (length == 0)
			throw new NoSuchElementException("Empty list");

		if (element == null)
			throw new IllegalArgumentException("Trying to add null to the list");

		T prevValue = pointer.data;
		pointer.data = element;
		return prevValue;
		//return null;
	}

	public void addBefore(T element) {

		LinkedListNode newNode = new LinkedListNode(element);

		if(length == 0) {
			pointer = newNode;
			head = pointer;
			tail = pointer;
			pointer.next = pointer;
			pointer.prev = pointer;
		}
		else if(pointer == head){
			LinkedListNode temp = pointer.prev;
			pointer.prev = newNode;
			newNode.next = pointer;
			pointer = pointer.prev;
			pointer.prev = temp;
			pointer = pointer.prev;
			pointer.next = newNode;
			pointer = pointer.next.next;
			head = pointer.prev; // new added
		}
		else {
			LinkedListNode temp = pointer.prev;
			pointer.prev = newNode;
			newNode.next = pointer;
			pointer = pointer.prev;
			pointer.prev = temp;
			pointer = pointer.prev;
			pointer.next = newNode;
			pointer = pointer.next.next;
		}
		length++;
	}


	public void addAfter(T element) {

		LinkedListNode newNode = new LinkedListNode(element);

		if(length == 0) {
			pointer = newNode;
			head = pointer;
			tail = pointer;
			pointer.next = pointer;
			pointer.prev = pointer;
		}
		else if(pointer == tail){
			LinkedListNode temp = pointer.next;
			pointer.next = newNode;
			newNode.prev = pointer;
			pointer = pointer.next;
			pointer.next = temp;
			pointer = pointer.next;
			pointer.prev = newNode;
			pointer = pointer.prev.prev;
			tail = pointer.next; // new added
		}
		else {
			LinkedListNode temp = pointer.next;
			pointer.next = newNode;
			newNode.prev = pointer;
			pointer = pointer.next;
			pointer.next = temp;
			pointer = pointer.next;
			pointer.prev = newNode;
			pointer = pointer.prev.prev;
		}
		length++;
	}

	/**
	 * @return the previous value of the removed node
	 */
	public T removeBefore() {
		if (length == 0)
			throw new NoSuchElementException("Empty list");

		T prevValue = pointer.prev.data;

		pointer.prev = pointer.prev.prev;

		length--;
		return prevValue;
		//return null;
	}

	/**
	 * @return the previous value of the removed node
	 */
	public T removeAfter() {
		if (length == 0)
			throw new NoSuchElementException("Empty list");

		T nextValue = pointer.next.data;

		pointer.next = pointer.next.next;

		length--;
		return nextValue;
		//return null;
	}

	public boolean isEmpty() {
		if(length == 0)
			return true;
		else
			return false;
	}
}
