package scfsession6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnionTest {
	   private int[] setArray;
	   private int[] setArray1;
	   private int[] expectedArray;
	   public UnionTest(int[] expectedArray,int[] setArray,int[] setArray1) {
		 this.expectedArray=expectedArray;
	     this.setArray=setArray;
	     this.setArray1=setArray1;
	   }

	   @Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	         {new int[]{1,2,3,4,5,6,7,8,9,10},new int[]{2,5,7,8,9},new int[]{1,3,4,5,7,8,9,10}},
	         //{new int[]{3,4,5,8,10,14,18},new int[]{3,5,8,10,14},new int[]{4,18}},
	         
	      });
	   }
	   @Test
	   public void unionTest(){
		   IntSet set1=new IntSet(setArray);
		   IntSet set2=new IntSet(setArray1);
		   IntSet set3=new IntSet(expectedArray);
		   assertEquals(set3,set1.unionSet1(set1,set2));
	   }

}
