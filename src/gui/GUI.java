package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import escapeFromCollege.GameMap;

import java.util.*;

public class GUI {
	
	private int location = 1;
	private static JFrame frame;
	private static JFrame chooseFrame;
	private static JTextArea scrollText;
	private static JTextArea writeText;
	private static JPanel backGround = new JPanel();
	
	public GUI(File saveFile, GameMap map) {
		
		StatBox health = new StatBox("Health", Color.LIGHT_GRAY, Color.PINK);
		
		Dimension defaultDim = new Dimension(925, 600);
		
		frame = new JFrame("Basic Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(defaultDim);
		frame.setLayout(new GridBagLayout());
		
		chooseFrame = new JFrame("Main Menu");
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
		
		MemoryScreen saveSlots = new MemoryScreen("Save");
		MemoryScreen loadSlots = new MemoryScreen("Load");
		MemoryScreen deleteSlots = new MemoryScreen("Delete");
		
		
		JButton hello = new JButton("Hello");
		JButton restore = new JButton("Restore");
		JButton jorah = new JButton("Jorah");
		JButton loseHealth = new JButton("Lose Health");
		JButton enterButton = new JButton("Enter");
		
		JButton continueButton = new JButton("Continue");
		JButton loadButton = new JButton("Load");
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
		//healthPanel.setPreferredSize(new Dimension(1, 38));
		//healthPanel.setBackground(Color.LIGHT_GRAY);
		statPanel.add(health, healthPanelC);
		
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
		chooseFrame.add(loadButton, chooseC);
		chooseC.gridy = 2;
		chooseFrame.add(newGameButton, chooseC);
		chooseC.gridy = 3;
		chooseFrame.add(deleteButton, chooseC);
		chooseC.gridy = 4;
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
					writer.println(health.getCurrentStatLvl());
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
				int current = health.getCurrentStatLvl() - 1;
				if (current > 0) {
					health.setCurrentStatLvl(current);
				} else {
					health.setCurrentStatLvl(current);
					writeText.setBackground(Color.GRAY);
					writeText.setForeground(Color.RED);
					writeText.setText("WASTED");
					if (JOptionPane.showOptionDialog(null, "        GAME OVER\n Return to main menu?", null, 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) 
							== JOptionPane.YES_OPTION) {
						frame.dispose();
						chooseFrame.remove(loadSlots);
						//chooseFrame.remove(backgroundPanel);
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
				int max = 
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
		
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addMemPanel(loadSlots, chooseFrame);
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
	
	public static void loadGame(File saveFile) {
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
				chooseFrame.setVisible(false);
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
	
	public void addMemPanel(MemoryScreen memPanel, JFrame backFrame) {
		backGround = new JPanel();
		GridBagConstraints backGroundC = new GridBagConstraints();
		GridBagConstraints memPanelC = new GridBagConstraints();
		backGround.setSize(backFrame.getSize());
		backGroundC.anchor = GridBagConstraints.CENTER;
		backGroundC.fill = GridBagConstraints.BOTH;
		backGroundC.weighty = 1;
		backGroundC.weightx = 1;
		backFrame.add(backGround, backGroundC);
		memPanelC.gridy = 0;
		File slot1 = new File("Save1");
		File slot2 = new File("Save2");
		File slot3 = new File("Save3");
		memPanel.add(new MemorySlotButton("Slot 1", slot1), memPanelC);
		memPanelC.gridy = 2;
		memPanel.add(new MemorySlotButton("Slot 2", slot2), memPanelC);
		memPanelC.gridy = 4;
		memPanel.add(new MemorySlotButton("Slot 3", slot3), memPanelC);
		memPanelC.anchor = GridBagConstraints.CENTER;
		memPanelC.fill = GridBagConstraints.BOTH;
		backGround.add(memPanel, memPanelC);
		backFrame.setContentPane(backGround);
	}

}