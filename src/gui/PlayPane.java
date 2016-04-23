package gui;

import java.awt.*;
import javax.swing.*;

public class PlayPane extends JDesktopPane {
	
	private JPanel statPanel;
	private JTextArea scrollText;
	private JTextArea writeText;
	private JPanel invtPanel;
	
	public PlayPane() {
		setLayout(new GridBagLayout());
		statPanel = new JPanel();
		scrollText = new JTextArea();
		writeText = new JTextArea();
		invtPanel = new JPanel();
	}

}
