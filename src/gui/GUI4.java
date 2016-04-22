package gui;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import java.util.Scanner;

public class GUI4 {
	
	private static int numberOfMemSlots = 4;
	private JFrame frame;
	private JDesktopPane mainMenu;
	private JDesktopPane playPane;
	private JDesktopPane quickMenu;
	private MemoryScreen saveScreen;
	private MemoryScreen loadScreen;
	private MemoryScreen deleteScreen;
	
	public GUI4() {
	
		frame = new JFrame("Escape From College");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(925, 600);
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
		
		deleteScreen.setVisible(true);
		frame.setContentPane(deleteScreen);
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
	
	

}
