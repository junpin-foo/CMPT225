package myiterators;

public class FibonacciIterator implements IntegerIterator
{
	public int array[];
	public int iterator = -1;
	/**
	 * Creates a default Fibonacci Iterator with a0=0 and a1=1 
	 */
	public FibonacciIterator() {

		int arr[] = new int[2];
		arr[0] = 0;
		arr[1] = 1;
		array = arr;
	}
	
	/**
	 * @param a0 the zero element of the sequence 
	 * @param a1 the first element of the sequence
	 */
	public FibonacciIterator(int a0, int a1) {
		int arr[] = new int[2];
		arr[0] = a0;
		arr[1] = a1;
		array = arr;

	}

	public static int[] append(int[] arr){

		int NArr[] = new int[arr.length+1];

		for(int i = 0; i <arr.length; i++) {
			NArr[i] = arr[i];
		}
		//next fibo # appended to array
		NArr[arr.length] = NArr[arr.length - 1] + NArr[arr.length - 2];

			return NArr;
	}

	public boolean hasNext() {
		int size = array.length;
		if((iterator + 1) >= size)
			array = append(array);

		return true;
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
