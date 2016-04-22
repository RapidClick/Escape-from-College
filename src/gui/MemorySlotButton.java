package gui;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class MemorySlotButton extends JButton {
	
	private File fileTo;
	private boolean hasFile;
	
	/**
	 * 
	 * @param originalName
	 * @param setFileTo
	 * @param type if type == 0 it is a save; if == 1 it is a load; if == 2 it is a delete
	 */
	public MemorySlotButton(String originalName, File setFileTo, int setType) {
		super(originalName);
		fileTo = setFileTo;
		hasFile = false;
		setSize(150, 40);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		if (setType == 0) {
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PrintWriter save;
					try {
						save = new PrintWriter(fileTo);
						//TODO print things that will save game
						save.close();
						hasFile = true;
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		} else if (setType == 1) {
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					GUI4.loadGame(fileTo);
				}
			});
		} else if (setType == 2) {
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PrintWriter delete;
					try {
						delete = new PrintWriter(fileTo);
						delete.print("");
						delete.close();
						hasFile = false;
						setEnabled(false);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		} else {
			throw new RuntimeException("This button needs to be set to save, load, or delete a"
					+ "function, intiger set in method call is not accepted");
		}
	}
	
	public boolean hasFile() {
		try {
			Scanner fileCheck = new Scanner(fileTo);
			if (fileCheck.hasNextLine() == true) {
				hasFile = true;
			} else {
				hasFile = false;
			}
			fileCheck.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasFile;
	}

}
