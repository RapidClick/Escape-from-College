package gui;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MemoryScreen extends JPanel {
	
	public MemoryScreen(String title) {
		super();
		setSize(500, 300);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		setBackground(Color.GRAY);
		setEnabled(false);
		setLayout(new GridBagLayout());
	}
	
	

}
