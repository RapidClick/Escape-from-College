package escapeFromCollege;
import gui.GUI;

import java.io.File;

public class TestDriverGMap {
	
	public static void main(String[] args){
		File save = new File("Save1");
		GameMap g = new GameMap();
		GUI gooey = new GUI(save, g);
		//g.play();
		
	}

}