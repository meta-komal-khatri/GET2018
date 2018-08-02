package scfsession7;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatriceTest {

	@Test
	public void test() {
		SparseMatrice sparseMatrice1=new SparseMatrice(new int[][] {{1,1,1}, {2,2,1},{2,3,1},{3,1,2},{3,2,1}},3,3);
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,1}, {1,2,1},{2,3,1},{3,1,2},{3,3,1}},3,3);
		//SparseMatrice sparseMatrice3=new SparseMatrice(new int[][] {{1,1,1}, {1,2,1},{2,3,1},{3,1,2},{3,3,1}},3,3);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},{2,3,2},{3,1,4},{3,2,1},{3,3,1}},sparseMatrice.addMatrice(sparseMatrice1).getarray());
		assertArrayEquals(new int[][] {{1,1,1},{1,2,1},{1,3,1},{2,1,2},{2,2,1},{3,1,4},{3,2,1}},sparseMatrice.multiply(sparseMatrice1).getarray());
	}
	@Test
	public void addMatricesTest() {
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,1}, 
																	{1,2,1},
																	{2,3,1},
																	{3,1,2},
																	{3,3,1}},3,3);
		SparseMatrice sparseMatrice1=new SparseMatrice(new int[][] {{1,1,1},
																	{2,2,1},
																	{2,3,1},
																	{3,1,2},{3,2,1}},3,3);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},
			{2,3,2},{3,1,4},{3,2,1},{3,3,1}},sparseMatrice.addMatrice(sparseMatrice1).getarray());
	}
	@Test
	public void multiplytest() {
			SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,1}, 
																		{1,2,1},
																		{2,3,1},
																		{3,1,2},
																		{3,3,1}},3,3);
			SparseMatrice sparseMatrice1=new SparseMatrice(new int[][] {{1,1,1},
																		{2,2,1},
																		{2,3,1},
																		{3,1,2},{3,2,1}},3,3);
			assertArrayEquals(new int[][] {{1,1,1},{1,2,1},{1,3,1},
				{2,1,2},{2,2,1},{3,1,4},{3,2,1}},sparseMatrice.multiply(sparseMatrice1).getarray());
			
	}
	@Test
	public void transposeTest() {
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,1}, 
			{1,2,1},
			{2,3,1},
			{3,1,2},
			{3,3,1}},3,3);
		assertArrayEquals(new int[][] {{1,1,1},{1,3,2},{2,1,1},{3,2,1},{3,3,1}},sparseMatrice.transpose().getarray());
	}
	@Test
	public void isSymmetricTest() {
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,5}, 
			{1,3,3},
			{2,2,1},
			{3,1,3},
			{3,3,5}},3,3);
		assertEquals(true,sparseMatrice.isSymmetric());
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfMatrxIsEmpty() {
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {},3,3);
	}
	//applied to addition method
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSizeOfMatricesAreNotSame() {
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,1}, 
			{1,2,1},
			{2,3,1},
			{3,1,2},
			{3,3,1}},3,3);
		SparseMatrice sparseMatrice1=new SparseMatrice(new int[][] {{1,1,1},
			{2,2,1},
			{2,3,1},
			{3,1,2},{3,2,1}},3,4);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},
			{2,3,2},{3,1,4},{3,2,1},{3,3,1}},sparseMatrice.addMatrice(sparseMatrice1).getarray());
	}
	//applied to multiply method
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfRow1AndColumn2OfMatricesAreNotSame() {
		SparseMatrice sparseMatrice=new SparseMatrice(new int[][] {{1,1,1}, 
			{1,2,1},
			{2,3,1},
			{3,1,2},
			{3,3,1}},3,3);
		SparseMatrice sparseMatrice1=new SparseMatrice(new int[][] {{1,1,1},
			{2,2,1},
			{2,3,1},
			{3,1,2},{3,2,1}},5,4);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},
			{2,3,2},{3,1,4},{3,2,1},{3,3,1}},sparseMatrice.multiply(sparseMatrice1).getarray());
	}
	

}
