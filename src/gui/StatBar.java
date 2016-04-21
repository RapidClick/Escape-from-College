package gui;

import java.awt.*;

import javax.swing.*;

public class StatBar extends JPanel {
	
	private static final long serialVersionUID = 0L;
	private static int fullLength = 10; //10 by default
	private int currentStatLvl;							//to make slivers smaller - multiply setHealth by some
	private static final int MARGIN = 0;				//num and divide SquareSize in width by the same
	private static final int SQUARE_SIZE = 18;  // pixel size of each square
	private static int WIDTH = SQUARE_SIZE;
	private Color[][] colors;
	private int scaleH;
	private int scaleW;
	private Color barColor;
	
	/**
	 * No arg constructor that creates a stat bar.
	 * length is left at 10 by default, height is left at 1 by default
	 */
	public StatBar(Color barColorIn) {
		barColor = barColorIn;
		scaleH = 1;
		scaleW = 1 * fullLength;
		currentStatLvl = fullLength;
		int overallSizeH = scaleH + 2 * MARGIN;
		int overallSizeW = scaleW + 2 * MARGIN;
		colors = new Color[overallSizeH][overallSizeW];
		for (int i = 0; i < overallSizeH; i++)
			for (int j = 0; j < overallSizeW; j++)
				colors[i][j] = Color.lightGray;			// is this messing with background??
		setSize((scaleW + 2 * MARGIN) * WIDTH, 
				((scaleH) + 2 * MARGIN) * SQUARE_SIZE);
		for (int i = 0; i < fullLength; i++) {
			setColor(0, i, barColor);
		}
	}
	
	/**
	 * Constructor that takes a parameter as a multiplier for the full length of the stat.
	 * this changes the "full length" stat, and reduces the rectangle width stat.
	 * @param multiplier number to be multiplied by 10 to set full length stat
	 */
	public StatBar(Color barColorIn, int multiplier) {
		barColor = barColorIn;
		fullLength = fullLength * multiplier;
		WIDTH = SQUARE_SIZE / multiplier;
		scaleH = 1;
		scaleW = 1 * fullLength;
		currentStatLvl = fullLength;
		int overallSizeH = scaleH + 2 * MARGIN;
		int overallSizeW = scaleW + 2 * MARGIN;
		colors = new Color[overallSizeH][overallSizeW];
		for (int i = 0; i < overallSizeH; i++)
			for (int j = 0; j < overallSizeW; j++)
				colors[i][j] = Color.lightGray;			// is this messing with background??
		setSize((scaleW + 2 * MARGIN) * WIDTH, 
				((scaleH) + 2 * MARGIN) * SQUARE_SIZE);	
		for (int i = 0; i < fullLength; i++) {
			setColor(0, i, barColor);
		}
	}
	
	public void setColor(int row, int col, Color color) {
		colors[row][col] = color;
		this.repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
		for (int i = 0; i < scaleH + 2 * MARGIN; i ++)
			for (int j = 0; j < (scaleW) + 2 * MARGIN; j++) {
				g.setColor(colors[i*2][j]); // divide j by 2 causes pink to go across but gray covers it
				g.fillRect(j * WIDTH, i * SQUARE_SIZE, 
						WIDTH, SQUARE_SIZE);
			}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension((scaleW + 2 * MARGIN) * WIDTH + 1, 
				((scaleH) + 2 * MARGIN) * SQUARE_SIZE);
	}
	
	public int getStatLvl() {
		return currentStatLvl;
	}
	
	public void setStatLvl(int newLvl) {
		if (newLvl > getFullLenght() || newLvl < 0) {
			System.out.println("Invalid stat level set");
		} else {
			currentStatLvl = newLvl;
			for (int i = 0; i < newLvl; i++) {
				setColor(0, i, barColor);
			}
			for (int i = fullLength - 1; i >= newLvl; i--) {
				setColor(0, i, Color.WHITE);
			}
		}
	}
	
	public int getFullLenght() {
		return fullLength;
	}
	
}
