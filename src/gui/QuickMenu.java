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
	
	public QuickMenu() {
		super();
		setLayout(new GridBagLayout());
		setSize(200, 350);
		setPreferredSize(getSize());
		
		setBackground(Color.LIGHT_GRAY);
		
		cursor = new CursorBar(4, Color.RED);
		cursor.setPreferredSize(cursor.getPreferredSize());
		
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
		
		JLabel save = new JLabel("Save");
		JLabel load = new JLabel("Load");
		JLabel returnMain = new JLabel("Return to Main");
		JLabel quit = new JLabel("Quit");
		
		optionC.gridx = 0;
		optionC.gridy = 0;
		optionC.anchor = GridBagConstraints.NORTH;
		optionsPanel.add(save, optionC);
		optionC.gridy = 1;
		optionC.anchor = GridBagConstraints.CENTER;
		optionsPanel.add(load, optionC);
		optionC.gridy = 2;
		optionC.anchor = GridBagConstraints.CENTER;
		optionsPanel.add(returnMain, optionC);
		optionC.gridy = 3;
		optionC.anchor = GridBagConstraints.SOUTH;
		optionsPanel.add(quit, optionC);
		
		/*optionsPanel.add(save);
		optionsPanel.add(load);
		optionsPanel.add(returnMain);
		optionsPanel.add(quit);*/
		
		save.setBounds(optionsPanel.getX(), optionsPanel.getHeight()/4, save.getWidth(), save.getHeight());
		load.setBounds((optionsPanel.getX()), (optionsPanel.getHeight()/4) * 2, 
				load.getWidth(), load.getHeight());
		returnMain.setBounds((optionsPanel.getX()), (optionsPanel.getHeight()/4) * 3, 
				returnMain.getWidth(), returnMain.getHeight());
		quit.setBounds((optionsPanel.getWidth()/4) * 4, (optionsPanel.getHeight()/4) * 4, 
				quit.getWidth(), quit.getHeight());
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_DOWN) {
					cursor.setCursorPosition(cursor.getPosition() + 2);
				}
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					cursor.setCursorPosition(cursor.getPosition() - 2);
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
	
}
