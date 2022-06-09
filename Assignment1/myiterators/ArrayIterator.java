package myiterators;

public class ArrayIterator implements IntegerIterator
{
	public int array[];
	public int iterator = -1;
	/**
	 * @param ar
	 * Creates an iterator for the array 
	 */
	public ArrayIterator(int[] ar) {
		array = ar;
	}

	public boolean hasNext() {
		int size = array.length;
		if((iterator + 1) < size)
			return true;

		return false;
	}
	
	public int getNext() {
		if(hasNext())
			return array[++iterator];
		return 0;
	}
	
	public void reset() {
		if(iterator != -1)
			iterator = -1;
	}
}
