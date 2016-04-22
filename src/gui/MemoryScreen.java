package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import com.sun.glass.ui.Window;

//TODO check out imports

public class MemoryScreen extends JDesktopPane {
	
	private int numButtons;
	private MemorySlotButton slot1;
	private MemorySlotButton slot2;
	private MemorySlotButton slot3;
	private MemorySlotButton slot4;
	
	public MemoryScreen(String title) {
		super();
		numButtons = 0;
		setLayout(new GridBagLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints c = new GridBagConstraints();
		setSize(500, 300);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		setBackground(Color.GRAY);
		if (title.equalsIgnoreCase("save")) {
			JLabel save = new JLabel("Save");
			//TODO save.setBounds(1, 1, 40, 40);
			c.gridy = 0;
			c.anchor = GridBagConstraints.PAGE_START;
			add(save, c);
			c.anchor = GridBagConstraints.CENTER;
			slot1 = new MemorySlotButton("Slot 1", new File("Save1"), 0);
			c.gridy = 1;
			add(slot1, c);
			slot2 = new MemorySlotButton("Slot 2", new File("Save2"), 0);
			c.gridy = 2;
			add(slot2, c);
			slot3 = new MemorySlotButton("Slot 3", new File("Save3"), 0);
			c.gridy = 3;
			add(slot3, c);
			slot4 = new MemorySlotButton("Slot 4", new File("Save4"), 0);
			c.gridy = 4;
			add(slot4, c);
			numButtons = 4;
		}
		if (title.equalsIgnoreCase("load")) {
			JLabel load = new JLabel("Load");
			c.gridy = 0;
			c.anchor = GridBagConstraints.PAGE_START;
			add(load, c);
			c.anchor = GridBagConstraints.CENTER;
			slot1 = new MemorySlotButton("Slot 1", new File("Save1"), 1);
			c.gridy = 1;
			add(slot1, c);
			slot2 = new MemorySlotButton("Slot 2", new File("Save2"), 1);
			c.gridy = 2;
			add(slot2, c);
			slot3 = new MemorySlotButton("Slot 3", new File("Save3"), 1);
			c.gridy = 3;
			add(slot3, c);
			slot4 = new MemorySlotButton("Slot 4", new File("Save4"), 1);
			c.gridy = 4;
			add(slot4, c);
			numButtons = 4;
		}
		if (title.equalsIgnoreCase("delete")) {
			JLabel delete = new JLabel("Delete");
			c.gridy = 0;
			c.weighty = 1;
			c.anchor = GridBagConstraints.PAGE_START;
			add(delete, c);
			c.anchor = GridBagConstraints.CENTER;
			c.weighty = 1;
			slot1 = new MemorySlotButton("Slot 1", new File("Save1"), 2);
			c.gridy = 1;
			add(slot1, c);
			slot2 = new MemorySlotButton("Slot 2", new File("Save2"), 2);
			c.gridy = 2;
			add(slot2, c);
			slot3 = new MemorySlotButton("Slot 3", new File("Save3"), 2);
			c.gridy = 3;
			add(slot3, c);
			slot4 = new MemorySlotButton("Slot 4", new File("Save4"), 2);
			c.gridy = 4;
			add(slot4, c);
			numButtons = 4;
		}
	}
	
	public MemorySlotButton getButtonAt(int index) {
		switch (index) {
		case 1:
			return slot1;
		case 2:
			return slot2;
		case 3:
			return slot3;
		case 4:
			return slot4;
		default:
			throw new RuntimeException("no button here");
		}
	}
	
	public int getNumButtons() {
		return numButtons;
	}
	
	
	
	

}
