package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuickMenu extends JDesktopPane {
	
	CursorBar cursor;
	CursorBar cursorRight;
	
	public QuickMenu() {
		super();
		setLayout(new GridBagLayout());
		setSize(200, 350);
		setPreferredSize(getSize());
		
		setBackground(Color.LIGHT_GRAY);
		
		cursor = new CursorBar(5, Color.RED);
		cursor.setPreferredSize(cursor.getPreferredSize());
		cursorRight = new CursorBar(5, Color.RED);
		cursorRight.setPreferredSize(cursorRight.getPreferredSize());
		
		GridBagConstraints paneC = new GridBagConstraints();
		GridBagConstraints optionC = new GridBagConstraints();
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridBagLayout());
		optionsPanel.setSize(150, 300);
		optionsPanel.setPreferredSize(optionsPanel.getSize());
		
		paneC.gridy = 0;
		paneC.gridx = 0;
		paneC.fill = GridBagConstraints.VERTICAL;
		paneC.anchor = GridBagConstraints.WEST;
		add(cursor, paneC);
		paneC.gridx = 1;
		paneC.anchor = GridBagConstraints.EAST;
		add(optionsPanel, paneC);
		//paneC.gridx = 2;
		//add(cursorRight, paneC);
		
		JLabel resume = new JLabel("Resume");
		JLabel save = new JLabel("Save");
		JLabel load = new JLabel("Load");
		JLabel returnMain = new JLabel("Return to Main");
		JLabel quit = new JLabel("Quit");
		
		optionC.weighty = 1;
		optionC.anchor = GridBagConstraints.WEST;
		optionC.gridx = 0;
		optionC.gridy = 0;
		optionsPanel.add(resume, optionC);
		optionC.gridy = 1;
		optionsPanel.add(save, optionC);
		optionC.gridy = 2;
		optionsPanel.add(load, optionC);
		optionC.gridy = 3;
		optionsPanel.add(returnMain, optionC);
		optionC.gridy = 4;
		optionsPanel.add(quit, optionC);
		
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					cursor.setCursorPosition(cursor.getPosition() + 1);
					cursorRight.setCursorPosition(cursorRight.getPosition() + 1);
				}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					cursor.setCursorPosition(cursor.getPosition() - 1);
					cursorRight.setCursorPosition(cursorRight.getPosition() - 1);
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
	}
	
	public CursorBar getCursorBar() {
		return cursor;
	}
	
	public CursorBar getCursorBarRight() {
		return cursorRight;
	}
	
}
