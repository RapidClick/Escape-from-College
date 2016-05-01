package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class PlayPane extends JDesktopPane {
	
	private JPanel statPanel;
	private JPanel textPanel;
	private JTextArea scrollText;
	private JTextArea writeText;
	private JPanel invtPanel;
	private JPanel enterPanel;
	private StatBox healthBox;
	private MiniMap mini = new MiniMap(100);
	
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
		scrollText.setFocusable(false);
		
		writeText = new JTextArea();
		writeText.setLineWrap(true);
		JScrollPane lowerScrollPane = new JScrollPane(writeText);
		lowerScrollPane.setPreferredSize(new Dimension(525, 125));
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
		playPaneC.weightx = 1;
		playPaneC.fill = GridBagConstraints.BOTH;
		add(mini, playPaneC);
		
		playPaneC.gridy = 1;
		playPaneC.weighty = 0;
		add(enterPanel, playPaneC);
		
		writeText.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					scrollText.append("\n\n> " + writeText.getText());
					if (writeText.getText().equalsIgnoreCase("up")) {
						if (mini.getPosX() == 0 || mini.getPosY() >= 59 && mini.getPosY() <= 89 &&
								mini.getPosX() == 70) {
						} else {
							mini.setCursor(-1,0);
							mini.setPosX(-1);
						}
					}
					if (writeText.getText().equalsIgnoreCase("down")) {
						if (mini.getPosX() == 98 || mini.getPosY() >= 59 && mini.getPosY() <= 89 &&
								mini.getPosX() == 58) {
						} else {
							mini.setCursor(1,0);
							mini.setPosX(1);
						}
					}
					if (writeText.getText().equalsIgnoreCase("right")) {
						if (mini.getPosY() == 98 || mini.getPosX() <= 69 && mini.getPosX() >= 59 && 
								mini.getPosY() == 58) {
						} else {
							mini.setCursor(0,1);
							mini.setPosY(1);
						}
					}
					if (writeText.getText().equalsIgnoreCase("left")) {
						if (mini.getPosY() == 0 || mini.getPosX() >= 59 && mini.getPosX() <= 69 && 
								mini.getPosY() == 90) {
						} else {
							mini.setCursor(0,-1);
							mini.setPosY(-1);
						}
					}
					writeText.setText("");
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					writeText.setText("");
				}
			}
		});
		
	}
	
	public JTextArea getWriteText() {
		return writeText;
	}
	
	public String getWriteTextString() {
		return writeText.getText();
	}
	
	public JTextArea getScrollText() {
		return scrollText;
	}
	
	public MiniMap getMiniMap() {
		return mini;
	}

}
