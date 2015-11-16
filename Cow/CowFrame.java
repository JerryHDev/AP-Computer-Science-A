// Jerry Huang
// AP CS
// Cow Project

import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
	
	// Initialize constants
	private final int windowWidth = 850; // graphics window width
	private final int windowHeight = 650; // graphics window height
	private final int grassSkyBreakPoint = 400; // y coordinate where sky background and grass background coincide
	private final Color topSkyColor = new Color(133, 212, 253); // blue color for top of gradient sky
	private final Color bottomSkyColor = new Color(230, 254, 255); // blue color for bottom of gradient sky
	private final int MILKXPOS = 304;
	private final int MILKYPOS = 442;
	private final int MILKWIDTH = 14;
	private final int MILKHEIGHT = 24;
	private final int BODYXPOS = 225;
	private final int BODYYPOS = 270;
	private final int BODYWIDTH = 350;
	private final int BODYHEIGHT = 180;
	private final int FRONTLEGXPOS = 470;
	private final int FRONTLEGYPOS = 410;
	private final int HINDLEGXPOS = 270;
	private final int HINDLEGYPOS = 410;
	private final int LEGWIDTH = 38;
	private final int LEGHEIGHT = 88;
	private final int HEADXPOS = 470;
	private final int HEADYPOS = 220;
	private final int HEADWIDTH = 150;
	private final int HEADHEIGHT = 150;
	private final int LEFTEARXPOS = 455;
	private final int RIGHTEARXPOS = 595;
	private final int LEFTEARYPOS = 210;
	private final int RIGHTEARYPOS = LEFTEARYPOS;
	private final int EARWIDTH = 40;
	private final int EARHEIGHT = 80;
	private final int LEFTEYEXPOS = 505;
	private final int RIGHTEYEXPOS = 562;
	private final int LEFTEYEYPOS = 280;
	private final int RIGHTEYEYPOS = LEFTEYEYPOS;
	private final int EYEWIDTH = 23;
	private final int EYEHEIGHT = 23;
	private final int LEFTPUPILXPOS = 515;
	private final int RIGHTPUPILXPOS = 572;
	private final int LEFTPUPILYPOS = 285;
	private final int RIGHTPUPILYPOS = LEFTPUPILYPOS;
	private final int PUPILWIDTH = 8;
	private final int PUPILHEIGHT = 8;
	private final int MOUTHXPOS = 505;
	private final int MOUTHYPOS = 314;
	private final int MOUTHWIDTH = 80;
	private final int MOUTHHEIGHT = 56;
	
	public CowFrame () {
		init();
	}
	public void init() {
		setSize(windowWidth,windowHeight);
		setBackground(Color.WHITE);
		repaint();
	}
	
	public void paint(Graphics g) {
		
		/* Creates gradient sky */
		GradientPaint skyColor = new GradientPaint(0,0, topSkyColor, 0, grassSkyBreakPoint, bottomSkyColor); // creates blue gradient color variable
		Graphics2D g2d = (Graphics2D) g; // initializes a variable of type Graphics2D
		g2d.setPaint(skyColor); // sets paint to gradient blue color
		g2d.fillRect(0, 0, windowWidth, grassSkyBreakPoint); // paints gradient blue color
		
		/* Random cloud generator */
		g.setColor(Color.WHITE);
		int cloudXPos;
		int cloudYPos;
		int cloudWidth = 100;
		int cloudHeight = 35;
		int cloudArcLength = 40;
		for (int i = 0; i < 5; i++) {
			cloudXPos = 25 + (int)(Math.random() * 675); // picks random cloud x position between 25 and 700
			cloudYPos = 75 + (int)(Math.random() * 66); // picks random cloud y position between 75 and 141 
			g.fillRoundRect(cloudXPos, cloudYPos, cloudWidth, cloudHeight, cloudArcLength, cloudArcLength);
			g.fillOval(cloudXPos + 33, cloudYPos - 25, 52, 52);
			g.fillOval(cloudXPos + 15, cloudYPos - 17, 30, 30);
		}
		
		/* Grass */
		g.setColor(Color.GREEN);
		g.fillRect(0, grassSkyBreakPoint, windowWidth, windowHeight - grassSkyBreakPoint);
		
		/* Legs, drawn before body to create 3D effect */
		g.setColor(Color.WHITE);
		g.fillOval(HINDLEGXPOS + 30, HINDLEGYPOS - 8, LEGWIDTH, LEGHEIGHT);
		g.fillOval(FRONTLEGXPOS + 30, FRONTLEGYPOS - 8, LEGWIDTH, LEGHEIGHT);
		g.setColor(Color.BLACK);
		g.drawOval(HINDLEGXPOS + 30, HINDLEGYPOS - 8, LEGWIDTH, LEGHEIGHT);
		g.drawOval((HINDLEGXPOS + 30) + 1, (HINDLEGYPOS - 8) + 1, LEGWIDTH - 2, LEGHEIGHT - 2); // makes line thicker
		g.drawOval((HINDLEGXPOS + 30) + 2, (HINDLEGYPOS - 8) + 2, LEGWIDTH - 4, LEGHEIGHT - 4); // makes line thicker
		g.drawOval(FRONTLEGXPOS + 30, FRONTLEGYPOS - 8, LEGWIDTH, LEGHEIGHT);
		g.drawOval((FRONTLEGXPOS + 30) + 1, (FRONTLEGYPOS - 8) + 1, LEGWIDTH - 2, LEGHEIGHT - 2); // makes line thicker
		g.drawOval((FRONTLEGXPOS + 30) + 2, (FRONTLEGYPOS - 8) + 2, LEGWIDTH - 4, LEGHEIGHT - 4); // makes line thicker
		
		/* Udders */
		g.setColor(Color.PINK);
		g.fillOval(MILKXPOS, MILKYPOS, MILKWIDTH, MILKHEIGHT);
		g.fillOval(MILKXPOS + 12, MILKYPOS + 4, MILKWIDTH, MILKHEIGHT);
		g.fillOval(MILKXPOS + 24, MILKYPOS, MILKWIDTH, MILKHEIGHT);
		
		/* Body */
		g.setColor(Color.WHITE);
		g.fillRoundRect(BODYXPOS, BODYYPOS, BODYWIDTH, BODYHEIGHT, 200, 200);
		g.setColor(Color.BLACK);
		g.drawRoundRect(BODYXPOS, BODYYPOS, BODYWIDTH, BODYHEIGHT, 200, 200);
		g.drawRoundRect(BODYXPOS + 1, BODYYPOS + 1, BODYWIDTH - 2, BODYHEIGHT - 2, 198, 198); // makes line thicker
		g.drawRoundRect(BODYXPOS + 2, BODYYPOS + 2, BODYWIDTH - 4, BODYHEIGHT - 4, 196, 196); // makes line thicker
		
		/* Spots */
		g.setColor(Color.BLACK);
		g.fillOval(BODYXPOS + 140, BODYYPOS + 20, 50, 50);
		g.fillOval(BODYXPOS + 200, BODYYPOS + 80, 50, 50);
		g.fillOval(BODYXPOS + 30, BODYYPOS + 70, 50, 50);
		g.fillOval(BODYXPOS + 100, BODYYPOS + 100, 50, 50);
		
		/* Legs */
		g.setColor(Color.WHITE);
		g.fillOval(HINDLEGXPOS, HINDLEGYPOS, LEGWIDTH, LEGHEIGHT);
		g.fillOval(FRONTLEGXPOS, FRONTLEGYPOS, LEGWIDTH, LEGHEIGHT);
		g.setColor(Color.BLACK);
		g.drawOval(HINDLEGXPOS, HINDLEGYPOS, LEGWIDTH, LEGHEIGHT);
		g.drawOval(HINDLEGXPOS + 1, HINDLEGYPOS + 1, LEGWIDTH - 2, LEGHEIGHT - 2); // makes line thicker
		g.drawOval(HINDLEGXPOS + 2, HINDLEGYPOS + 2, LEGWIDTH - 4, LEGHEIGHT - 4); // makes line thicker
		g.drawOval(FRONTLEGXPOS, FRONTLEGYPOS, LEGWIDTH, LEGHEIGHT);
		g.drawOval(FRONTLEGXPOS + 1, FRONTLEGYPOS + 1, LEGWIDTH - 2, LEGHEIGHT - 2); // makes line thicker
		g.drawOval(FRONTLEGXPOS + 2, FRONTLEGYPOS + 2, LEGWIDTH - 4, LEGHEIGHT - 4); // makes line thicker
		/*
		 * White circles cover part of the legs to create 3D effect
		 */
		g.setColor(Color.WHITE);
		g.fillOval(FRONTLEGXPOS - 10, FRONTLEGYPOS - 15, LEGWIDTH + 5, LEGWIDTH + 5);
		g.fillOval(HINDLEGXPOS - 8, HINDLEGYPOS - 16, LEGWIDTH + 5, LEGWIDTH + 5);
		
		/* Head */
		g.setColor(Color.WHITE);
		g.fillOval(HEADXPOS, HEADYPOS, HEADWIDTH, HEADHEIGHT);
		g.setColor(Color.BLACK);
		g.drawOval(HEADXPOS, HEADYPOS, HEADWIDTH, HEADHEIGHT);
		g.drawOval(HEADXPOS + 1, HEADYPOS + 1, HEADWIDTH - 2, HEADHEIGHT - 2); // makes line thicker
		g.drawOval(HEADXPOS + 2, HEADYPOS + 2, HEADWIDTH - 4, HEADHEIGHT - 4); // makes line thicker
		
		/* Ears */
		g.setColor(Color.BLACK);
		g.fillOval(LEFTEARXPOS, LEFTEARYPOS, EARWIDTH, EARHEIGHT);
		g.fillOval(RIGHTEARXPOS, RIGHTEARYPOS, EARWIDTH, EARHEIGHT);
		
		/* Eyes */
		g.setColor(Color.BLACK);
		g.fillOval(LEFTEYEXPOS, LEFTEYEYPOS, EYEWIDTH, EYEHEIGHT);
		g.fillOval(RIGHTEYEXPOS, RIGHTEYEYPOS, EYEWIDTH, EYEHEIGHT);
		
		/* Pupils */
		g.setColor(Color.WHITE);
		g.fillOval(LEFTPUPILXPOS, LEFTPUPILYPOS, PUPILWIDTH, PUPILHEIGHT);
		g.fillOval(RIGHTPUPILXPOS, RIGHTPUPILYPOS, PUPILWIDTH, PUPILHEIGHT);
		
		/* Mouth */
		g.setColor(Color.PINK);
		g.fillOval(MOUTHXPOS, MOUTHYPOS, MOUTHWIDTH, MOUTHHEIGHT);
		g.setColor(Color.BLACK);
		g.drawOval(MOUTHXPOS, MOUTHYPOS, MOUTHWIDTH, MOUTHHEIGHT);
		g.drawOval(MOUTHXPOS + 1, MOUTHYPOS + 1, MOUTHWIDTH - 2, MOUTHHEIGHT - 2); // makes line thicker
		g.drawLine(520, 340, 530, 345);
		g.drawLine(570, 340, 560, 345);
	}
}