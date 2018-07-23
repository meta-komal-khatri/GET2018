package recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NQueenProblemTest {

	@Test
	void nQueenProblemTest() {
		NQueenProblem nQueenProblem=new NQueenProblem();
		assertEquals(false,nQueenProblem.nOueen(new int[][] {{0,0,0},{0,0,0},{0,0,0}},0,3));
		assertEquals(true,nQueenProblem.nOueen(new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},0,4));
		assertEquals(true,nQueenProblem.nOueen(new int[][] {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}},0,8));
	}

}
