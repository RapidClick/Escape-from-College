package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.lang.String;

import javax.swing.*;

public class GUI4 {
	
	private JFrame frame;
	private JDesktopPane mainMenu;
	private PlayPane playPane;
	private QuickMenu quickMenu;
	private MemoryScreen saveScreen;
	private MemoryScreen loadScreen;
	private MemoryScreen deleteScreen;
	private File save1 = new File("Save1");
	private File save2 = new File("Save2");
	private File save3 = new File("Save3");
	private File save4 = new File("Save4");
	private File lastUsed = new File("LastUsed");
	private Scanner readLastUsed;
	private PrintWriter writeLastUsed;
	
	public GUI4() throws FileNotFoundException {
	
		frame = new JFrame("Escape From College");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 650);
		frame.setMinimumSize(new Dimension(1100, 650));
		frame.setResizable(false);
		
		mainMenu = new JDesktopPane();
		mainMenu.setLayout(new GridBagLayout());
		frame.add(mainMenu);
		playPane = new PlayPane();
		frame.add(playPane);
		
		quickMenu = new QuickMenu();
		frame.add(quickMenu);
		
		saveScreen = new MemoryScreen("Save");
		frame.add(saveScreen);
		loadScreen = new MemoryScreen("Load");
		frame.add(loadScreen);
		deleteScreen = new MemoryScreen("Delete");
		frame.add(deleteScreen);
		
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
		
		readLastUsed = new Scanner(lastUsed);
		if (readLastUsed.hasNextLine() == false) {
			continueButton.setEnabled(false);
		}
		
		
		//MAIN MENU BUTTON LISTENERS ////////////////////////////////////////////////////////////
		
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					startGame(getLastUsedFile());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
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
		
		
		for (int i = 1; i <= loadScreen.getNumButtons(); i++) {
			loadScreen.getButtonAt(i).addActionListener(
					new LoadButtonListener(loadScreen.getButtonAt(i).getFile()));
		}
		
		for (int i = 1; i <= deleteScreen.getNumButtons(); i++) {
			deleteScreen.getButtonAt(i).addActionListener(
					new DeleteButtonListener(deleteScreen.getButtonAt(i).getFile(), i));
		}
		
		for (int i = 1; i <= saveScreen.getNumButtons(); i++) {
			saveScreen.getButtonAt(i).addActionListener(
					new SaveButtonListener(saveScreen.getButtonAt(i).getFile()));
		}
		
		
		
		playPane.addKeyListener(new QuickMenuListener());
		playPane.getWriteText().addKeyListener(new QuickMenuListener());
		quickMenu.addKeyListener(new QuickMenuListener());
		
		
		
