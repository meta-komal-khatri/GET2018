package arroperation;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class ArrOperationExceptionTest {
	ArrOperations arroperation=new ArrOperations();

	@Test
	public void maxMirrorthrowsAssertionErrorIfArrayIsNull() {
		
		 assertThrows(AssertionError.class, () -> {
			 arroperation.maxMirror(new int[]{});
	        });
	}
	@Test
	public void countClumpthrowsAssertionErrorIfArrayIsNull() {
		
		 assertThrows(AssertionError.class, () -> {
			 arroperation.countClumps(new int[]{});
	        });
	}
	@Test
	public void splitSumthrowsAssertionErrorIfArrayIsNull() {
		
		 assertThrows(AssertionError.class, () -> {
			 arroperation.splitSum(new int[]{});
	        });
	}
	@Test
	public void fixXYthrowsExceptions() {
		
		 assertThrows(AssertionError.class, () -> {
			 arroperation.fixXY(new int[]{}, 4,5);
	});
		 assertThrows(IllegalStateException.class, () -> {
			 arroperation.fixXY(new int[]{4,5,1,5,4},4,5);
	});
		 assertThrows(IllegalStateException.class, () -> {
			 arroperation.fixXY(new int[]{4,5,1,5,4},4,5);
	});
		 assertThrows(IllegalStateException.class, () -> {
			 arroperation.fixXY(new int[]{1,1,3,2,2},1,2);
	});
		
		 
	}
}
