package arroperation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SplitSumTest {

	@Test
	void splitSumTest() {
		ArrOperations arroperation=new ArrOperations();
		assertEquals(-1,arroperation.splitSum(new int[] {1,1,2,2,2,2}));
		assertEquals(3,arroperation.splitSum(new int[] {1,1,1,1,2}));
		assertEquals(3,arroperation.splitSum(new int[] {1,1,1,1,1,1}));
		assertEquals(5,arroperation.splitSum(new int[] {1,1,2,2,3,3,3,3}));
		assertEquals(-1,arroperation.splitSum(new int[] {1,2,3,4}));
		assertEquals(0,arroperation.splitSum(new int[] {}));	
	}

}
