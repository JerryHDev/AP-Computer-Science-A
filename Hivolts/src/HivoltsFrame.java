// Gregory Jerian, Jerry Huang, Sid Srinivasan
// Hivolts Project
// APCS
// HivoltsFrame Class

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class HivoltsFrame extends JFrame {

	Cell[][] grid; // Creates an array of cells of type Cell. Type Cell is defined in the Cell class
	Mhos[] mho = new Mhos[12]; // Creates array of mho objects of type Mhos.
	Player player = new Player(); // Creates player object
	Keyboard key = new Keyboard(); // Creates key object
	
	JPanel gameBoardPanel; // Creates gameboard panel
	int mhosLeft = 12; // # of mhos left on gameboard

	/** No-arg Constructor */
	public HivoltsFrame() {
		init();
		addKeyListener(key); // listens to key inputs
	}
	
	public void init() {
		key.reset();
		setSize(700,700);
		grid = new Cell[14][14];
		gameBoardPanel = new JPanel(new GridLayout(14, 14, 0, 0)); // Creates a panel for the gameboard

		// Adds 14x14 grid to game panel
		for (int k = 0; k < 14; k++) {
			for (int i = 0; i < 14; i++) {

				// Sets token of border line to 'O'
				if (k == 0 || k == 13) {
					gameBoardPanel.add(grid[i][k] = new Cell(true));
					grid[i][k].setToken('O');
				}
				else if (i == 0 || i == 13) {
					gameBoardPanel.add(grid[i][k] = new Cell(true));
					grid[i][k].setToken('O');
				}

				// Sets token of border fences to 'B'
				else if (i == 1 && k > 0 && k < 13) {
					gameBoardPanel.add(grid[i][k] = new Cell(true)); 
					grid[i][k].setToken('B');
				}
				else if (k == 1 && i > 0 && i < 13) {
					gameBoardPanel.add(grid[i][k] = new Cell(true)); 
					grid[i][k].setToken('B');
				}
				else if (i == 12 && k > 0 && k < 13) {
					gameBoardPanel.add(grid[i][k] = new Cell(true)); 
					grid[i][k].setToken('B'); // 
				}
				else if (k == 12 && i > 0 && i < 13) {
					gameBoardPanel.add(grid[i][k] = new Cell(true)); 
					grid[i][k].setToken('B');
				}
				
				// Not a fence. An enemy or player.
				else {
					gameBoardPanel.add(grid[i][k] = new Cell(false)); 
				}
			}
		}

		// Sets 12 random cells in grid to enemy
		for (int i = 0; i < 12; i++) {
			mho[i] = new Mhos();
			int xPos = 2 + (int)(Math.random() * 10);
			int yPos = 2 + (int)(Math.random() * 10);
			while (grid[xPos][yPos].getToken() != ' ') {
				xPos = 2 + (int)(Math.random() * 10);
				yPos = 2 + (int)(Math.random() * 10);
			}
			mho[i].setPosition(xPos, yPos);
			grid[xPos][yPos].setToken('E');
		}

		// Sets 20 random cells in grid to fences
		for (int i = 0; i < 20; i++) {
			int xPos = 2 + (int)(Math.random() * 10);
			int yPos = 2 + (int)(Math.random() * 10);
			while (grid[xPos][yPos].getToken() != ' ') {
				xPos = 2 + (int)(Math.random() * 10);
				yPos = 2 + (int)(Math.random() * 10);
			}
			grid[xPos][yPos].setToken('F');
		}

		// Sets 1 random cell in grid to player
		int xPos = 2 + (int)(Math.random() * 10);
		int yPos = 2 + (int)(Math.random() * 10);
		while (grid[xPos][yPos].getToken() != ' ') {
			xPos = 2 + (int)(Math.random() * 10);
			yPos = 2 + (int)(Math.random() * 10);
		}
		player.setPosition(xPos, yPos);
		grid[xPos][yPos].setToken('P');

		add(gameBoardPanel); // adds game panel to frame and display the game panel on GUI Frame
		repaint();
	} // End of init() function

	/** Updates each mho's position after player moves */
	public void updateMhosPositions() {

		// Loops through array of mhos and updates each one's position
		for (int i = 0; i < 12; i++) {
			
			if (mhoIsVerticalToPlayer(i)) {
				grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken(' ');
				if (mhoIsUnderPlayer(i)) {
					if (grid[mho[i].getXPosition()][mho[i].getYPosition() - 1].getToken() != 'E') {
						moveMho(i, "up"); // move mho up
					}
					else
						grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
				}
				else {
					if (grid[mho[i].getXPosition()][mho[i].getYPosition() + 1].getToken() != 'E') {
						moveMho(i, "down"); // move mho down
					}
					else
						grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
				}
			}
			
			else if (mhoIsHorizontalToPlayer(i)) {
				grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken(' ');
				if (mhoIsRightOfPlayer(i)) {
					if (grid[mho[i].getXPosition() - 1][mho[i].getYPosition()].getToken() != 'E') {
						moveMho(i, "left"); // move mho left
					}
					else
						grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
				}
				else {
					if (grid[mho[i].getXPosition() + 1][mho[i].getYPosition()].getToken() != 'E') {
						moveMho(i, "right"); // move mho right
					}
					else
						grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
				}
			}
			else if (mhoIsDiagonalToPlayer(i)) {
				grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken(' ');
				if (mhoIsRightOfPlayer(i)) {
					if (mhoIsUnderPlayer(i)) {
						if (grid[mho[i].getXPosition() - 1][mho[i].getYPosition() - 1].getToken() != 'E') {
							moveMho(i, "upleft"); // move mho up-left
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
					else {
						if (grid[mho[i].getXPosition() - 1][mho[i].getYPosition() + 1].getToken() != 'E') {
							moveMho(i, "downleft"); // move mho down-left
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
				}
				else {
					if (mhoIsUnderPlayer(i)) {
						if (grid[mho[i].getXPosition() + 1][mho[i].getYPosition() - 1].getToken() != 'E') {
							moveMho(i, "upright"); // move mho up-right
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
					else {
						if (grid[mho[i].getXPosition() + 1][mho[i].getYPosition() + 1].getToken() != 'E') {
							moveMho(i, "downright"); // move mho down-right
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
				}
			}
			else {
				grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken(' ');
				if (horizontalDistanceGreaterThanVerticalDistance(i)) {
					if (mhoIsRightOfPlayer(i)) {
						if (grid[mho[i].getXPosition() - 1][mho[i].getYPosition()].getToken() != 'E') {
							moveMho(i, "left"); // move mho left
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
					else {
						if (grid[mho[i].getXPosition() + 1][mho[i].getYPosition()].getToken() != 'E') {
							moveMho(i, "right"); // move mho right
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
				}
				else {
					if (mhoIsUnderPlayer(i)) {
						if (grid[mho[i].getXPosition()][mho[i].getYPosition() - 1].getToken() != 'E') {
							moveMho(i, "up"); // move mho up
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
					else {
						if (grid[mho[i].getXPosition()][mho[i].getYPosition() + 1].getToken() != 'E') {
							moveMho(i, "down"); // move mho down
						}
						else
							grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
					}
				}
			}		
		}
	} // End of updateMhosPositions() method

	
	/**
	 * Checks mho position relative to player
	 * @param i
	 */
	public boolean mhoIsVerticalToPlayer(int i) {
		if (mho[i].getXPosition() == player.getXPosition()) {
			return true;
		}
		return false;
	}
	public boolean mhoIsHorizontalToPlayer(int i) {
		if (mho[i].getYPosition() == player.getYPosition()) {
			return true;
		}
		return false;
	}
	public boolean mhoIsDiagonalToPlayer(int i) {
		if (Math.abs(mho[i].getYPosition() - player.getYPosition()) == Math.abs(mho[i].getXPosition() - player.getXPosition())) {
			return true;
		}
		return false;
	}
	public boolean horizontalDistanceGreaterThanVerticalDistance(int i) {
		if (Math.abs(mho[i].getYPosition() - player.getYPosition()) < Math.abs(mho[i].getXPosition() - player.getXPosition())) {
			return true;
		}
		return false;
	}
	public boolean mhoIsUnderPlayer(int i) {
		if (mho[i].getYPosition() > player.getYPosition()) {
			return true;
		}
		return false;
	}
	public boolean mhoIsRightOfPlayer(int i) {
		if (mho[i].getXPosition() > player.getXPosition()) {
			return true;
		}
		return false;
	}

	
	/** Moves mho in a certain direction */
	public void moveMho(int i, String direction) {
		switch (direction) {
		case "left":
			mho[i].moveLeft();
			break;
		case "right":
			mho[i].moveRight();
			break;
		case "up":
			mho[i].moveUp();
			break;
		case "down":
			mho[i].moveDown();
			break;
		case "upright":
			mho[i].moveUpRight();
			break;
		case "upleft":
			mho[i].moveUpLeft();
			break;
		case "downright":
			mho[i].moveDownRight();
			break;
		case "downleft":
			mho[i].moveDownLeft();
		}
		if (mhoLost(i)) {
			mho[i].remove();
			mhosLeft--;
		}
		else if (grid[mho[i].getXPosition()][mho[i].getYPosition()].getToken() == 'B' || grid[mho[i].getXPosition()][mho[i].getYPosition()].getToken() == 'O') {
			mho[i].remove();
		}
		else {
			grid[mho[i].getXPosition()][mho[i].getYPosition()].setToken('E');
		}
	}

	/** Moves player in a certain direction */
	public void movePlayer(String direction) {
		grid[player.getXPosition()][player.getYPosition()].setToken(' ');
		switch (direction) {
		case "left":
			player.moveLeft();
			break;
		case "right":
			player.moveRight();
			break;
		case "up":
			player.moveUp();
			break;
		case "down":
			player.moveDown();
			break;
		case "upright":
			player.moveUpRight();
			break;
		case "upleft":
			player.moveUpLeft();
			break;
		case "downright":
			player.moveDownRight();
			break;
		case "downleft":
			player.moveDownLeft();
			break;
		case "randomposition":
			player.moveToRandomPosition(grid);
			break;
		default:
			System.out.println("Invalid key!");
		
		}
		isGameOver();
		grid[player.getXPosition()][player.getYPosition()].setToken('P');
	}

	
	/** Checks if player or mho lost */
	public boolean playerLost() {
		if (grid[player.getXPosition()][player.getYPosition()].getToken() == 'E' || grid[player.getXPosition()][player.getYPosition()].getToken() == 'F' || grid[player.getXPosition()][player.getYPosition()].getToken() == 'B') {
			return true;
		}
		return false;
	}
	public boolean mhoLost(int i) {
		if (grid[mho[i].getXPosition()][mho[i].getYPosition()].getToken() == 'F') {
			return true;
		}
		return false;
	}

	
	/** Checks if game is over and asks player if they want to start a new game */
	public void isGameOver() {
		if (playerLost()) {
			int input = JOptionPane.showConfirmDialog(null, "Play again?", "GAME OGRE!!!!", JOptionPane.YES_NO_OPTION);
			if (input == JOptionPane.YES_OPTION) {
				newGame();
				dispose();
			}
			else
				System.exit(0);
		}
	}

	
	/** Checks if player has won and asks player if they want to start a new game */
	public void isGameWon() {
		if (mhosLeft == 0) {
			int input = JOptionPane.showConfirmDialog(null, "Play again?", "You win!", JOptionPane.YES_NO_OPTION);
			if (input == JOptionPane.YES_OPTION) {
				newGame();
				dispose();
			}
			else
				System.exit(0);
		}
	}
	
	/** Starts a new game if the player selects to continue */
	public void newGame(){
		JFrame hivolts = new HivoltsFrame();
		hivolts.setTitle("Hivolts Game");
		hivolts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hivolts.setVisible(true);
	}

	/**
	 * Defined Keyboard class.
	 * Detects key inputs.
	 */
	public class Keyboard implements KeyListener{

		private boolean[] keys = new boolean[120];
		public boolean up, down, left, right, upRight, upLeft, downRight, downLeft, sit, jump;

		public void updateKeys() {
			up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
			down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_X];
			left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
			right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
			upRight = keys[KeyEvent.VK_E];
			upLeft = keys[KeyEvent.VK_Q];
			downRight = keys[KeyEvent.VK_C];
			downLeft = keys[KeyEvent.VK_Z];
			sit = keys[KeyEvent.VK_S];
			jump = keys[KeyEvent.VK_J];
		}
		public void reset(){
			for (int i=0;i < keys.length;i++){
				keys[i]=false;
			}
		}

		/** Called whenever a key is pressed */
		public void keyPressed(KeyEvent e) {
			keys[e.getKeyCode()] = true;
			updateKeys();
			if (up) {
				System.out.println("Up key pressed.");
				movePlayer("up");
				updateMhosPositions();
			}
			else if (down) {
				System.out.println("Down key pressed.");
				movePlayer("down");
				updateMhosPositions();
			}
			else if (left) {
				System.out.println("Left key pressed.");
				movePlayer("left");
				updateMhosPositions();
			}
			else if (right) {
				System.out.println("Right key pressed.");
				movePlayer("right");
				updateMhosPositions();
			}
			else if (upRight) {
				System.out.println("Up right key pressed.");
				movePlayer("upright");
				updateMhosPositions();
			}
			else if (upLeft) {
				System.out.println("Up left key pressed.");
				movePlayer("upleft");
				updateMhosPositions();
			}
			else if (downRight) {
				System.out.println("Down right key pressed.");
				movePlayer("downright");
				updateMhosPositions();
			}
			else if (downLeft) {
				System.out.println("Down left key pressed.");
				movePlayer("downleft");
				updateMhosPositions();
			}
			else if (jump) {
				System.out.println("J key pressed. Jumped to random spot. Still your turn if you did not land on mho.");
				movePlayer("randomposition");
			}
			else if (sit) {
				System.out.println("Sit key pressed.");
				updateMhosPositions();
			}
			else
				System.out.println("Invalid key!");
			
			isGameOver(); // checks if game over - player lost
			isGameWon(); // checks if game is won
		}
		public void keyReleased(KeyEvent e) {
			keys[e.getKeyCode()] = false;
		}
		public void keyTyped(KeyEvent e) {
		}
	} // End of Keyboard Class
	
} // End of HivoltsFrame Class