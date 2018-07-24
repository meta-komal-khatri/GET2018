package scfsession6;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PolynomialTest {

	
	@Test
	public void test() {
		Map<Integer,Float> poly1=new HashMap<Integer,Float>();
		Map<Integer,Float> poly2=new HashMap<Integer,Float>();
		
		poly1.put(3,2.0f);
		poly1.put(2, 4.0f);
		poly1.put(4,3.0f);
		poly1.put(1, -2.0f);
		poly2.put(2,2.0f);
		poly2.put(3,2.0f);
		Polynomial polynomial=new Polynomial(poly1);
		Polynomial polynomial1=new Polynomial(poly2);
		assertEquals(76f,polynomial.evaluate(2f),0.001);
		assertEquals(76,polynomial.evaluate(2f),0.001);
		assertEquals(24,polynomial1.evaluate(2f),0.001);
		assertEquals(4,polynomial.degree());
	}

}
