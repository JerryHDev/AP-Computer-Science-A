// Gregory Jerian, Jerry Huang, Sid Srinivasan
// Hivolts Project
// APCS
// Cell Class

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Defines each grid position on the 14x14 game board.
 * Each grid on 14x14 game board is an object of type Grids.
 */
public class Cell extends JPanel {

	// True if the specific grid has a fence. False if not.
	private boolean hasFence;

	// Token of a cell in grid
	private char token = ' ';

	/**
	 * Arg - constructor. Constructs a Grid object.
	 * @param isFence; If grid has a fence, isFence gets set to true. Else, isFence gets set to false.
	 */
	public Cell(boolean hasFence) {
		this.hasFence = hasFence;
	}

	public Cell() {

	}
	/**
	 * Gets the token value of a cell in the grid
	 * @return token 
	 */
	public char getToken() {
		return token;
	}


	/**
	 * Sets the token of a cell in the grid
	 * @param token
	 */
	public void setToken(char token) {
		this.token = token;
		repaint();
	}

	@Override
	/**
	 * Draws fences and characters on game board.
	 * @param g
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Makes the background
		Image image2 = Toolkit.getDefaultToolkit().getImage("background.png");
		g.drawImage(image2, 0, 0, this);
		
		// If token of cell is 'F', set image on cell to fence
		if (token == 'F' || token == 'B') {
			Image image = Toolkit.getDefaultToolkit().getImage("fence.png");
			g.drawImage(image, 0, 0, this);
		}

		// If token of cell is 'E', set image on cell to enemy
		else if (token == 'E') {
			Image image = Toolkit.getDefaultToolkit().getImage("enemy.png");
			g.drawImage(image, 0, 0, this);
		}

		// if token of cell is 'P', set image on cell to player
		else if (token == 'P') {
			Image image = Toolkit.getDefaultToolkit().getImage("player.png");
			g.drawImage(image, 0, 0, this);
		}
	}
}