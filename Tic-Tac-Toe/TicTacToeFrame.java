package com.jerryhuang.tictactoe;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;


/**
 * JFrame for tic-tac-toe board
 * @author Jerry
 */
public class TicTacToeFrame extends JFrame {
	
	// Whose turn it is
	private char whoseTurn = 'X';
	TicTacToe intro = new TicTacToe();
	String player1Name = intro.getPlayer1Name();
	String player2Name = intro.getPlayer2Name();
	int gameType = intro.getGameType();
	
	// Creates cell grid
	Cell[][] cells = new Cell[3][3];
	
	// Creates status label
	JLabel gameStatusLabel = new JLabel("X's turn to play"); //panel 2 whose turn
	JLabel gameStatusLabel2 = new JLabel(player1Name + "\n\n: X"); //panel 2 who is x
	JLabel gameStatusLabel3 = new JLabel(player2Name + "\n\n: O"); //panel 2 who is O
	
	
	/**
	 * Arg Constructor
	 */
	public TicTacToeFrame() {
			
			// Creates a panel for grid layout
			//http://www.java-tips.org/java-se-tips-100019/15-javax-swing/1751-how-to-make-split-pane-using-swing8.html
			JPanel gameBoardPanel = new JPanel(new GridLayout(3, 3, 0, 0)); //panel 1
		    JPanel gameStatusPanel = new JPanel(); //panel 2
		    
		    //JLabel gameStatusLabel = new JLabel("Area 2");
		    //gameBoardPanel.add(j1);
	        gameStatusPanel.add(gameStatusLabel2);
	        gameStatusPanel.add(gameStatusLabel3);
	        gameStatusPanel.add(gameStatusLabel);
	        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, gameBoardPanel, gameStatusPanel);
	        splitPane.setResizeWeight(0.9);
	        splitPane.setOneTouchExpandable(true);
	        getContentPane().add(splitPane);
	        
			// Adds 9 cells to grid layout
			for (int i = 0; i < 3; i++) {
				for (int k = 0; k < 3; k++) {
					gameBoardPanel.add(cells[i][k] = new Cell());
				}
			}
			
			
	}
	
	
	/**
	 * Determines if game board is full
	 * @return True, if game board is full. False if not.
	 */
	public boolean boardIsFull() {
		
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (cells[i][k].getToken() == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Determines if given token has won
	 * @param token, to test for winning
	 * @return True, if token has won. False if not.
	 */
	public boolean hasWon(char token) {
		
		// Checks every row
		for (int i = 0; i < 3; i++) {
			if (cells[i][0].getToken() == token && cells[i][1].getToken() == token && cells[i][2].getToken() == token) {
				return true;
				
				
			}
		}
		
		// Checks every column
		for (int k = 0; k < 3; k++) {
			if (cells[0][k].getToken() == token && cells[1][k].getToken() == token && cells[2][k].getToken() == token) {
				return true;
			}
		}
		
		// Checks diagonals
		if (cells[0][0].getToken() == token && cells[1][1].getToken() == token && cells[2][2].getToken() == token) {
			return true;
		}
		if (cells[0][2].getToken() == token && cells[1][1].getToken() == token && cells[2][0].getToken() == token) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Defines a cell on the tic-tac-toe game board
	 * @author Jerry
	 *
	 */
	public class Cell extends JPanel {
		
		// Token of the cell
		private char token = ' ';
		
		public Cell() {
			
			// Sets border of the cell and adds listener for mouse click
			setBorder(new LineBorder(Color.RED, 1));
			addMouseListener(new MyMouseListener());
		}
		
		
		/**
		 * Gets the token of a cell.
		 * @return token value of the cell.
		 */
		public char getToken() {
			return token;
		}
		
		
		/**
		 * Sets the token of a cell
		 * @param token, used as token value
		 */
		public void setToken(char token) {
			this.token = token;
			repaint();
		}
		
		
		//@Override
		/*
		/**
		 * Draws X and O's
		 */
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			if (token == 'X') {
				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(10, getHeight() - 10, getWidth() - 10, 10);
			}
			else if (token == 'O') {
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		}
		
		/** 
		 * Called when a mouse click action is performed
		 */
		private class MyMouseListener extends MouseAdapter {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Cell is empty and game not over
				if (token == ' ' && whoseTurn != ' ') {
					setToken(whoseTurn);
				}
				
				// Check game status
				if (hasWon(whoseTurn)) {
					gameStatusLabel.setText(whoseTurn + " won! Game over!");
					whoseTurn = ' ';
				}
				else if (boardIsFull()) {
					gameStatusLabel.setText("It's a tie!");
					whoseTurn = ' ';
				}
				else {
					
					if (whoseTurn == 'X') {
						whoseTurn = 'O';
					}
					else {
						whoseTurn = 'X';
					}
					
					gameStatusLabel.setText(whoseTurn + "'s turn!");	
				}
			}
		}// End of MyMouseListener class
	} // End of Cell class
} // End of TicTacToeFrame class