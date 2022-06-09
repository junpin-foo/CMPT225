package assignment2;

import mystack.MyStack;

/**
 * Additional operations on MyStack
 * 
 * @author Igor
 *
 */

public class MyStackOperations<T>{

	public static <T> int size(MyStack<T> s) {

		int count = 0;
		MyStack<T> temp = new MyStack<T>();

		while(!s.isEmpty()){
			temp.push(s.pop());
			count++;
		}
		while(!temp.isEmpty()){
			s.push(temp.pop());
		}
		return count;
	}

	public static <T> MyStack<T> cloneStack(MyStack<T> orig) {

		MyStack<T> tempFlipped = new MyStack<T>();
		MyStack<T> ret = new MyStack<T>();

		while(!orig.isEmpty()){
			tempFlipped.push(orig.pop());
		}
		while(!tempFlipped.isEmpty()){
			T temp = tempFlipped.pop();;
			ret.push(temp);
			orig.push(temp);

		}
		return ret;
	}

	public static <T> void reverse(MyStack<T> s) {

		MyStack<T> tempFlipped = new MyStack<T>();
		MyStack<T> tempFlippedToNormal = new MyStack<T>();

		if(s.isEmpty())
			return;

		while(!s.isEmpty()){
			tempFlipped.push(s.pop());
		}
		while(!tempFlipped.isEmpty()){
			tempFlippedToNormal.push(tempFlipped.pop());
		}
		while(!tempFlippedToNormal.isEmpty()){
			s.push(tempFlippedToNormal.pop());
		}
	}

	public static void main(String[] args) {
		System.out.println("cloning");
		cloneStack(null);
	}
}


	