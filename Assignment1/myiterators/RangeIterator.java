package myiterators;

public class RangeIterator implements IntegerIterator
{
	public int array[];
	public int iterator = -1;
	/**
	 * @param n
	 * Creates an iterator with range 0,1, ..., n-1
	 */
	public RangeIterator(int n) {
		if(n < 0) {
			System.out.println("Sequence is empty.");
			return;
		}
		int arr[] = new int[n];
		for(int index = 0; index < n; index++ ){
			arr[index] = index;
		}
		array = arr;
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+1, ..., n-1
	 */
	public RangeIterator(int a0, int n) {
		if(n < a0) {
			System.out.println("Sequence is empty.");
			return;
		}
		int count = 0;
		for(int index = 0; a0 + index < n; index++ ) {
			count++;
		}

		int arr[] = new int[count];
		for(int index = 0; a0 + index < n; index++ ){
			arr[index] = a0 + index;
		}
		array = arr;
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+diff, , a0+2*diff, ..., a0+k*diff
	 * for the maximal k such that a0+k*diff<n
	 */
	public RangeIterator(int a0, int n, int diff) {
		if(n < a0) {
			System.out.println("Sequence is empty.");
			return;
		}
		int count = 0;
		for(int index = 0; a0 + index*diff < n; index++ ) {
			count++;
		}

		int arr[] = new int[count];

		for(int index2 = 0; a0 + index2*diff < n; index2++ ){
			arr[index2] = a0 + index2*diff;
		}
		 array = arr;
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
