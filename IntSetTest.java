package scfsession6;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {

	@Test
	public void test() {
		IntSet intSet=new IntSet(new int[]{1,5,3,1111});
	
		IntSet s=new IntSet(new int[]{7,8});
		assertEquals(true,intSet.isMember(3));
		assertEquals(false,s.isMember(3));
		
		assertEquals(true,intSet.isSubSet(s));
		
	}

}
