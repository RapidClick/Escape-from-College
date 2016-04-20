package escapeFromCollege;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

public class GUI {
	
	private int location = 1;
	private JFrame frame;
	private JFrame chooseFrame;
	private HealthBar health;
	private JTextArea scrollText;
	private JTextArea writeText;
	
	public GUI(File saveFile, GameMap map) {
		
		Dimension defaultDim = new Dimension(925, 600);
		
		frame = new JFrame("Basic Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(defaultDim);
		frame.setLayout(new GridBagLayout());
		
		chooseFrame = new JFrame("Basic Application");
		chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chooseFrame.setMinimumSize(defaultDim);
		chooseFrame.setLayout(new GridBagLayout());
		
		JMenuBar utilityMenuBar = new JMenuBar();
		frame.setJMenuBar(utilityMenuBar);
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		utilityMenuBar.add(fileMenu);
		utilityMenuBar.add(editMenu);
		
		JMenuItem saveOption = new JMenuItem("Save");
		JMenuItem openOption = new JMenuItem("Load");
		JMenuItem copyOption = new JMenuItem("Copy");
		JMenuItem cutOption = new JMenuItem("Cut");
		JMenuItem pasteOption = new JMenuItem("Paste");
		
		fileMenu.add(saveOption);
		fileMenu.add(openOption);
		
		editMenu.add(cutOption);
		editMenu.add(copyOption);
		editMenu.add(pasteOption);
		
		////////////////////////////////////////////////////////////
		JPanel splash = new JPanel();
		splash.setBackground(Color.BLACK);
		//TODO actually use this
		
		////////////////////////////////////////////////////////////
		JPanel statPanel = new JPanel();
		statPanel.setLayout(new GridBagLayout());
		//**********************************************************
		JPanel healthPanel = new JPanel();
		healthPanel.setLayout(new GridBagLayout());
		
		JTextField healthTitle = new JTextField();
		healthTitle.setBackground(Color.LIGHT_GRAY);
		healthTitle.setEditable(false);
		healthTitle.setText("Health");
		
		health = new HealthBar(1);
		for (int i = 0; i < health.getMaxHealth(); i++) {
			health.setColor(0, i, Color.PINK);
		}
		
		////////////////////////////////////////////////////////////
		JPanel textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new GridBagLayout());
		//**********************************************************
		scrollText = new JTextArea();
		scrollText.setLineWrap(true);
		JScrollPane upperScrollPane = new JScrollPane(scrollText);
		upperScrollPane.setPreferredSize(new Dimension(500, 200));
		scrollText.setWrapStyleWord(true);
		scrollText.setEditable(false);
		writeText = new JTextArea();
		writeText.setLineWrap(true);
		JScrollPane lowerScrollPane = new JScrollPane(writeText);
		lowerScrollPane.setPreferredSize(new Dimension(500, 100));
		writeText.setWrapStyleWord(true);
		
		////////////////////////////////////////////////////////////
		
		JPanel invtPanel = new JPanel();
		invtPanel.setLayout(new GridBagLayout());
		
		JPanel enterPanel = new JPanel();
		enterPanel.setLayout(new GridBagLayout());
		
		
		
		
		
		JButton hello = new JButton("Hello");
		JButton restore = new JButton("Restore");
		JButton jorah = new JButton("Jorah");
		JButton loseHealth = new JButton("Lose Health");
		JButton enterButton = new JButton("Enter");
		
		JButton continueButton = new JButton("Continue");
		JButton newGameButton = new JButton("New Game");
		JButton deleteButton = new JButton("Delete");
		JButton quitButton = new JButton("Quit");
		
		
		GridBagConstraints statPanelC = new GridBagConstraints();
		GridBagConstraints healthPanelC = new GridBagConstraints();
		GridBagConstraints iHealthPanelC = new GridBagConstraints();
		GridBagConstraints textPanelC = new GridBagConstraints();
		GridBagConstraints iTextPanelC = new GridBagConstraints();
		GridBagConstraints invtPanelC = new GridBagConstraints();
		GridBagConstraints iInvtPanelC = new GridBagConstraints();
		GridBagConstraints enterButtonC = new GridBagConstraints();
		GridBagConstraints chooseC = new GridBagConstraints();
		GridBagConstraints splashC = new GridBagConstraints();
		
		
		//////////////////////////////////////////////////////////////////
		statPanelC.gridx = 0;
		statPanelC.gridy = 0;
		statPanelC.weightx = 0;
		statPanelC.weighty = 1;
		statPanelC.anchor = GridBagConstraints.NORTH;
		statPanelC.fill = GridBagConstraints.VERTICAL;
		statPanel.setPreferredSize(new Dimension(250, 1));
		frame.add(statPanel, statPanelC);
		//****************************************************************
		healthPanelC.gridx = 0;
		healthPanelC.gridy = 0;
		healthPanelC.weightx = 1;
		healthPanelC.weighty = 1; //weighty = 1 should be applied to last stat bar
		healthPanelC.anchor = GridBagConstraints.NORTH;
		healthPanelC.fill = GridBagConstraints.HORIZONTAL;
		healthPanel.setPreferredSize(new Dimension(1, 38));
		healthPanel.setBackground(Color.LIGHT_GRAY);
		statPanel.add(healthPanel, healthPanelC);
		
		iHealthPanelC.weightx = 0;
		iHealthPanelC.weightx = 1;
		healthPanel.add(healthTitle, iHealthPanelC);
		
		iHealthPanelC.gridx = 1;
		health.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < health.getMaxHealth(); i++) {
			health.setColor(0, i, Color.PINK);
		}
		healthPanel.add(health, iHealthPanelC);
		
