package gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class MemorySlotButton extends JButton {
	
	private File fileTo;
	private boolean hasFile;
	private Scanner fileChecker;
	
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
						if (hasFile()) {
							//TODO show "do you want to overwrite" message
						} else {
							save = new PrintWriter(fileTo);
							GUI4.setLastUsedFile(fileTo.toString());
							//TODO print things that will save game and remove random print to fileTo
							save.print("save");
							save.close();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		} else if (setType == 1) {
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						GUI4.setLastUsedFile(fileTo.toString());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					//TODO
					//TODO
					//TODO
					//TODO startGame(fileTo);
					/*
					 * to start game either:
					 * startGame has to be static and this starts making everything static
					 * OR
					 * every layer needs to be given the layer it is being added to so it can modify upwards
					 * ^(will this work/is it ok?)
					 */
				}
			});
		} else if (setType == 2) {
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						PrintWriter delete = new PrintWriter(fileTo);
						delete.print("");
						delete.close();
						setEnabled(false);
						if ((GUI4.getLastUsedFile().toString()).equalsIgnoreCase(fileTo.toString())) {
							GUI4.setLastUsedFile("");
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		} else {
			throw new RuntimeException("This button needs to be set to a save, load, or delete"
					+ "function, intiger set in method call is not accepted");
		}
	}
	
	public boolean hasFile() {
		try {
			fileChecker = new Scanner(fileTo);
			if (fileChecker.hasNextLine()) {
				hasFile = true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasFile;
	}

}
