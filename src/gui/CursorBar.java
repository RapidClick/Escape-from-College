package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CursorBar extends JPanel {
	
	private final int SQUARE_SIZE = 10;  // pixel size of each square
	private Color[][] colors;
	private int scaleH;
	private int scaleW;
	private Color cursorColor;
	private int cursorPosition;
	private int numOptions;
	
	public CursorBar(int setSize, Color setCursorColor, int setNumOptions) {
		scaleW = 1;
		scaleH = setSize;
		cursorColor = setCursorColor;
		colors = new Color[scaleH][scaleW];
		setSize(scaleW * SQUARE_SIZE, scaleH * SQUARE_SIZE);
		for (int i = 0; i < scaleH; i++)
			for (int j = 0; j < scaleW; j++)
				colors[i][j] = Color.LIGHT_GRAY; // should match the background color of the quick menu
		numOptions = setNumOptions;
		cursorPosition = 1;
		setCursorPosition(cursorPosition);
	}
	
	public void setCursorPosition(int pos) {
		if (pos > numOptions) {
			setCursorPosition(1);
		} else {
			cursorPosition = pos;
			colors[pos][0] = cursorColor;
			this.repaint();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
		for (int i = 0; i < scaleH; i ++)
			for (int j = 0; j < scaleW; j++) {
				g.setColor(colors[i][j]); // divide j by 2 causes pink to go across but gray covers it
				g.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, 
						SQUARE_SIZE, SQUARE_SIZE);
			}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension((scaleW * SQUARE_SIZE + 1), (scaleH* SQUARE_SIZE));
	}
	
	public int getPosition() {
		return cursorPosition;
	}
	
	

}
