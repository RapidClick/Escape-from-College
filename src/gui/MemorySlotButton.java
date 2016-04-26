package gui;

import javax.swing.JButton;
import java.io.*;
import java.util.Scanner;

public class MemorySlotButton extends JButton {
	
	private File linkedFile;
	private boolean hasFile;
	private int type;
	private Scanner fileChecker;
	
	/**
	 * 
	 * @param originalName
	 * @param setFileTo
	 * @param type if type == 0 it is a save; if == 1 it is a load; if == 2 it is a delete
	 */
	public MemorySlotButton(String originalName, File setFile) {
		super(originalName);
		linkedFile = setFile;
		hasFile = false;
		setSize(150, 40);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
	}
	
	public boolean hasFile() {
		try {
			fileChecker = new Scanner(linkedFile);
			if (fileChecker.hasNextLine()) {
				hasFile = true;
			}
		} catch (FileNotFoundException e) {
			System.out.println("hasFile() check failed");
			e.printStackTrace();
		}
		return hasFile;
	}
	
	public File getFile() {
		return linkedFile;
	}
	
}
