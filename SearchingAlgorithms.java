package recursion;

class SearchingAlgorithms {
	int[] fixedArray;
	public SearchingAlgorithms() {
		//fixedArray=new int[100];
	}
	/**
	 * Search for an element in an array using linear search
	 * @param array should not be null
	 * @param itemToBeSearched 
	 * @return index of array at which given element is found 
	 * and returns -1 if element is not present in given array
	 */
	public int linearSearchAlgorithm(int[] array,int itemToBeSearched,int index) {
		fixedArray=array;
		if(fixedArray.length==0) {
			throw new NullPointerException("Empty array is not allowed");
		}
		if(index>=fixedArray.length) {
			return -1;
			
		}
		if(fixedArray[index]==itemToBeSearched) {
			return index;
		}
		else {
			return linearSearchAlgorithm(fixedArray,itemToBeSearched,index+1);
		}/*
		for(int i=0;i<fixedArray.length;i++)
		{
			if(itemToBeSearched==fixedArray[i]) {
				return i;
			}
		}
		return -1;*/
	}
	/**
	 * Search for an element in an array using binary search
	 * @param array should not be null
	 * @param itemToBeSearched 
	 * @return index of array at which given element is found 
	 * and returns -1 if element is not present in given array
	 */
	public int binarySearchAlgorithm(int[] array,int itemToBeSearched,int start,int end ) {
		
		if(array.length==0) {
			throw new NullPointerException("Empty array is not allowed");
		}
		fixedArray=array;
		for(int i=start;i<end;i++) {
			if(fixedArray[i]>fixedArray[i+1]) {
				throw new AssertionError("Array is not sorted");
			}
		}
		if(start>=0 && end<=fixedArray.length) {
			int middle=end+(start-1)/2;
			if(fixedArray[middle]==itemToBeSearched) {
				return middle;
			}
			else if(fixedArray[middle]>itemToBeSearched) {
				return binarySearchAlgorithm(fixedArray,itemToBeSearched,start,middle-1);
			}
			else if(fixedArray[middle]<itemToBeSearched) {
				return binarySearchAlgorithm(fixedArray,itemToBeSearched,middle+1,end);
			}
			else {
				return -1;
			}
		}
		else {
			throw new ArrayIndexOutOfBoundsException("No Element Found");
		}
		//return -1;
	}
}
