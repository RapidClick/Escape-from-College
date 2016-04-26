package gui;

import java.awt.*;
import java.io.File;
import javax.swing.*;

//TODO check out imports

public class MemoryScreen extends JDesktopPane {
	
	private int numButtons;
	private MemorySlotButton slot1;
	private MemorySlotButton slot2;
	private MemorySlotButton slot3;
	private MemorySlotButton slot4;
	
	public MemoryScreen(String title) {
		super();
		numButtons = 4;	//TODO make sure this method stays up to date so that button enabalization stays current
		setLayout(new GridBagLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints c = new GridBagConstraints();
		setSize(500, 325);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setBackground(Color.GRAY);
		if (title.equalsIgnoreCase("save")) {
			JLabel save = new JLabel("Save");
			//TODO save.setBounds(1, 1, 40, 40);
			c.gridy = 0;
			c.anchor = GridBagConstraints.PAGE_START;
			add(save, c);
			c.anchor = GridBagConstraints.CENTER;
			slot1 = new MemorySlotButton("Slot 1", new File("Save1"));
			c.gridy = 1;
			add(slot1, c);
			slot2 = new MemorySlotButton("Slot 2", new File("Save2"));
			c.gridy = 2;
			add(slot2, c);
			slot3 = new MemorySlotButton("Slot 3", new File("Save3"));
			c.gridy = 3;
			add(slot3, c);
			slot4 = new MemorySlotButton("Slot 4", new File("Save4"));
			c.gridy = 4;
			add(slot4, c);
		}
		if (title.equalsIgnoreCase("load")) {
			JLabel load = new JLabel("Load");
			c.gridy = 0;
			c.weighty = 1;
			c.anchor = GridBagConstraints.PAGE_START;
			add(load, c);
			c.anchor = GridBagConstraints.CENTER;
			slot1 = new MemorySlotButton("Slot 1", new File("Save1"));
			c.gridy = 1;
			add(slot1, c);
			slot2 = new MemorySlotButton("Slot 2", new File("Save2"));
			c.gridy = 2;
			add(slot2, c);
			slot3 = new MemorySlotButton("Slot 3", new File("Save3"));
			c.gridy = 3;
			add(slot3, c);
			slot4 = new MemorySlotButton("Slot 4", new File("Save4"));
			c.gridy = 4;
			add(slot4, c);
		}
		if (title.equalsIgnoreCase("delete")) {
			JLabel delete = new JLabel("Delete");
			c.gridy = 0;
			c.weighty = 1;
			c.anchor = GridBagConstraints.PAGE_START;
			add(delete, c);
			c.anchor = GridBagConstraints.CENTER;
			c.weighty = 1;
			slot1 = new MemorySlotButton("Slot 1", new File("Save1"));
			c.gridy = 1;
			add(slot1, c);
			slot2 = new MemorySlotButton("Slot 2", new File("Save2"));
			c.gridy = 2;
			add(slot2, c);
			slot3 = new MemorySlotButton("Slot 3", new File("Save3"));
			c.gridy = 3;
			add(slot3, c);
			slot4 = new MemorySlotButton("Slot 4", new File("Save4"));
			c.gridy = 4;
			add(slot4, c);
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
