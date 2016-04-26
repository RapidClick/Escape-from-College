package gui;

import java.awt.*;

import javax.swing.*;

public class PlayPane extends JDesktopPane {
	
	private JPanel statPanel;
	private JPanel textPanel;
	private JTextArea scrollText;
	private JTextArea writeText;
	private JPanel invtPanel;
	private JPanel enterPanel;
	private StatBox healthBox;
	
	public PlayPane() {
		super();
		setLayout(new GridBagLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setSize(1100, 628);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		
		statPanel = new JPanel();
		statPanel.setLayout(new GridBagLayout());
		statPanel.setSize(285, 628);  // the width of the standard StatBox, height of the frame
		statPanel.setPreferredSize(statPanel.getSize());
		
		healthBox = new StatBox("Health", Color.LIGHT_GRAY, Color.PINK);
		
		
		textPanel = new JPanel();
		textPanel.setLayout(new GridBagLayout());
		
		scrollText = new JTextArea();
		scrollText.setLineWrap(true);
		JScrollPane upperScrollPane = new JScrollPane(scrollText);
		upperScrollPane.setPreferredSize(new Dimension(525, 1));
		scrollText.setWrapStyleWord(true);
		scrollText.setEditable(false);
		
		writeText = new JTextArea();
		writeText.setLineWrap(true);
		JScrollPane lowerScrollPane = new JScrollPane(writeText);
		lowerScrollPane.setPreferredSize(new Dimension(525, 300));
		writeText.setWrapStyleWord(true);
		
		
		invtPanel = new JPanel();
		invtPanel.setSize(10, 540);
		invtPanel.setPreferredSize(invtPanel.getSize());
		invtPanel.setBackground(Color.BLACK);    //TODO remove after testing
		
		enterPanel = new JPanel();
		
		GridBagConstraints playPaneC = new GridBagConstraints();
		GridBagConstraints statPanelC = new GridBagConstraints();
		GridBagConstraints textPanelC = new GridBagConstraints();
		
		playPaneC.gridx = 0;
		playPaneC.gridy = 0;
		playPaneC.weightx = 0;
		playPaneC.weighty = 1;
		playPaneC.fill = GridBagConstraints.HORIZONTAL;
		playPaneC.anchor = GridBagConstraints.NORTH;
		playPaneC.gridheight = 2;
		add(statPanel, playPaneC);
		
		statPanelC.gridy = 0;
		statPanelC.anchor = GridBagConstraints.NORTH;
		statPanelC.weighty = 1;
		statPanel.add(healthBox, statPanelC);
		
		playPaneC.gridx = 1;
		playPaneC.gridy = 0;
		playPaneC.gridheight = 2;
		playPaneC.weighty = 1;
		playPaneC.weightx = 1;
		playPaneC.fill = GridBagConstraints.VERTICAL;
		playPaneC.anchor = GridBagConstraints.NORTHWEST;
		add(textPanel, playPaneC);
		
		textPanelC.gridy = 0;
		textPanelC.gridx = 0;
		textPanelC.weighty = 1;
		textPanelC.weightx = 1;
		textPanelC.fill = GridBagConstraints.BOTH;
		textPanelC.anchor = GridBagConstraints.NORTH;
		textPanel.add(upperScrollPane, textPanelC);
		
		textPanelC.gridy = 1;
		textPanelC.weighty = 0;
		textPanel.add(lowerScrollPane, textPanelC);
		
		playPaneC.gridx = 2;
		playPaneC.gridy = 0;
		playPaneC.weighty = 1;
		//add(invtPanel, playPaneC);
		
		playPaneC.gridy = 1;
		playPaneC.weighty = 0;
		//add(enterPanel, playPaneC);
		
		
		
	}
	
	public JTextArea getWriteText() {
		return writeText;
	}
	
	public String getWriteTextString() {
		return writeText.getText();
	}

}
