

/*
 * Jerry Huang
 * APCS
 * Period 2
 * 
 * 
 * This class corresponds to an interface that supports a getX, setX, getY, and setY method.
 */
public class MyPoint {
	
	// x and y coordinates for a point
	private int x;
	private int y;
	
	
	// Empty constructor
	public MyPoint() {
		
	}
	
	// Arg-constructor
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	/** Getter Methods */
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	/** Setter Methods */
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

}