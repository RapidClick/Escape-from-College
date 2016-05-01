package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MiniMap extends JPanel {
	
	private Color[][] colors;
	private int size;
	private int cursorSize = 2;
	private int posX, posY;
	
	public MiniMap(int setSize) {
		size = setSize;
		colors = new Color[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				colors[row][col] = Color.LIGHT_GRAY;
			}
		}
		posX = size/2;
		posY = size/2;
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
	
	public  void setCursor(int dX, int dY) {
		for (int i = posX; i < posX + cursorSize; i++) {
			for (int j = posY; j < posY + cursorSize; j++) {
				setColor(i, j, Color.LIGHT_GRAY);
			}
		}
		for (int i = posX + dX; i < posX + cursorSize + dX; i++) {
			for (int j = posY + dY; j < posY + cursorSize + dY; j++) {
				setColor(i, j, Color.RED);
			}
		}
		repaint();
	}
	
	public int getCursorSize() {
		return cursorSize;
	}
	
	public int getMapSize() {
		return size;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int dX) {
		posX+=dX;
	}
	
	public void setPosY(int dY) {
		posY+=dY;
	}
	
	public void resetCursor() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				setColor(i, j, Color.LIGHT_GRAY);
			}
		}
		for (int row = 60; row < 70; row++) {
			for (int col = 60; col < 90; col++) {
				setColor(row, col, Color.GRAY);
			}
		}
		posX = size/2;
		posY = size/2;
		for (int i = posX; i < posX + cursorSize; i++) {
			for (int j = posY; j < posY + cursorSize; j++) {
				setColor(i, j, Color.RED);
			}
		}
		repaint();
	}
	

}
