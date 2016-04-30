package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class RunMiniMap {
	
	private static int posX;
	private static int posY;
	private static MiniMap mini;
	private static JFrame frame;
	
	public static void main(String[] args) {
		
		frame = new JFrame("Mini Map");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setPreferredSize(frame.getSize());
		frame.setMinimumSize(frame.getSize());
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		c.weightx = 1;
		
		mini = new MiniMap(100);
		frame.add(mini, c);
		
		posX = mini.getMapSize()/2;
		posY = mini.getMapSize()/2;
		
		for (int row = 60; row < 70; row++) {
			for (int col = 60; col < 90; col++) {
				mini.setColor(row, col, Color.GRAY);
			}
		}
		
		setCursor(0,0);
		
		mini.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (posX == 0) {
					} else {
						setCursor(-1,0);
						posX-=1;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (posX == 98) {
					} else {
						setCursor(1,0);
						posX+=1;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (posY == 98) {
					} else {
						setCursor(0,1);
						posY+=1;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (posY == 0) {
					} else {
						setCursor(0,-1);
						posY-=1;
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println(posY);
				}
				
			}
		});
		
		frame.setContentPane(mini);
		
		frame.setVisible(true);
		mini.requestFocus();
	}
	
	public static void setCursor(int dX, int dY) {
		for (int i = posX; i < posX + mini.getCursorSize(); i++) {
			for (int j = posY; j < posY + mini.getCursorSize(); j++) {
				mini.setColor(i, j, Color.LIGHT_GRAY);
			}
		}
		
		for (int i = posX + dX; i < posX + mini.getCursorSize() + dX; i++) {
			for (int j = posY + dY; j < posY + mini.getCursorSize() + dY; j++) {
				mini.setColor(i, j, Color.RED);
			}
		}
		frame.repaint();
	}

}
