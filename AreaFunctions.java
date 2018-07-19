package area;

public class AreaFunctions {
	/**
	 * calculates area of triangle
	 * @param height assumes it is positive
	 * @param base of triangle
	 * @return result area of triangle
	 * @throws ArithmeticException
	 */
	public double triangleArea(double height,double base)throws ArithmeticException{
		double result=height*base*0.5;
		return result;
	}
	/**
	 * calculates area of rectangle
	 * @param height assumes it is positive
	 * @param width of rectangle
	 * @return result area of rectangle
	 * @throws ArithmeticException
	 */
	public double rectangleArea(double height,double width)throws ArithmeticException{
		double result=height*width;
		return result;
	}
	/**
	 * calculates area of square
	 * @param sides of square
	 * @return result area of square
	 * @throws ArithmeticException
	 */
	public double squareArea(double side)throws ArithmeticException{
		double result=side*side;
		return result;
	}
	/**
	 * calculates area of circle
	 * @param radius of circle
	 * @return result area of circle
	 * @throws ArithmeticException
	 */
	public double circleArea(double radius)throws ArithmeticException{
		double result=radius*radius*3.14;
		return result;
	}
	
}
