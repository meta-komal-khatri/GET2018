package recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculateLcmHcfTest {

	
	@Test
	void calculateHCFTest() {
		CalculateLcmHcf calculate=new CalculateLcmHcf();
		assertEquals(1,calculate.calculateHCFOfGivenNumber(5, 1));
		assertEquals(-1,calculate.calculateHCFOfGivenNumber(1, 8));
		assertThrows(AssertionError.class, () -> {
			calculate.calculateHCFOfGivenNumber(-1,-5);
		});
		
		//assertEquals((AssertionError.class),calculate.calculateHCFOfGivenNumber(-1,-5));
	}
	@Test
	void calculateLCMTest() {
		CalculateLcmHcf calculate=new CalculateLcmHcf();
		assertEquals(5,calculate.calculateLCMOfGivenNumbers(5, 1));
		assertEquals(-1,calculate.calculateLCMOfGivenNumbers(1, 8));
		assertThrows(AssertionError.class, () -> {
			calculate.calculateLCMOfGivenNumbers(-1,-5);
		});
		//assertEquals((AssertionError.class),calculate.calculateLCMOfGivenNumbers(-1,-5));
	}

}
