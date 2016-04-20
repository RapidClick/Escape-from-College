package gui;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

@SuppressWarnings("serial")
public class MemorySlotButton extends JButton {
	
	public MemorySlotButton(String name, File saveTo) {
		super(name);
		setSize(150, 40);
		setPreferredSize(getSize());
		setMinimumSize(getSize());
		setMaximumSize(getSize());
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.loadGame(saveTo);
			}
		});
	}

}
