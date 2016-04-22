package gui;

import java.awt.GridBagLayout;
import java.io.*;

import javax.swing.*;

import java.util.Scanner;

public class GUI4 {
	
	private static int numberOfMemSlots = 4;
	private JFrame frame;
	private JDesktopPane mainMenu;
	private JDesktopPane playPane;
	private JDesktopPane memoryPane;
	private JDesktopPane quickMenu;
	
	public GUI4() {
	
		frame = new JFrame("Escape From College");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainMenu = new JDesktopPane();
		mainMenu.setLayout(new GridBagLayout());
		
		playPane = new JDesktopPane();
		playPane.setLayout(new GridBagLayout());
		
		memoryPane = new JDesktopPane();
		memoryPane.setLayout(new GridBagLayout());
		
		quickMenu = new JDesktopPane();
		quickMenu.setLayout(new GridBagLayout());
		
		
	
	
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
