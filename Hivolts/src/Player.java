// Gregory Jerian, Jerry Huang, Sid Srinivasan
// Hivolts Project
// APCS
// Player Class

public class Player {
	
	private int xPos = 0;
	private int yPos = 0;
	
	public Player() {
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
	
	/** Random number generator used to move player to random cell */
	public void moveToRandomPosition(Cell[][] grid) {
		int xPos = 2 + (int)(Math.random() * 10);
		int yPos = 2 + (int)(Math.random() * 10);
		while (grid[xPos][yPos].getToken() == 'F' || grid[xPos][yPos].getToken() == 'B' || grid[xPos][yPos].getToken() == 'O') {
			xPos = 2 + (int)(Math.random() * 10);
			yPos = 2 + (int)(Math.random() * 10);
		}
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public int getXPosition() {
		return xPos;
	}
	
	public int getYPosition() {
		return yPos;
	}
}