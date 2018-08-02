package arroperation;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class CountClumpTest1 {
	   private int[]inputArray;
	   private int expectedResult;
	  
	   private ArrOperations arrOperations;

	   @Before
	   public void initialize() {
		   arrOperations=new ArrOperations();
	   }

	 
		
	   public CountClumpTest1(int expectedResult,int[] inputArray) {
	   this.expectedResult=expectedResult;
	   this.inputArray=inputArray;
	   }

	   @Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	         { 2,new int[] {1,1,2,2,2,2}},
	 		 { 3,new int[] {1,1,2,2,3,3}},
			 { 1,new int[] {1,1,1,1,1}},
			 { 3,new int[] {1,1,2,2,3,3,3,3}},
			 { 0,new int[] {1,2,3,4}},
			 { 0,new int[] {}}		
		
	         
	      });
	   }

	@Test
	public void countClumpTest() {
		assertEquals(expectedResult,arrOperations.countClumps(inputArray));
	}

}
