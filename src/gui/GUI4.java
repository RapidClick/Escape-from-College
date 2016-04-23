package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GUI4 {
	
	private JFrame frame;
	private JDesktopPane mainMenu;
	private PlayPane playPane;
	//TODO will this be inside playPane or the frame?
	//private JDesktopPane quickMenu;
	private MemoryScreen saveScreen;
	private MemoryScreen loadScreen;
	private MemoryScreen deleteScreen;
	private static File save1 = new File("Save1");;
	private static File save2 = new File("Save2");
	private static File save3 = new File("Save3");;
	private static File save4 = new File("Save4");
	private static File lastUsed = new File("LastUsed");
	private static Scanner readLastUsed;
	private static PrintWriter writeLastUsed;
	
	public GUI4() throws FileNotFoundException {
	
		frame = new JFrame("Escape From College");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 650);
		frame.setMinimumSize(new Dimension(1000, 650));
		
		mainMenu = new JDesktopPane();
		mainMenu.setLayout(new GridBagLayout());
		frame.add(mainMenu);
		playPane = new PlayPane();
		frame.add(playPane);
		
		saveScreen = new MemoryScreen("Save");
		frame.add(saveScreen);
		loadScreen = new MemoryScreen("Load");
		frame.add(loadScreen);
		deleteScreen = new MemoryScreen("Delete");
		frame.add(deleteScreen);
		
		//lastUsed = new File("LastUsed");
		
		JButton continueButton = new JButton("Continue");
		JButton newGameButton = new JButton("New Game");
		JButton loadButton = new JButton("Load");
		JButton deleteButton = new JButton("Delete");
		JButton quitButton = new JButton("Quit");
		//TODO remove this button after using to test code
		MemorySlotButton saveButton = new MemorySlotButton("save", save1, 0);
		
		GridBagConstraints mainMenuC = new GridBagConstraints();
		mainMenuC.anchor = GridBagConstraints.CENTER;
		mainMenuC.gridy = 0;
		mainMenu.add(continueButton, mainMenuC);
		mainMenuC.gridy = 1;
		mainMenu.add(newGameButton, mainMenuC);
		mainMenuC.gridy = 2;
		mainMenu.add(loadButton, mainMenuC);
		mainMenuC.gridy = 3;
		mainMenu.add(deleteButton, mainMenuC);
		mainMenuC.gridy = 4;
		mainMenu.add(quitButton, mainMenuC);
		//TODO remove this button after done testing
		mainMenuC.gridy = 5;
		mainMenu.add(saveButton, mainMenuC);
		
		readLastUsed = new Scanner(lastUsed);
		if (readLastUsed.hasNextLine() == false) {
			continueButton.setEnabled(false);
		}
		
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO startGame(getLastUsedFile);
			}
		});
		
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkForFiles(loadScreen);
				GridBagConstraints doneButtonC = new GridBagConstraints();
				doneButtonC.gridy = 5;
				doneButtonC.weightx = 1;
				doneButtonC.anchor = GridBagConstraints.LAST_LINE_END;
				JButton cancel = new JButton("Cancel");
				loadScreen.add(cancel, doneButtonC);
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setContentPane(mainMenu);
						loadScreen.remove(cancel);
					}
				});
				loadScreen.setBounds(frame.getWidth()/4, frame.getHeight()/4,
						frame.getWidth()/2, frame.getHeight()/2);
				frame.setContentPane(loadScreen);
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkForFiles(deleteScreen);
				GridBagConstraints doneButtonC = new GridBagConstraints();
				doneButtonC.gridy = 5;
				doneButtonC.weightx = 1;
				doneButtonC.anchor = GridBagConstraints.LAST_LINE_END;
				JButton done = new JButton("Done");
				deleteScreen.add(done, doneButtonC);
				done.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							lastUsed = new File("LastUsed");
							readLastUsed = new Scanner(lastUsed);
							if (readLastUsed.hasNextLine() == false) {
								continueButton.setEnabled(false);
							} else {
								continueButton.setEnabled(true);
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setContentPane(mainMenu);
						deleteScreen.remove(done);
					}
				});
				deleteScreen.setBounds(frame.getWidth()/4, frame.getHeight()/4,
						frame.getWidth()/2, frame.getHeight()/2);
				frame.setContentPane(deleteScreen);
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
		
		
		
		frame.setContentPane(mainMenu);
		frame.setVisible(true);
	
	}
	
	private void checkForFiles(MemoryScreen toCheck) {
		for (int i = 1; i <= toCheck.getNumButtons(); i++) {
			if (toCheck.getButtonAt(i).hasFile() == false) {
				toCheck.getButtonAt(i).setEnabled(false);
			}
		}
	}
		
	
	public static File getLastUsedFile() throws FileNotFoundException {
		lastUsed = new File("LastUsed");
		readLastUsed = new Scanner(lastUsed);
		String check = readLastUsed.nextLine();
		if (check.equalsIgnoreCase("Save1")) {
			lastUsed = save1;
		} else if (check.equalsIgnoreCase("Save2")) {
			lastUsed = save2;
		} else if (check.equalsIgnoreCase("Save3")) {
			lastUsed = save3;
		} else if (check.equalsIgnoreCase("Save4")) {
			lastUsed = save4;
		}
		return lastUsed;
	}
	
	public static void setLastUsedFile(String write) throws FileNotFoundException {
		lastUsed = new File("LastUsed");
		writeLastUsed = new PrintWriter(lastUsed);
		writeLastUsed.print(write);
		writeLastUsed.close();
	}
	
	public void startGame() {
		
	}
	
	public void startGame(File toStartFrom) {
		if (frame.getContentPane().equals(loadScreen)) {
			frame.setContentPane(mainMenu);
			//TODO load the game
			frame.setContentPane(playPane);
		} else {
			
		}
	}
	
	/*
	 * TODO set up a method that handles returning to mainMenu - this method should check to see if
	 * continueButton should be enabled
	 */
}
