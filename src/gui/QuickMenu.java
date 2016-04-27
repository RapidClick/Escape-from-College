package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		
		cursor = new CursorBar(5, Color.RED, 5);
		cursor.setCursorPosition(2);
		
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
		optionsPanel.add(save, optionC);
		optionC.gridy = 1;
		optionsPanel.add(load, optionC);
		optionC.gridy = 2;
		optionsPanel.add(returnMain, optionC);
		optionC.gridy = 3;
		optionsPanel.add(quit, optionC);
	}
	
	public CursorBar getCursorBar() {
		return cursor;
	}
	
}
