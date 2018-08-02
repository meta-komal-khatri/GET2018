package scfsession6;

import java.util.HashMap;

import java.util.Map;

public final class Polynomial {
	
	private Map<Integer,Float> poly=new HashMap<Integer,Float>();
	public Polynomial(Map<Integer,Float> poly){
		this.poly=poly;
	}
	public float evaluate(float valueOfX) {
		float sum=0;
		for(int power:poly.keySet()) {
			sum=(float) (sum+(Math.pow(valueOfX, power))*poly.get(power));
		}
		System.out.println(sum);
		return sum;
	}
	public int degree() {
		int maxDegree=0;
		for(int power:poly.keySet()) {
			System.out.println(maxDegree);
			if(power>maxDegree) {
				
				maxDegree=power;
			}
		}
		System.out.println(maxDegree);
		return maxDegree;
	}
	public Polynomial addPolynomial(Polynomial polynomial1,Polynomial polynomial2) {
		int greatestDegree;
	
		Map<Integer,Float> poly1=new HashMap<Integer,Float>();
		if(polynomial1.degree()>polynomial2.degree()) {
			greatestDegree=polynomial1.degree();
		}
		else {
			greatestDegree=polynomial2.degree();
		}
		for(int i=0;i<=greatestDegree;i++) {
			if(polynomial1.poly.containsKey(i) && polynomial2.poly.containsKey(i)) {
				poly1.put(i, polynomial1.poly.get(i)+polynomial2.poly.get(i));
			}
			else if(polynomial1.poly.containsKey(i) && !(polynomial2.poly.containsKey(i))) {
				poly1.put(i,polynomial1.poly.get(i));
			}
			else {
				poly1.put(i,polynomial2.poly.get(i));
			}
		}
		Polynomial polynomial3=new Polynomial(poly1);
		return polynomial3;
	}
	public Polynomial multiplyPolynomial(Polynomial polynomial1,Polynomial polynomial2) {
		Map<Integer,Float> poly1=new HashMap<Integer,Float>();
		for(int i=0;i<=polynomial1.degree();i++) {
			if(polynomial1.poly.containsKey(i)) {
				for(int j=0;j<=polynomial2.degree();j++) {
					if(polynomial2.poly.containsKey(j)) {
						poly1.put(i+j,( poly1.get(i+j)+(polynomial1.poly.get(i)*polynomial2.poly.get(j))));
					}
				}
			}
		}
		Polynomial polynomial3=new Polynomial(poly1);
		return polynomial3;
	}
}
