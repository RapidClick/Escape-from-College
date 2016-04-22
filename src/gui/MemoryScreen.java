package gui;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GraphicsDevice.WindowTranslucency.*;
import java.io.File;

import javax.swing.*;

public class MemoryScreen extends JPanel {
	
	public MemoryScreen(String title) {
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setSize(500, 300);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		setBackground(Color.GRAY);
		if (title.equalsIgnoreCase("save")) {
			JLabel save = new JLabel("Save");
			c.gridy = 0;
			add(save, c);
			c.anchor = GridBagConstraints.CENTER;
			String buttonName;
			String fileName;
			for (int i = 0; i < GUI4.getNumMemSlots(); i++) {
				buttonName = "Slot " + (i+1);
				fileName = "Save" + (i+1);
				c.gridy = (i+1);
				add(new MemorySlotButton(buttonName, new File(fileName), 0), c);
			}
		}
		if (title.equalsIgnoreCase("load")) {
			JLabel load = new JLabel("Load");
			c.gridy = 0;
			add(load, c);
			c.anchor = GridBagConstraints.CENTER;
			String buttonName;
			String fileName;
			for (int i = 0; i < GUI4.getNumMemSlots(); i++) {
				buttonName = "Slot " + (i+1);
				fileName = "Save" + (i+1);
				c.gridy = (i+1);
				add(new MemorySlotButton(buttonName, new File(fileName), 1), c);
			}
		}
		if (title.equalsIgnoreCase("delete")) {
			JLabel delete = new JLabel("Delete");
			c.gridy = 0;
			add(delete, c);
			c.anchor = GridBagConstraints.CENTER;
			String buttonName;
			String fileName;
			for (int i = 0; i < GUI4.getNumMemSlots(); i++) {
				buttonName = "Slot " + (i+1);
				fileName = "Save" + (i+1);
				c.gridy = (i+1);
				add(new MemorySlotButton(buttonName, new File(fileName), 1), c);
			}
		}
	}
	
	

}
