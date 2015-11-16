package com.jerryhuang.usflag;

//Jerry Huang
//AP CS
//US Flag Project

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class USFlagFrame extends JFrame {
	
	// Initialize constants
	Color flagBlue = new Color(54, 20, 178);
	double flagStartingXPos = 0;
	double flagStartingYPos = 22;
	
	// flagHeight is used as scaling factor
	double flagHeight = 200; 
	double flagWidth = flagHeight * 1.9;
	double unionHeight = (7 * flagHeight) / 13;
	double unionWidth = 0.76 * flagHeight;
	double stripeHeight = flagHeight / 13;
	double bottomStripeWidth = flagWidth;
	double topStripeWidth = flagWidth - unionWidth;
	double starRadius = (0.0616 * flagHeight) / 2;
	double starXGap = 0.063 * flagHeight; // X VALUE GAP BETWEEN EACH STAR
	double starYGap = 0.054 * flagHeight; // Y VALUE GAP BETWEEN EACH STAR
	double starStartingXPos = flagStartingXPos; // STAR'S STARTING X POSITION
	double starStartingYPos = flagStartingYPos - starRadius; // STAR'S STARTING Y POSITION
	double starInnerRadius = 0.382 * starRadius;
	
	// x and y positions for all 10 vertices of the first star
	double vertex1X = starStartingXPos;
	double vertex2X = starStartingXPos + (Math.cos(54 * Math.PI / 180) * starInnerRadius);
	double vertex3X = starStartingXPos + (starRadius * Math.cos(18 * Math.PI / 180));
	double vertex4X = starStartingXPos + (Math.cos(18 * Math.PI / 180) * starInnerRadius);
	double vertex5X = starStartingXPos + (starRadius * Math.cos(54 * Math.PI / 180));
	double vertex6X = starStartingXPos;
	double vertex7X = starStartingXPos - (starRadius * Math.cos(54 * Math.PI / 180));
	double vertex8X = starStartingXPos - (Math.cos(18 * Math.PI / 180) * starInnerRadius);
	double vertex9X = starStartingXPos - (starRadius * Math.cos(18 * Math.PI / 180));
	double vertex10X = starStartingXPos - (Math.cos(54 * Math.PI / 180) * starInnerRadius);
	double vertex1Y = starStartingYPos;
	double vertex2Y = (starStartingYPos + starRadius) - (Math.sin(54 * Math.PI / 180) * starInnerRadius);
	double vertex3Y = (starStartingYPos + starRadius) - (starRadius * Math.sin(18 * Math.PI / 180));
	double vertex4Y = (starStartingYPos + starRadius) + (Math.sin(18 * Math.PI / 180) * starInnerRadius);
	double vertex5Y = (starStartingYPos + starRadius) + (starRadius * Math.sin(54 * Math.PI / 180));
	double vertex6Y = starStartingYPos + starRadius + starInnerRadius;
	double vertex7Y = (starStartingYPos + starRadius) + (starRadius * Math.sin(54 * Math.PI / 180));
	double vertex8Y = starStartingYPos + starRadius + (Math.sin(18 * Math.PI / 180) * starInnerRadius);
	double vertex9Y = (starStartingYPos + starRadius) - (starRadius * Math.sin(18 * Math.PI / 180));
	double vertex10Y = (starStartingYPos + starRadius) - (Math.sin(54 * Math.PI / 180) * starInnerRadius);
	
	
	public USFlagFrame () {
		init();
	}
	
	
	public void init() {
		setSize(800,600);
		setBackground(Color.WHITE);
		repaint();
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		// Creates variable g2 of type Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		// Method to update the scale variables
		updateScaleVariables();
		
		// Methods to draw flag
		drawFlagOutline(g2);
		drawUnion(g2);
		drawStripes(g2);
		drawStars(g2);
	}
	
	
	/**
	 * Updates every variable to scale.
	 * Every variable is in scale with flagWidth and flagHeight, so updating these two
	 * variables updates every other variable.
	 * 
	 */
	public void updateScaleVariables() {
		flagWidth = getWidth(); // flagWidth and flagHeight are updated, every other variable is in scale with these two values
		flagHeight = flagWidth / 1.9;
		unionHeight = (7 * flagHeight) / 13;
		unionWidth = 0.76 * flagHeight;
		stripeHeight = flagHeight / 13;
		bottomStripeWidth = flagWidth;
		topStripeWidth = flagWidth - unionWidth;
		starRadius = (0.0616 * flagHeight) / 2;
		starXGap = 0.063 * flagHeight; // X VALUE GAP BETWEEN EACH STAR
		starYGap = 0.054 * flagHeight; // Y VALUE GAP BETWEEN EACH STAR
		starStartingXPos = flagStartingXPos; // STAR'S STARTING X POSITION
		starStartingYPos = flagStartingYPos - starRadius; // STAR'S STARTING Y POSITION
		starInnerRadius = 0.382 * starRadius;
		vertex1X = starStartingXPos;
		vertex2X = starStartingXPos + (Math.cos(54 * Math.PI / 180) * starInnerRadius);
		vertex3X = starStartingXPos + (starRadius * Math.cos(18 * Math.PI / 180));
		vertex4X = starStartingXPos + (Math.cos(18 * Math.PI / 180) * starInnerRadius);
		vertex5X = starStartingXPos + (starRadius * Math.cos(54 * Math.PI / 180));
		vertex6X = starStartingXPos;
		vertex7X = starStartingXPos - (starRadius * Math.cos(54 * Math.PI / 180));
		vertex8X = starStartingXPos - (Math.cos(18 * Math.PI / 180) * starInnerRadius);
		vertex9X = starStartingXPos - (starRadius * Math.cos(18 * Math.PI / 180));
		vertex10X = starStartingXPos - (Math.cos(54 * Math.PI / 180) * starInnerRadius);
		vertex1Y = starStartingYPos;
		vertex2Y = (starStartingYPos + starRadius) - (Math.sin(54 * Math.PI / 180) * starInnerRadius);
		vertex3Y = (starStartingYPos + starRadius) - (starRadius * Math.sin(18 * Math.PI / 180));
		vertex4Y = (starStartingYPos + starRadius) + (Math.sin(18 * Math.PI / 180) * starInnerRadius);
		vertex5Y = (starStartingYPos + starRadius) + (starRadius * Math.sin(54 * Math.PI / 180));
		vertex6Y = starStartingYPos + starRadius + starInnerRadius;
		vertex7Y = (starStartingYPos + starRadius) + (starRadius * Math.sin(54 * Math.PI / 180));
		vertex8Y = starStartingYPos + starRadius + (Math.sin(18 * Math.PI / 180) * starInnerRadius);
		vertex9Y = (starStartingYPos + starRadius) - (starRadius * Math.sin(18 * Math.PI / 180));
		vertex10Y = (starStartingYPos + starRadius) - (Math.sin(54 * Math.PI / 180) * starInnerRadius);
		
	}
	
	/**
	 * Draws flag outline
	 * @param g2
	 */
	public void drawFlagOutline(Graphics2D g2) {
		Rectangle2D flagRect = new Rectangle2D.Double(flagStartingXPos, flagStartingYPos, flagWidth, flagHeight);
		g2.setPaint(Color.BLACK);
      g2.draw(flagRect);
	}
	
	
	/**
	 * Draws union
	 * @param g2
	 */
	public void drawUnion(Graphics2D g2) {
		Rectangle2D unionRect = new Rectangle2D.Double(flagStartingXPos, flagStartingYPos, unionWidth, unionHeight);
      g2.setPaint(flagBlue);
      g2.fill(unionRect);
      g2.setPaint(Color.BLACK);
      g2.draw(unionRect);
	}
	
	
	/**
	 * Draws stripes
	 * Rectangle 2D is used to draw rectangles with Double value coordinates
	 * @param g2
	 */
	public void drawStripes(Graphics2D g2) {
		
		// Loops through the 13 stripes of the flag
		for (int i = 0; i < 13; i++) {
			
      	// Checks if stripe is in the top or bottom half of flag
      	if (i <= 6) { // Top half
      		Rectangle2D stripe = new Rectangle2D.Double(flagStartingXPos + unionWidth, flagStartingYPos + (i * stripeHeight), topStripeWidth, stripeHeight);
      		
      		// Alternates red and white paint for stripe
          	if (i % 2 == 0) {
          		g2.setPaint(Color.RED);
          		g2.fill(stripe);
          	}
      		g2.setPaint(Color.BLACK);
          	g2.draw(stripe);
      	}
      	else { // Bottom half
      		Rectangle2D stripe = new Rectangle2D.Double(flagStartingXPos, flagStartingYPos + (i * stripeHeight), bottomStripeWidth, stripeHeight);
      		
      		// Alternates red and white paint for stripe
      		if (i % 2 == 0) {
      			g2.setPaint(Color.RED);
      			g2.fill(stripe);
      		}
      		g2.setPaint(Color.BLACK);
      		g2.draw(stripe);
      	}
      }
	}
	
	
	/**
	 * Draws the 50 stars.
	 * Path2D is used to draw polygons with Double-value coordinates.
	 * The variables vertex1X etc. were initialized at the start of the program,
	 * and are the coordinates for the very first star.
	 * The coordinates of every other star is created based off of the coordinates of the first star by
	 * adding a value to them through each iteration.
	 * @param g2
	 */
	public void drawStars(Graphics2D g2) {
		Path2D star = new Path2D.Double();
		
      // Loops through the 11 columns of stars on the flag
      for (int column = 1; column <= 11; column++) {
      	
      	// Checks if column is even or odd
      	if (columnIsOdd(column)) { // 5 stars in odd columns
      		
      		// Loops through the 5 rows in odd column
      		for (int row = 1; row <= 10; row += 2) {
      			
      			/** 2 arrays of x and y coordinates for each star.
      			 * The two arrays contain coordinates vertex1X, vertex1Y etc., which are the coordinates for the first star.
      			 * A value is added to the coordinates every iteration after a star is drawn
      			 * so the star is shifted over and the next star can be drawn.
      			 */
      			double[] xCoords = {vertex1X + (column * starXGap), vertex2X + (column * starXGap), vertex3X + (column * starXGap), vertex4X + (column * starXGap), vertex5X + (column * starXGap), vertex6X + (column * starXGap), vertex7X + (column * starXGap), vertex8X + (column * starXGap), vertex9X + (column * starXGap), vertex10X + (column * starXGap)};
      			double[] yCoords = {vertex1Y + (row * starYGap), vertex2Y + (row * starYGap), vertex3Y + (row * starYGap), vertex4Y + (row * starYGap), vertex5Y + (row * starYGap), vertex6Y + (row * starYGap), vertex7Y + (row * starYGap), vertex8Y + (row * starYGap), vertex9Y + (row * starYGap), vertex10Y + (row * starYGap)};
      			// Adds every x and y coordinate to the polygon path for each star
      			star.moveTo(xCoords[0], yCoords[0]);
      			for (int i = 1; i < xCoords.length; i++) {
      				star.lineTo(xCoords[i], yCoords[i]);
      			}
      			star.closePath();
      			g2.setPaint(Color.BLACK);
      			g2.draw(star);
      			g2.setPaint(Color.WHITE);
      			g2.fill(star);
      		}
      	}
      	else { // 4 stars in even columns
      		
      		// Loops through the 4 rows in even column
      		for (int row = 2; row <= 9; row += 2) {
      			double[] xCoords = {vertex1X + (column * starXGap), vertex2X + (column * starXGap), vertex3X + (column * starXGap), vertex4X + (column * starXGap), vertex5X + (column * starXGap), vertex6X + (column * starXGap), vertex7X + (column * starXGap), vertex8X + (column * starXGap), vertex9X + (column * starXGap), vertex10X + (column * starXGap)};
      			double[] yCoords = {vertex1Y + (row * starYGap), vertex2Y + (row * starYGap), vertex3Y + (row * starYGap), vertex4Y + (row * starYGap), vertex5Y + (row * starYGap), vertex6Y + (row * starYGap), vertex7Y + (row * starYGap), vertex8Y + (row * starYGap), vertex9Y + (row * starYGap), vertex10Y + (row * starYGap)};
      			star.moveTo(xCoords[0], yCoords[0]);
      			for (int i = 1; i < xCoords.length; i++) {
      				star.lineTo(xCoords[i], yCoords[i]);
      			}
      			star.closePath();
      			g2.setPaint(Color.BLACK);
      			g2.draw(star);
      			g2.setPaint(Color.WHITE);
      			g2.fill(star);
      		}
      	}
      }
	}
	
	
	/**
	 * Checks if column is odd
	 * @param column
	 * @return boolean
	 */
		public boolean columnIsOdd(int column) {
			if (column % 2 != 0) {
				return true;
			}
			else {
				return false;
			}
		}
}
