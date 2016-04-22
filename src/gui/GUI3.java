package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.*;

public class GUI3 {
	
	public GUI3() {
		JFrame frame = new JFrame("Escape From College");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(925, 600);
		frame.setMinimumSize(frame.getSize());
		
		JDesktopPane mainMenu = new JDesktopPane();
		mainMenu.setLayout(new GridBagLayout());
		JDesktopPane saveScreen = new JDesktopPane();
		saveScreen.setSize(100, 100);
		saveScreen.setMaximumSize(saveScreen.getSize());
		saveScreen.setBackground(Color.BLUE);
		saveScreen.setLayout(new GridBagLayout());
		
		JDesktopPane playPane = new JDesktopPane();
		
		
		frame.setContentPane(mainMenu);
		mainMenu.setBackground(Color.BLACK);
		
		mainMenu.add(saveScreen);
		saveScreen.setVisible(false);
		
		JButton button = new JButton("close");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
 				if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
 					if (saveScreen.isVisible()) {
 						saveScreen.remove(button);
 						saveScreen.setVisible(false);
 					} else {
 						saveScreen.setSize(100, 100);
 						saveScreen.setMinimumSize(saveScreen.getSize());
 						saveScreen.add(button);
 						saveScreen.setVisible(true);
 						saveScreen.requestFocus();
 					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		
		saveScreen.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
 				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
 					System.out.println("Down");
 				}
 				if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
 					saveScreen.remove(button);
					saveScreen.setVisible(false);
					frame.requestFocus();
 				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		J
		
		frame.setVisible(true);
		
	}

}
