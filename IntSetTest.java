package scfsession6;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {

	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsEmpty(){
		IntSet intSet=new IntSet(new int[]{});
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsUnsorted(){
		IntSet intSet=new IntSet(new int[]{1,3,2,8,4});
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsNotInRange(){
		IntSet intSet=new IntSet(new int[]{1,3,5,1111});
	}
	@Test
	public void isMemberTest(){
		IntSet intSet=new IntSet(new int[]{1,3,5,8,12,15,18,40});
		assertEquals(true,intSet.isMember(5));
		assertEquals(false,intSet.isMember(2));
		assertNotEquals(false,intSet.isMember(12));
	}
	@Test
	public void isSubSetTest(){
		IntSet intSet=new IntSet(new int[]{1,3,5,8,12,15,18,40});
		assertEquals(true,intSet.isSubSet(new IntSet(new int[]{8,15})));
		assertEquals(true,intSet.isSubSet(new IntSet(new int[]{8,15,40})));
		assertEquals(true,intSet.isSubSet(new IntSet(new int[]{1,3,5,8,12,15,18,40})));
		assertNotEquals(false,intSet.isSubSet(new IntSet(new int[]{1,3,5,8,12,15,18,40})));
	}
	@Test
	public void complimentTest(){
		IntSet intSet=new IntSet(new int[]{1,3,5,8,12,15,18,40});
		int[] expectedArray=new int[1000-intSet.size()];
		int j=0;
		for(int i=0;i<expectedArray.length;i++){
			if(!intSet.isMember(i+1)){
				expectedArray[j]=i+1;
				j++;
				//System.out.println("test"+expectedArray[j-1]);
				
			}
		}
		int[] arra=intSet.compliment().getSetArray();
		for(int i=0;i<arra.length;i++){
			//System.out.println("test"+arra[i]);
		}
		assertArrayEquals(expectedArray,(intSet.compliment()).getSetArray());
	}

}
