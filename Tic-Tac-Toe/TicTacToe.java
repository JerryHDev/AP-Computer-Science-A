package com.jerryhuang.tictactoe;

import java.util.Scanner;

import javax.swing.JFrame;


/**
 * Main class for Tic-Tac-Toe game
 * @author Jerry
 *
 */
public class TicTacToe {
	
	static String player1Name;
	static String player2Name;
	static int gameType;
	
	
	public TicTacToe() {
		
	}
	
	public static void main(String[] args) {
		
		//makes intro gui appear
		JFrame intro = new IntroFrame();
		intro.setSize(780, 600);
		intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intro.setVisible(true);	
		
		determineGameType();
		
		//ask players for their names
		Scanner input = new Scanner(System.in);
		System.out.println("Enter player 1's name:");
		player1Name = input.next(); //X
		System.out.println("Enter player 2's name:");
		player2Name = input.next(); //O
		
		
		
		if (gameType == 0){
			pvpIntro(player1Name, player2Name);
		}
		
		
		//makes the tic tac toe gameboard gui appear
		JFrame ticTacToe = new TicTacToeFrame();
		ticTacToe.setTitle("Tic-Tac-Toe");
		ticTacToe.setSize(780, 600);
		ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ticTacToe.setVisible(true);	
	}
	
	
	// Determines the game type
	public static int determineGameType() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 0 to play against another player, and 1 to play against the computer: ");
		gameType = input.nextInt();
		
		// while loop until player enters a 0 or 1
		while (gameType != 0 && gameType != 1) {
			System.out.print("Please only enter '0' or '1': ");
			gameType = input.nextInt();
		}
		
		return gameType;
	}
	
	public static void pvpIntro(String playerXName, String playerOName){
		System.out.println("\nHi! \n\n" + playerXName + ", you will be playing as X. \n\n" + playerOName + ", you will be playing as O.");
	}
	
	
	
	//get player 1's name (x)
	//for pvp and pvc
	public static String getPlayer1Name() {
		return player1Name;
	}
	
	//get player 2's name (y)
	//only for pvp
	public static String getPlayer2Name(){
		return player2Name;
	}
	
	public static int getGameType() {
		return gameType;
	}
	
}