		////////////////////////////////////////////////////////////////////
		textPanelC.gridx = 1;
		textPanelC.gridy = 0;
		textPanelC.gridheight = 2;
		textPanelC.weighty = 1;
		textPanelC.weightx = .6;
		textPanelC.fill = GridBagConstraints.BOTH;
		textPanelC.anchor = GridBagConstraints.NORTHWEST;
		frame.add(textAreaPanel, textPanelC);
		//*****************************************************************
		iTextPanelC.gridx = 0;
		iTextPanelC.gridy = 0;
		iTextPanelC.weightx = 1;
		iTextPanelC.weighty = 1;
		iTextPanelC.fill = GridBagConstraints.BOTH;
		iTextPanelC.anchor = GridBagConstraints.NORTH;
		textAreaPanel.add(upperScrollPane, iTextPanelC);
		
		iTextPanelC.gridy = 1;
		iTextPanelC.weightx = 1;
		iTextPanelC.weighty = 0;
		iTextPanelC.anchor = GridBagConstraints.SOUTH;
		textAreaPanel.add(lowerScrollPane, iTextPanelC);
		
		////////////////////////////////////////////////////////////////////
		invtPanelC.gridx = 2;
		invtPanelC.gridy = 0;
		invtPanelC.weightx = 0.4;
		invtPanelC.anchor = GridBagConstraints.WEST;
		frame.add(invtPanel, invtPanelC);
		//******************************************************************
		iInvtPanelC.gridx = 0;
		iInvtPanelC.gridy = 0;
		iInvtPanelC.weighty = 1;
		iInvtPanelC.weightx = 0.2;
		invtPanel.add(loseHealth, iInvtPanelC);
		
		iInvtPanelC.gridy = 1;
		invtPanel.add(restore, iInvtPanelC);
		
		iInvtPanelC.gridy = 2;
		invtPanel.add(hello, iInvtPanelC);
		
		iInvtPanelC.gridy = 3;
		invtPanel.add(jorah, iInvtPanelC);
		
		////////////////////////////////////////////////////////////////////
		enterButtonC.gridx = 2;
		enterButtonC.gridy = 1;
		enterButtonC.weightx = .4;
		enterPanel.setPreferredSize(new Dimension(100,100));
		enterButtonC.anchor = GridBagConstraints.WEST;
		frame.add(enterPanel, enterButtonC);
		//******************************************************************
		enterButtonC.gridx = 0;
		enterButtonC.gridy = 0;
		enterPanel.add(enterButton, enterButtonC);
		
		/////////////////////////////////////////////////////////////////////
		chooseC.gridy = 0;
		chooseFrame.add(continueButton, chooseC);
		chooseC.gridy = 1;
		chooseFrame.add(newGameButton, chooseC);
		chooseC.gridy = 2;
		chooseFrame.add(deleteButton, chooseC);
		chooseC.gridy = 3;
		chooseFrame.add(quitButton, chooseC);
		
