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
public class MaxMirrorTest1 {
	   private int[]inputArray;
	   private int expectedResult;
	  
	   private ArrOperations arrOperations;

	   @Before
	   public void initialize() {
		   arrOperations=new ArrOperations();
	   }

	 
		
	   public MaxMirrorTest1(int expectedResult,int[] inputArray) {
	   this.expectedResult=expectedResult;
	   this.inputArray=inputArray;
	   }

	   @Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	    	 { 3,new int[] {1,2,3,8,9,3,2,1}},
	  		 { 4,new int[] {1,1,2,2,2,2}},
	  		 { 2,new int[] {1,1,2,2,3,3}},
	  		 { 5,new int[] {1,1,1,1,1}},
	  		 { 3,new int[] {1,2,3,8,9,3,2,1}},
	  		 { 5,new int[] {1,2,3,2,1}},
	  	   	 { 4,new int[] {7,7,7,7,6,7}}	
		
	         
	      });
	   }
	   @Test
		public void maxMirrorTest() {
			assertEquals(expectedResult,arrOperations.maxMirror(inputArray));
		}
}
