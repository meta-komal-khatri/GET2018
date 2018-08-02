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
public class FixXYTest1{
	   private int[]inputArray;
	   private int[] expectedResult;
	   private int x;
	   private int y;
	  
	   private ArrOperations arrOperations;

	   @Before
	   public void initialize() {
		   arrOperations=new ArrOperations();
	   }

	 
		
	   public FixXYTest1(int[] expectedResult,int[] inputArray,int x,int y) {
	   this.expectedResult=expectedResult;
	   this.inputArray=inputArray;
	   this.x=x;
	   this.y=y;
	   }

	   @Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	    	 {new int[] {9, 4, 5, 4, 5, 9},new int[]{5, 4, 9, 4, 9, 5},4,5},
	  		 {new int[] {1, 4, 5, 1},new int[]{1, 4, 1, 5},4,5},
	  		 { new int[] {1,2,3,1},new int[]{1,2,1,3},2,3}
		
	         
	      });
	   }
	   @Test
		public void fixXYTest() {
			assertArrayEquals(expectedResult,arrOperations.fixXY(inputArray, x, y));
		}
}
