package assignment2;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implementation of linked list
 *   
 * @author Igor
 *
 */

public class LinkedListNode<T> {

	private T data;
	private LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(T data, LinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public LinkedListNode<T> getNext() {
		return next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> SearchLoopBegin(LinkedListNode<T> node){
		if (node == null || node.next == null)
			return null;

		LinkedListNode<T> slow = node;
		LinkedListNode<T> fast = node;

		while (fast != null && fast.next != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;   // loop found
		}
		if(slow != fast)
			return null; // no loop

		slow = node; //look for start of loop
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

	public int countReachableNodes( ) {
		LinkedListNode<T> startOfLoop = SearchLoopBegin(this);
		int counter = 1; // counting self

		if(this.next == null)
			return 1;

		if(startOfLoop != null) {

			LinkedListNode<T> begin = this;

			if (begin == startOfLoop) {
				while (begin.next != startOfLoop) {
					counter++;
					begin = begin.next;
				}
			} else {
				while (begin.next != startOfLoop) {
					counter++;
					begin = begin.next;
				}
				begin = begin.next; // move to next so you're not on the start of loop
				counter++;
				while (begin.next != startOfLoop) { // back to starting point
					counter++;
					begin = begin.next;
				}
			}
		}

		if(startOfLoop == null){ //when no loop
			LinkedListNode<T> head = this;
			while(head.next != null){
				head = head.next;
				counter++;
			}
		}
		return counter;
	}

}

