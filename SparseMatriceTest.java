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
		assertArrayEquals(new int[][]{{1,1,1},{1,3,2},{2,2,1},{2,3,1},{3,2,1}},sparseMatrice1.transpose().getarray());
		assertEquals(true,new SparseMatrice(new int[][] {{1,1,5},{1,3,3},{2,2,2},{3,1,3},{3,3,5}},3,3).isSymmetric());
	}
	@Test
	public void addSparseMatricesTest(){
		
	}

}