		frame.setContentPane(mainMenu);
		frame.setVisible(true);
		mainMenu.requestFocus();
	
	}
	
	
	
	//METHODS FOR USE IN GUI CONSTRUCTOR ////////////////////////////////////////////////////////////////
	
	private void checkForFiles(MemoryScreen toCheck) {
		for (int i = 1; i <= toCheck.getNumButtons(); i++) {
			if (toCheck.getButtonAt(i).hasFile() == false) {
				toCheck.getButtonAt(i).setEnabled(false);
			}
		}
	}
		
	
	public File getLastUsedFile() throws FileNotFoundException {
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
	
	public void setLastUsedFile(String write) throws FileNotFoundException {
		lastUsed = new File("LastUsed");
		writeLastUsed = new PrintWriter(lastUsed);
		writeLastUsed.print(write);
		writeLastUsed.close();
	}
	
	public void startGame() {
		playPane.setBounds(0, 0, frame.getWidth(), 628);
		playPane.getWriteText().setText("");
		playPane.getScrollText().setText("");
		quickMenu.getCursorBar().setCursorPosition(0);
		playPane.getMiniMap().resetCursor();
		frame.setContentPane(playPane);
		playPane.setVisible(true);
		playPane.requestFocus();
	}
	
	public void startGame(File toStartFrom) {
		//TODO load the game
		playPane.setBounds(0, 0, frame.getWidth(), 628);
		playPane.getWriteText().setText("");
		playPane.getScrollText().setText("");
		quickMenu.getCursorBar().setCursorPosition(0);
		frame.setContentPane(playPane);
		playPane.setVisible(true);
		playPane.requestFocus();
	}
	
	
	
	//MEMORY BUTTON LISTENERS ////////////////////////////////////////////////////////////////////////
	
	private class LoadButtonListener implements ActionListener {
		private File thisFile;
		public LoadButtonListener(File thisFileIn) {
			super();
			thisFile = thisFileIn;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				setLastUsedFile(thisFile.toString());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			startGame(thisFile);
		}
	}
	
	private class DeleteButtonListener implements ActionListener {
		private File thisFile;
		private int buttonNum;
		public DeleteButtonListener(File thisFileIn, int setButtonNum) {
			super();
			thisFile = thisFileIn;
			buttonNum = setButtonNum;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				PrintWriter delete = new PrintWriter(thisFile);
				delete.print("");
				delete.close();
				deleteScreen.getButtonAt(buttonNum).setEnabled(false);
				if (getLastUsedFile().toString().equalsIgnoreCase(thisFile.toString())) {
					setLastUsedFile("");
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class SaveButtonListener implements ActionListener {
		private File thisFile;
		public SaveButtonListener(File thisFileIn) {
			super();
			thisFile = thisFileIn;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Scanner fileReader = new Scanner(thisFile);
				if (fileReader.hasNextLine()) {
					if (JOptionPane.showConfirmDialog(frame, "Saving to this save slot will overwrite "
							+ "its current data.\nWould you like to overwrite this save?", null,
							JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					}
				}
				fileReader.close();
				//TODO save the data
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			try {
				setLastUsedFile(thisFile.toString());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private class QuickMenuListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				if (frame.getContentPane().equals(quickMenu)) {
					frame.setContentPane(playPane);
					playPane.getWriteText().requestFocus();
				} else {
					quickMenu.setBounds(frame.getWidth()/5, frame.getHeight()/5, quickMenu.getWidth(),
							quickMenu.getHeight());
					frame.setContentPane(quickMenu);
					quickMenu.requestFocus();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				switch (quickMenu.getCursorBar().getPosition()) {
				case 0:
					frame.setContentPane(playPane);
					playPane.getWriteText().requestFocus();
					break;
				case 1:
					GridBagConstraints doneButtonC = new GridBagConstraints();
					doneButtonC.gridy = 5;
					doneButtonC.weightx = 1;
					doneButtonC.anchor = GridBagConstraints.LAST_LINE_END;
					JButton cancel = new JButton("Cancel");
					saveScreen.add(cancel, doneButtonC);
					cancel.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.setContentPane(playPane);
							//frame.setContentPane(quickMenu);
							//quickMenu.requestFocus();
							playPane.getWriteText().requestFocus();
							saveScreen.remove(cancel);
						}
					});
					saveScreen.setBounds(frame.getWidth()/4, frame.getHeight()/4,
							frame.getWidth()/2, frame.getHeight()/2);
					frame.setContentPane(saveScreen);
					break;
				case 2:
					checkForFiles(loadScreen);
					doneButtonC = new GridBagConstraints();
					doneButtonC.gridy = 5;
					doneButtonC.weightx = 1;
					doneButtonC.anchor = GridBagConstraints.LAST_LINE_END;
					cancel = new JButton("Cancel");
					loadScreen.add(cancel, doneButtonC);
					cancel.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.setContentPane(playPane);
							playPane.getWriteText().requestFocus();
							//frame.setContentPane(quickMenu);
							//quickMenu.requestFocus();
							loadScreen.remove(cancel);
						}
					});
					loadScreen.setBounds(frame.getWidth()/4, frame.getHeight()/4,
							frame.getWidth()/2, frame.getHeight()/2);
					frame.setContentPane(loadScreen);
					break;
				case 3:
					//if (JOptionPane.showOptionDialog(frame, "Are you sure you want to return to the main"
						//	+ " menu?\nAny unsaved progress will be lost!", null, 
							//JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) 
							//== JOptionPane.YES_OPTION) {
						frame.setContentPane(mainMenu);
						playPane.validate();
						playPane.revalidate();
						mainMenu.validate();
						mainMenu.revalidate();
						frame.validate();
						frame.revalidate();
						mainMenu.setVisible(true);
						frame.setVisible(true);
					//}
					break;
				case 4:
					if (JOptionPane.showOptionDialog(null, "Are you sure you want to quit?\n"
							+ "Any unsaved progress will be lost!", null, 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) 
							== JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					break;
				}
			}
		}
		public void keyReleased(KeyEvent e) {
		}
	}
	
	
}
