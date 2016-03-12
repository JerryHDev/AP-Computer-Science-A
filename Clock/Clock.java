import javax.swing.JFrame;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Timer;


public class Clock extends JFrame {
	
	// Window size
	private int windowWidth = 600;
	private int windowHeight = 600;
	
	// Clock center position
	private int clockX = 400;
	private int clockY = 400;
	
	// Clock size
	private int clockRadius = 150;
	
	// Clock minute hand length
	private int minuteHandLength = clockRadius - 20;
	
	// Clock hour hand length
	private int hourHandLength = clockRadius - 50;
	
	// Clock second hand length
	private int secondHandLength = minuteHandLength;
	
	int time = 0;
	
	public Clock() {
		init();
	}
	
	public void init() {
		setSize(windowWidth,windowHeight);
		setBackground(Color.WHITE);
		repaint();
	}
	
	
	/** Paint method */
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("MY CLOCK", windowWidth/2, clockY - clockRadius - 50);
		
		drawClockOutline(g2);
		drawSecondHand(g2, time);
		drawMinuteHand(g2, time);
		drawHourHand(g2, time);
		try {
			Thread.sleep(1000);
			time++;
			g2.setColor(Color.BLACK);
			drawSecondHand(g2, time);
			System.out.println("Time: " + time);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		repaint();
	}
	
	
	public void drawClockOutline(Graphics2D g2) {
		g2.drawOval(clockX - clockRadius, clockY - clockRadius, clockRadius * 2, clockRadius * 2);
	}
	
	
	public void drawSecondHand(Graphics2D g2, int seconds) {
		
		int elapsedSeconds = seconds;
		
		double angleDegrees = 6 * elapsedSeconds;
		double angleRadians = (angleDegrees / 180) * Math.PI;
		
		double changeX = Math.sin(angleRadians) * secondHandLength;
		double changeY = Math.cos(angleRadians) * secondHandLength;
		Shape a = new Line2D.Double(clockX, clockY, clockX + changeX, clockY - changeY);
		g2.setColor(Color.RED);
		g2.draw(a);
	}
	
	public void drawMinuteHand(Graphics2D g2, int seconds) {
		
		double elapsedSeconds = seconds;
		
		double angleDegrees = (elapsedSeconds / 60) * 6;
		double angleRadians = (angleDegrees / 180) * Math.PI;
		
		double changeX = Math.sin(angleRadians) * minuteHandLength;
		double changeY = Math.cos(angleRadians) * minuteHandLength;
		Shape a = new Line2D.Double(clockX, clockY, clockX + changeX, clockY - changeY);
		g2.setColor(Color.BLACK);
		g2.draw(a);
	}
	
	public void drawHourHand(Graphics2D g2, int seconds) {
		int destX = clockX + hourHandLength;
		int destY = clockY;
		g2.setColor(Color.BLACK);
		g2.drawLine(clockX, clockY, destX, destY);
	}
}
