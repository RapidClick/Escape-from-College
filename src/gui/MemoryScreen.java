package gui;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GridBagLayout;
import java.awt.GraphicsDevice.WindowTranslucency.*;
import javax.swing.JPanel;

public class MemoryScreen extends JPanel {
	
	public MemoryScreen(String title) {
		super();
		setSize(500, 300);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		setBackground(Color.GRAY);
		try {
			
		} catch (UnsupportedOperationException e) {
			
		}
		setEnabled(false);
		setLayout(new GridBagLayout());
	}
	
	

}
