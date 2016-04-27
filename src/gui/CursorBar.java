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
	private int size;
	
	public CursorBar(int setNumOptions, Color setCursorColor) {
		size = setNumOptions*(300/setNumOptions);
		scaleW = 1;
		scaleH = size;
		cursorColor = setCursorColor;
		colors = new Color[scaleH][scaleW];
		setSize(scaleW * SQUARE_SIZE, scaleH * SQUARE_SIZE);
		for (int i = 0; i < scaleH; i++)
			for (int j = 0; j < scaleW; j++)
				colors[i][j] = Color.BLACK;
		numOptions = setNumOptions * 2;
		cursorPosition = 0;
		setCursorPosition(cursorPosition);
	}
	
	public void setCursorPosition(int pos) {
		if (pos >= numOptions) {
			setCursorPosition(0);
		} else if (pos < 0) {
			setCursorPosition(numOptions - 2);
		} else {
			colors[cursorPosition][0] = Color.BLACK;
			colors[cursorPosition + 1][0] = Color.BLACK;
			cursorPosition = pos;
			colors[pos][0] = cursorColor;
			colors[pos + 1][0] = cursorColor;
			this.repaint();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
		for (int i = 0; i < scaleH; i ++)
			for (int j = 0; j < scaleW; j++) {
				g.setColor(colors[i][j]);
				g.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, 
						SQUARE_SIZE, SQUARE_SIZE);
			}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension((scaleW * SQUARE_SIZE + 1), 300);
	}
	
	public int getPosition() {
		return cursorPosition;
	}
	
	

}
