package recursion;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchingAlgorithmTest {

	@Test
	void binarySearchAlgorithmTest() {
		SearchingAlgorithms searchingalgorithms=new SearchingAlgorithms();
		assertEquals(2,searchingalgorithms.binarySearchAlgorithm((new int[]{3,4,5,6,7}),5,0,4));
		assertEquals(4,searchingalgorithms.binarySearchAlgorithm(new int[]{1, 2, 3, 4,5},5,0,4));
		
	}
	@Test
	void linearSearchAlgorithmTest() {
		SearchingAlgorithms searchingalgorithms=new SearchingAlgorithms();
		assertEquals(2,searchingalgorithms.linearSearchAlgorithm((new int[]{3,4,5,6,7}),5,0));
		assertEquals(4,searchingalgorithms.linearSearchAlgorithm(new int[]{1, 2, 3, 4,5},5,0));
		assertEquals(-1,searchingalgorithms.linearSearchAlgorithm(new int[]{1, 2, 3, 4,5},6,0));
		


	}
	
	@Test
	void binarySearchAlgorithmThrowsException() {
		SearchingAlgorithms searchingalgorithms=new SearchingAlgorithms();
		 assertThrows(NullPointerException.class, () -> {
			 searchingalgorithms.binarySearchAlgorithm(new int[]{}, 6, 0, 7);
	        });
		 assertThrows(AssertionError.class, () -> {
			 searchingalgorithms.binarySearchAlgorithm(new int[]{4,1,3,2,5}, 6, 0, 4);
	        });
		 assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			 searchingalgorithms.binarySearchAlgorithm(new int[]{1,2,4,6,7}, 5, 0, 6);
	        });
		 
	}@Test
	void linearSearchAlgorithmThrowsException() {
		SearchingAlgorithms searchingalgorithms=new SearchingAlgorithms();
		 assertThrows(NullPointerException.class, () -> {
			 searchingalgorithms.binarySearchAlgorithm(new int[]{}, 6, 0, 7);
	        });
		
		 
	}


}