		try {
			Scanner sc = new Scanner(saveFile);
			if (sc.hasNextLine() == false) {
				continueButton.setEnabled(false);
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/////////////////////////////////////////////////////////////////////
		splashC.fill = GridBagConstraints.BOTH;
		
		/////////////////////////////////////////////////////////////////////
		
		saveOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//TODO give options for save areas
					PrintWriter writer = new PrintWriter(saveFile);
					writer.println(health.getHealth());
					writer.println(location);
					writer.close();
				} catch (FileNotFoundException e1) {
					//TODO Auto generated blah blah
					e1.printStackTrace();
				}
			}
		});
		
		openOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadGame(saveFile);
			}
		});
		
		cutOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeText.cut();
			}
		});
		
		copyOption.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				if (scrollText.hasFocus()) {
					scrollText.copy();
				}
				if (writeText.hasFocus()) {
					writeText.copy();
				}
			}
		});
		
		pasteOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeText.paste();
			}
		});
		
		writeText.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (writeText.getText().length() == 0) {
					} else {
						String toAdd = writeText.getText();
						scrollText.append("\n\n > " + toAdd);
						int choice = Integer.parseInt(toAdd);
						//scrollText.append("\n\n" + map.getNodeAt(choice).getEvent());
						//scrollText.append("\n" + map.getNodeAt(choice).getOptions());
						location = choice;
					}
		        }
				if (e.getKeyCode()==KeyEvent.VK_UP) {
					//This method should add the last written command in the writeText box
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					writeText.setText("");
				}
			}
		});
		
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String toAdd = writeText.getText();
				scrollText.append("\n\n > " + toAdd);
				writeText.setText("");
				int choice = Integer.parseInt(toAdd);
				//scrollText.append("\n\n" + map.getNodeAt(choice).getEvent());
				//scrollText.append("\n" + map.getNodeAt(choice).getOptions());
				location = choice;
			}
		});
		
		loseHealth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int current = health.getHealth() - 1;
				if (current > 0) {
					health.setColor(0, current, Color.WHITE);
					health.setHealth(current);
					health.repaint();
				} else {
					health.setColor(0, current, Color.WHITE);
					writeText.setBackground(Color.GRAY);
					writeText.setForeground(Color.RED);
					writeText.setText("WASTED");
					if (JOptionPane.showOptionDialog(null, "        GAME OVER\n Return to main menu?", null, 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) 
							== JOptionPane.YES_OPTION) {
						frame.dispose();
						chooseFrame.setVisible(true);
					} else {
						frame.dispose();
						System.exit(0);
					}
				}
			}
		});
		
		restore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = health.getHealth(); i < health.getMaxHealth(); i++) {
					health.setColor(0, i, Color.PINK);
					health.setHealth(health.getHealth() + 1);
					health.repaint();
				}
			}
		});
		
		hello.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (scrollText.getText().equals("")) {
					scrollText.setText(scrollText.getText() + "Hello World");
				} else {
					scrollText.setText(scrollText.getText() + "\nHello World");
				}
			}
		});
		
		jorah.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (scrollText.getText().equals("")) {
					scrollText.setText(scrollText.getText() + "SHINE BRIGHT LIKE A JORAH");
				} else {
					scrollText.setText(scrollText.getText() + "\nSHINE BRIGHT LIKE A JORAH");
				}
			}
		});
		
		continueButton.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				loadGame(saveFile);
			}
		});
		
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				health.setHealth(health.getMaxHealth());
				for (int i = 0; i < health.getMaxHealth(); i ++) {
					health.setColor(0, i, Color.PINK);
				}
				location = 1;
				scrollText.setText("This is a framework for a basic text adventure");
				scrollText.setText(scrollText.getText() + map.printWelcome());
				writeText.setText("");
				writeText.setBackground(Color.WHITE);
				frame.setMinimumSize(new Dimension(925, 600));
				frame.pack();
				frame.setVisible(true);
				chooseFrame.dispose();
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter overWrite = new PrintWriter("SaveFile");
					overWrite.print("");
					overWrite.close();
					continueButton.setEnabled(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showOptionDialog(null, "Are you sure you want to quit?", null, 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) 
						== JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
		});
		
		
		
		chooseFrame.setVisible(true);
	}
	
	public void loadGame(File saveFile) {
		try {
			Scanner read = new Scanner(saveFile);
			try {
				health.setHealth(read.nextInt());
				read.close();
				for (int i = 0; i < health.getHealth(); i++) {
					health.setColor(0, i, Color.PINK);
				}
				for (int i = health.getHealth(); i < health.getMaxHealth(); i++) {
					health.setColor(0, i, Color.WHITE);
				}
				writeText.setText("");
				writeText.setBackground(Color.WHITE);
				writeText.setForeground(Color.BLACK);
				scrollText.setText("");
				frame.setMinimumSize(new Dimension(925, 600));
				frame.pack();
				frame.repaint();
				frame.setVisible(true);
				chooseFrame.dispose();
			} catch (NoSuchElementException E) {
				scrollText.setText("No saved game. Starting new game:\n\n" + scrollText.getText());
				frame.setMinimumSize(new Dimension(925, 600));
				frame.pack();
				frame.setVisible(true);
				chooseFrame.dispose();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
