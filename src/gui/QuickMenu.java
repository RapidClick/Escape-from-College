package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JDesktopPane;

public class QuickMenu extends JDesktopPane {
	
	public QuickMenu() {
		super();
		setLayout(new GridBagLayout());
		setSize(150, 350);
		setPreferredSize(getSize());
		
		setBackground(Color.BLACK);
		
	}
	
}
