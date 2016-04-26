package escapeFromCollege;
import gui.GUI;
import gui.GUI3;
import gui.GUI4;

import java.io.File;
import java.io.FileNotFoundException;

public class TestDriverGMap {
	
	public static void main(String[] args) throws FileNotFoundException{
		File save = new File("Save1");
<<<<<<< HEAD
		GameMap2 g = new GameMap2();
		//GUI gooey = new GUI(save, g);
		g.play();
=======
		GameMap g = new GameMap();
		GUI4 gooey = new GUI4();
		//g.play();
>>>>>>> de39473478d01a1019a971eb5fba3804df5a210a
		
	}
}