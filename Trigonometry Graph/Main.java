

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;


/*
 * Coded by Jerry Huang
 * 
 * Trigonometry Grapher
 * 
 * Graphs trig functions using Graphics and Graphics2D
 */
public class Main extends JFrame {
	
	public Main() {
		add (new TrigPanel());
	}
	
	public static void main(String[] args) {
		
		Main frame = new Main();
		frame.setTitle("Trig Grapher");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class TrigPanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		Line2D xAxis = new Line2D.Double(0, getHeight()/2, getWidth(), getHeight()/2);
		g2d.draw(xAxis);
		
		Line2D yAxis = new Line2D.Double(getWidth()/2, 0, getWidth()/2, getHeight());
		g2d.draw(yAxis);
		
		Path2D path = new Path2D.Double();
		
		
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		
		path.moveTo(centerX, centerY);
		
		// How many periods of the sin graph you want
		double period = 2 * Math.PI;
		
		// Aka the amplitude of the trig graph
		double yMax = 2;
		
		double i = -period;
		
		// Loops through the domain [-period, period]
		while (i <= period) {
			
			i += 0.0001;
			
			double dy = Math.sin(i); // Type of graph you want it to be (sin, cos, tan, etc.)
			
			path.lineTo(centerX + (i*(getWidth()/2) / (period)), centerY - (dy*(getHeight()/2) / yMax));
		}
		
		path.closePath();
		g2d.draw(path);
	}
}
