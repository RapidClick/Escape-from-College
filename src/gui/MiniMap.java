package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MiniMap extends JPanel {
	
	private Color[][] colors;
	private int size;
	private int cursorSize = 2;
	
	public MiniMap(int setSize) {
		size = setSize;
		colors = new Color[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				colors[row][col] = Color.LIGHT_GRAY;
			}
		}
	}
	
	public void setColor(int row, int col, Color color) {
		colors[row][col] = color;
		this.repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
		for (int i = 0; i < size; i ++)
			for (int j = 0; j < size; j++) {
				g.setColor(colors[i][j]);
				g.fillRect(j * cursorSize, i * cursorSize, cursorSize, cursorSize);
			}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(size, size);
	}
	
	public int getCursorSize() {
		return cursorSize;
	}
	
	public int getMapSize() {
		return size;
	}
	

}
