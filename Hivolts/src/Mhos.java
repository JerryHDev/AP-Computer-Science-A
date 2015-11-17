// Gregory Jerian, Jerry Huang, Sid Srinivasan
// Hivolts Project
// APCS
// Mhos Class

public class Mhos {
	
	private int xPos = 0;
	private int yPos = 0;
	
	public Mhos() {
	}
	
	public void setPosition(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void moveUp() {
		yPos --;
	}
	
	public void moveDown() {
		yPos ++;
	}
	
	public void moveLeft() {
		xPos --;
	}
	
	public void moveRight() {
		xPos ++;
	}
	
	public void moveUpRight() {
		xPos ++;
		yPos --;
	}
	
	public void moveUpLeft() {
		xPos--;
		yPos--;
	}
	
	public void moveDownRight() {
		xPos++;
		yPos++;
	}
	
	public void moveDownLeft() {
		xPos--;
		yPos++;
	}
	
	public int getXPosition() {
		return xPos;
	}
	
	public int getYPosition() {
		return yPos;
	}
	
	public void remove() {
		xPos = 0;
		yPos = 0;
	}
}