package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatBox extends JPanel {
	
	private StatBar bar;
	private JTextField titleField;
	private int full;
	
	public StatBox(String title, Color boxColorIn, Color barColorIn) {
		setSize(285,38); //y =38
		setLayout(new GridBagLayout());
		setPreferredSize(getSize());
		setBackground(boxColorIn);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//JLabel titleField = new JLabel(title);
		JTextField titleField = new JTextField();
		titleField.setBackground(boxColorIn);
		titleField.setEditable(false);
		titleField.setText(title);
		if (titleField.getText().length() < 7) {
			for (int i = titleField.getText().length(); i < 7; i++) {
				titleField.setText(titleField.getText() + " ");
			}
		}
		Font titleFont = new Font("Courier", Font.BOLD, 14);
		titleField.setFont(titleFont);
		
		bar = new StatBar(barColorIn);
		bar.setBackground(boxColorIn);
		
		full = bar.getFullLenght();
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		add(titleField, c);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		add(bar, c);
	}
	
	public StatBox(String title, Color boxColorIn, Color barColorIn, int multiplier) {
		setSize(1,38);
		setLayout(new GridBagLayout());
		setPreferredSize(getSize());
		setBackground(boxColorIn);
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		titleField = new JTextField();
		titleField.setBackground(boxColorIn);
		titleField.setEditable(false);
		titleField.setText(title);
		
		bar = new StatBar(barColorIn, multiplier);
		bar.setBackground(boxColorIn);
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		add(titleField, c);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		add(bar, c);
	}
	
	public int getCurrentStatLvl() {
		return bar.getStatLvl();
	}
	
	public void setCurrentStatLvl(int newLvl) {
		bar.setStatLvl(newLvl);
	}
	
	public void setFull() {
		bar.setStatLvl(full);
	}
}
