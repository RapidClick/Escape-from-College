package escapeFromCollege;

import java.awt.*;
import javax.swing.*;

public class HealthBar extends JPanel {
	
	private static final int setHealth = 10;
	private int health = setHealth;
	private static final long serialVersionUID = 0L;	//to make slivers smaller - multiply setHealth by some
	private static final int MARGIN = 0;				//num and divide SquareSize in width by the same
	private static final int SQUARE_SIZE = 18;  // pixel size of each square
	private static final int WIDTH = SQUARE_SIZE;
	private Color[][] colors;
	private int scaleH;
	private int scaleW;
	private static final int maxHealth = setHealth;
	
	public HealthBar(int scale) {
		this.scaleH = scale;
		this.scaleW = scale * health;
		int overallSizeH = scaleH + 2 * MARGIN;
		int overallSizeW = scaleW + 2 * MARGIN;
		colors = new Color[overallSizeH][overallSizeW];
		for (int i = 0; i < overallSizeH; i++)
			for (int j = 0; j < overallSizeW; j++)
				colors[i][j] = Color.lightGray;
		setSize((scaleW + 2 * MARGIN) * WIDTH, 
				((scaleH) + 2 * MARGIN) * SQUARE_SIZE);	
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
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	
}