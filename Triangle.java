package recursion;

/**
 * Program illustrating recursion;
 * A triangle shape composed of stacked unit squares like so:
 * []
 * [][]
 * [][][]
 * @author Brenton Otis
 */

public class Triangle {
	
	// Instance variable
	private int width;
	
	/**
	 * Constructs triangular shape
	 * @param aWidth - the width (and hieght) of the triangle
	 */
	public Triangle(int aWidth) {
		
		width = aWidth;
	}
	
	/**
	 * Computes the area of the triangle via recursion (calls getArea within itself)
	 * @return - area
	 */
	public int getArea() {
		if (width <= 0) {
			return 0;
		}
		else if (width == 1) {
			return 1;
		}
		else {
			Triangle smallerTriangle = new Triangle(width - 1);
			int smallerArea = smallerTriangle.getArea();
			return smallerArea + width;
		}
	}
	
	// Driver
	public static void main (String[] args) {
		Triangle t = new Triangle(10);
		int area = t.getArea();
		System.out.println("Area = " + area);
		System.out.println("Expected: 55");
	}
}
