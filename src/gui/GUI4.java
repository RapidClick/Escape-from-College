package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class GUI4 {
	
	private static int numberOfMemSlots = 4;
	private JFrame frame;
	private JDesktopPane mainMenu;
	private JDesktopPane playPane;
	private JDesktopPane quickMenu;
	private MemoryScreen saveScreen;
	private MemoryScreen loadScreen;
	private MemoryScreen deleteScreen;
	private File lastSaveFile;
	
	public GUI4() {
	
		frame = new JFrame("Escape From College");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(950, 650);
		frame.setMinimumSize(frame.getSize());
		
		mainMenu = new JDesktopPane();
		mainMenu.setLayout(new GridBagLayout());
		
		JButton continueButton = new JButton("Continue");
		JButton newGameButton = new JButton("New Game");
		JButton loadButton = new JButton("Load");
		JButton deleteButton = new JButton("Delete");
		JButton quitButton = new JButton("Quit");
		
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
		
		playPane = new JDesktopPane();
		playPane.setLayout(new GridBagLayout());
		
		saveScreen = new MemoryScreen("Save");
		frame.add(saveScreen);
		loadScreen = new MemoryScreen("Load");
		frame.add(loadScreen);
		deleteScreen = new MemoryScreen("Delete");
		frame.add(deleteScreen);
		
		quickMenu = new JDesktopPane();
		quickMenu.setLayout(new GridBagLayout());
		
		
		
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO finish this method (File lastSaveFile should help)
			}
		});
		
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkForFiles(loadScreen);
				GridBagConstraints doneButtonC = new GridBagConstraints();
				doneButtonC.gridy = 5;
				doneButtonC.weightx = 1;
				//doneButtonC.weighty = 1;
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
				//TODO fix this alignment
				loadScreen.setBounds(frame.getWidth()/4, frame.getHeight()/4,
						loadScreen.getWidth(), loadScreen.getHeight());
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
						frame.setContentPane(mainMenu);
						deleteScreen.remove(done);
					}
				});
				//TODO fix this alignment
				deleteScreen.setBounds(frame.getWidth()/4, frame.getHeight()/4,
						deleteScreen.getWidth(), deleteScreen.getHeight());
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
		
		
		mainMenu.setVisible(true);
		frame.setContentPane(mainMenu);
		frame.setVisible(true);
	}
	
	private void newGame() {
		//TODO
	}
	
	public static void loadGame(File saveFile) {
		//TODO
	}
	
	public static int getNumMemSlots() {
		return numberOfMemSlots;
	}
	
	public void checkForFiles(MemoryScreen toCheck) {
		for (int i = 1; i <= toCheck.getNumButtons(); i++) {
			if (toCheck.getButtonAt(i).hasFile() == false) {
				toCheck.getButtonAt(i).setEnabled(false);
			}
		}
	}
	
	

}
